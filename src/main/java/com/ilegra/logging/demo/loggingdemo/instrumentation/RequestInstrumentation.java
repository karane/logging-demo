package com.ilegra.logging.demo.loggingdemo.instrumentation;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestInstrumentation {
    private static final Logger logger = LoggerFactory.getLogger(RequestInstrumentation.class);
    private Counter requestCounter;

    public RequestInstrumentation() {

        requestCounter = Metrics.counter("app.request.counter", "app", "infra");

    }

    public void logIncommingRequest(String req) {
        requestCounter.increment();
        logger.info("New request {}.", req);
    }

    public void logEndOfRequest(String req) {
        logger.info("End of request {}.", req);
    }

}
