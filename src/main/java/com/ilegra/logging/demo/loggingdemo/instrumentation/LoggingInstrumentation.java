package com.ilegra.logging.demo.loggingdemo.instrumentation;

import com.ilegra.logging.demo.loggingdemo.service.LoggingService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingInstrumentation {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);
    private Counter userLoggings;

    public LoggingInstrumentation() {
        userLoggings = Metrics.counter("app.useraccess.count", "app", "domain");
    }

    public void beforeUserLogin(String user) {
        userLoggings.increment();
        logger.info("New user {} logged in.", user);
    }

    public void afterUserLogin(String user) {
        logger.info("All setup for user {} done.", user);
    }

    public void beforeListing() {
        userLoggings.increment();
        logger.info("New user {} logged in.");
    }
}
