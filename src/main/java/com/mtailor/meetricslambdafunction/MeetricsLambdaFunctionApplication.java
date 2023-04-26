package com.mtailor.meetricslambdafunction;

import com.mtailor.meetricslambdafunction.config.CustomRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(CustomRuntimeHints.class)
public class MeetricsLambdaFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetricsLambdaFunctionApplication.class, args);
    }

}
