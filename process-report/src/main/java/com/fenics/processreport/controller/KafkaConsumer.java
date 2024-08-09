package com.fenics.processreport.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenics.processreport.dto.ReportJobDTO;
import com.fenics.processreport.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@RequiredArgsConstructor
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate<String, ReportJobDTO> template;

    private final ReportsService reportsService;

    @KafkaListener(topics="processreport", groupId = "report")
    public void readMessage(String receivedMessage) throws InterruptedException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ReportJobDTO reportJobDTO = objectMapper.readValue(receivedMessage, ReportJobDTO.class);
        System.out.println(receivedMessage);
        reportsService.doReport(reportJobDTO);
        System.out.println(reportJobDTO);
    }

}
