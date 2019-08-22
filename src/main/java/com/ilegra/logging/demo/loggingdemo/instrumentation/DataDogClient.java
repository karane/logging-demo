package com.ilegra.logging.demo.loggingdemo.instrumentation;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataDogClient {

    public void sentIndicator(String indicatorName, BigDecimal value) {
        System.out.println("Sending indicator " + indicatorName + " value: " + value);
    }
}
