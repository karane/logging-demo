package com.ilegra.logging.demo.loggingdemo.service;

import com.ilegra.logging.demo.loggingdemo.instrumentation.LoggingInstrumentation;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class LoggingService {
    private static final String USERNAME = "username";

    @Autowired
    private LoggingInstrumentation instrumentation;

    @Scheduled(fixedDelay = 1500)
    public void userLogging1() throws InterruptedException {
        final String user = "Silvio.Santos";
        MDC.put(USERNAME, user);

        instrumentation.beforeUserLogin(user);

        Thread.sleep((long) (Math.random()) * 1000);

        instrumentation.afterUserLogin(user);

        MDC.remove(USERNAME);
    }


    @Scheduled(fixedDelay = 1400)
    public void userLogging2() throws InterruptedException {
        final String user = "Fausto.Silva";
        MDC.put(USERNAME, user);

        instrumentation.beforeUserLogin(user);

        Thread.sleep((long) (Math.random()) * 1000);

        instrumentation.afterUserLogin(user);

        MDC.remove(USERNAME);
    }
}
