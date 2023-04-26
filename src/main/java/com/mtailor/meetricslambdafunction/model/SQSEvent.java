package com.mtailor.meetricslambdafunction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class SQSEvent implements Serializable {

    @JsonProperty("Records")
    List<SQSMessage> records;

    public List<SQSMessage> getRecords() {
        return records;
    }

    public SQSEvent setRecords(List<SQSMessage> records) {
        this.records = records;
        return this;
    }

    @Override
    public String toString() {
        return "SQSEvent{" +
                "records=" + records +
                '}';
    }
}
