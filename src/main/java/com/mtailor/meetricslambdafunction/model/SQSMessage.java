package com.mtailor.meetricslambdafunction.model;

import java.io.Serializable;
import java.util.Map;

public class SQSMessage implements Serializable {

    String messageId;

    String receiptHandle;

    String body;

    Map<String, String> attributes;

    Map<String, String> messageAttributes;

    String md5OfBody;

    String eventSource;

    String eventSourceARN;

    String awsRegion;

    public SQSMessage() {
    }

    public String getMessageId() {
        return messageId;
    }

    public SQSMessage setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getReceiptHandle() {
        return receiptHandle;
    }

    public SQSMessage setReceiptHandle(String receiptHandle) {
        this.receiptHandle = receiptHandle;
        return this;
    }

    public String getBody() {
        return body;
    }

    public SQSMessage setBody(String body) {
        this.body = body;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public SQSMessage setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Map<String, String> getMessageAttributes() {
        return messageAttributes;
    }

    public SQSMessage setMessageAttributes(Map<String, String> messageAttributes) {
        this.messageAttributes = messageAttributes;
        return this;
    }

    public String getMd5OfBody() {
        return md5OfBody;
    }

    public SQSMessage setMd5OfBody(String md5Body) {
        this.md5OfBody = md5Body;
        return this;
    }

    public String getEventSource() {
        return eventSource;
    }

    public SQSMessage setEventSource(String eventSource) {
        this.eventSource = eventSource;
        return this;
    }

    public String getEventSourceARN() {
        return eventSourceARN;
    }

    public SQSMessage setEventSourceARN(String eventSourceARN) {
        this.eventSourceARN = eventSourceARN;
        return this;
    }

    public String getAwsRegion() {
        return awsRegion;
    }

    public SQSMessage setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
        return this;
    }

    @Override
    public String toString() {
        return "SQSMessage{" +
                "messageId='" + messageId + '\'' +
                ", receiptHandle='" + receiptHandle + '\'' +
                ", body='" + body + '\'' +
                ", attributes=" + attributes +
                ", messageAttributes=" + messageAttributes +
                ", md5OfBody='" + md5OfBody + '\'' +
                ", eventSource='" + eventSource + '\'' +
                ", eventSourceARN='" + eventSourceARN + '\'' +
                ", awsRegion='" + awsRegion + '\'' +
                '}';
    }
}
