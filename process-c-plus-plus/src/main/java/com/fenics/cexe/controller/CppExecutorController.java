package com.fenics.cexe.controller;

import com.fenics.cexe.service.RunExecutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CppExecutorController {

    @Autowired
    private RunExecutableService runExecutableService;

    @Autowired
    private KafkaTemplate<String, String> template;

    @GetMapping("/run-cpp")
    public List<String> runCpp() {
        try {
            return runExecutableService.runExecutable();
        } catch (Exception e) {
            e.printStackTrace();
            return Arrays.asList(e.getMessage());
        }
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        template.send("processexe", "runfindlogs");
        return "sent Kafka message";
    }
}
