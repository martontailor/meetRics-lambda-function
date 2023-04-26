package com.mtailor.meetricslambdafunction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AwsClientConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().region(Region.EU_WEST_1).build();
    }

    @Bean
    public String tableName() {
        return "meetrics-metrics";
    }

}
