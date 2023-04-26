package com.mtailor.meetricslambdafunction.config;

import com.mtailor.meetricslambdafunction.model.SQSEvent;
import com.mtailor.meetricslambdafunction.model.SQSMessage;
import com.mtailor.meetricslambdafunction.model.SQSMessageBody;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.serialization().registerType(SQSEvent.class);
        hints.serialization().registerType(SQSMessage.class);
        hints.serialization().registerType(SQSMessageBody.class);
    }
}
