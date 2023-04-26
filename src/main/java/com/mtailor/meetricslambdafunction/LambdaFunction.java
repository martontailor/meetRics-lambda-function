package com.mtailor.meetricslambdafunction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtailor.meetricslambdafunction.model.SQSEvent;
import com.mtailor.meetricslambdafunction.model.SQSMessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class LambdaFunction implements Consumer<String> {
    private static final Logger log = LoggerFactory.getLogger(LambdaFunction.class);
    private static final int FIRST_ITEM = 0;
    private final DynamoDbClient dynamoDbClient;
    private final String tableName;


    public LambdaFunction(DynamoDbClient dynamoDbClient, String tableName) {
        this.dynamoDbClient = dynamoDbClient;
        this.tableName = tableName;
    }

    @Override
    public void accept(String event) {

        log.info("Event arrived: {}", event);

        PutItemResponse dynamoResponse = dynamoDbClient.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(getItem(event))
                .build());

    }

    private static Map<String, AttributeValue> getItem(final String event) {
        SQSMessageBody body;

        try {
            SQSEvent sqsEvent = new ObjectMapper().readValue(event, com.mtailor.meetricslambdafunction.model.SQSEvent.class);
            body = new ObjectMapper().readValue(sqsEvent.getRecords().get(FIRST_ITEM).getBody(), SQSMessageBody.class);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred during Message body JSON parsing", e);
            throw new RuntimeException(e);
        }

        return Map.of(
                "MetricId", AttributeValue.builder().s(body.getMetricName() + "-" + body.getTimestamp()).build(),
                "timestamp", AttributeValue.builder().n(String.valueOf(body.getTimestamp())).build(),
                "metricName", AttributeValue.builder().s(body.getMetricName()).build(),
                "value", AttributeValue.builder().s(String.valueOf(body.getValue())).build()
        );
    }
}
