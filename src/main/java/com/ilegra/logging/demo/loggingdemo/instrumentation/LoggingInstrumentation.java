package com.ilegra.logging.demo.loggingdemo.instrumentation;

import com.ilegra.logging.demo.loggingdemo.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoggingInstrumentation {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    private static final String APLICATION_LOGIN_QUANTITY = "aplication.login.quantity";

    @Autowired
    private DataDogClient dataDogClient;

    public void beforeUserLogin(String user) {
        logger.info("New user {} logged in.", user);
        dataDogClient.sentIndicator(APLICATION_LOGIN_QUANTITY, BigDecimal.valueOf(1));
    }

    public void afterUserLogin(String user) {
        logger.info("All setup for user {} done.", user);
    }

}
