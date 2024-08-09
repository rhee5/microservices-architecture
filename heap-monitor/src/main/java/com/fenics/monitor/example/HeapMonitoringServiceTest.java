package com.fenics.monitor.example;

/*
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.read.ListAppender;

import com.fenics.monitor.model.AlertRunnable;
import com.fenics.monitor.service.scheduled.HeapMonitoringService;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Import({HeapMonitoringService.class, AlertRunnable.class})
@EnableScheduling
public class HeapMonitoringServiceTest {

    public static void main(String[] args) {
        // for testing
        Logger logger = (Logger) LoggerFactory.getLogger(AlertRunnable.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        // Run service
        SpringApplication.run(HeapMonitoringServiceTest.class, args);

        // Use up memory space
        ArrayList<long[]> listArrays = new ArrayList<>();
        for (int i = 0; i < 7188000; i++) {
            long[] stuff = new long[100];
            listArrays.add(stuff);
        }

        // assert the logs were written
        assert(listAppender.list.size()>1);
        logger.detachAppender(listAppender);
    }
}
*/