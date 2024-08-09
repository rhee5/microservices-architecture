package com.fenics.cexe.controller;

import com.fenics.cexe.service.RunExecutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Autowired
    private RunExecutableService runExecutableService;

    @KafkaListener(topics="processexe", groupId = "cplusplus")
    public void readMessage(String receivedMessage) throws IOException, InterruptedException {

        if (receivedMessage.equals("\"runfindlogs\"")) {
            System.out.println(runExecutableService.runExecutable());
        }

    }

}