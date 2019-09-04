package com.ilegra.logging.demo.loggingdemo.instrumentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestInstrumentation {
    private static final Logger logger = LoggerFactory.getLogger(RequestInstrumentation.class);

    @Autowired
    private DataDogClient dataDogClient;

    public void logIncommingRequest(String req) {
        logger.info("New request {}.", req);
    }

    public void logEndOfRequest(String req) {
        logger.info("End of request {}.", req);
    }

}
