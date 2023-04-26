package com.mtailor.meetricslambdafunction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SQSMessageBody implements Serializable {

    @JsonProperty("MetricId")
    String id;

    Long timestamp;

    String metricName;

    Double value;

    public SQSMessageBody() {
    }

    public String getId() {
        return id;
    }

    public SQSMessageBody setId(String id) {
        this.id = id;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public SQSMessageBody setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMetricName() {
        return metricName;
    }

    public SQSMessageBody setMetricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public SQSMessageBody setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "SQSMessageMetric{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", metricName='" + metricName + '\'' +
                ", value=" + value +
                '}';
    }
}
