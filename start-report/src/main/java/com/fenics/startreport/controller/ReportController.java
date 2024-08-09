package com.fenics.startreport.controller;

import com.fenics.startreport.dto.ReportDTO;
import com.fenics.startreport.dto.ReportJobDTO;
import com.fenics.startreport.models.Job;
import com.fenics.startreport.models.Report;
import com.fenics.startreport.service.JobsService;
import com.fenics.startreport.service.ReportsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
@Api(value = "reports controller", description = "start reports")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ReportController {

    private final JobsService jobsService;
    private final ReportsService reportsService;

    @Autowired
    private KafkaTemplate<String, ReportJobDTO> template;

    @PostMapping
    @ApiOperation(value = "create report", notes = "Returns job for report")
    public ResponseEntity<Object> createReports(@Valid @RequestBody ReportDTO reportDTO) {
        try {
            // makes a job to track if done or not
            Job job = new Job();
            job.setStatus("pending");
            job.setResource("report");
            Job savedJob = jobsService.createJob(job);

            // calls a report
            ReportJobDTO message = new ReportJobDTO();
            message.setReportDTO(reportDTO);
            message.setResourceId(job.getResourceId());
            System.out.println("sending kafka message");
            template.send("processreport", message);
            return new ResponseEntity<>(savedJob, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Object> getReportById(@PathVariable(name = "reportId") int reportId) {
        Optional<Report> reportOptional = reportsService.findReportById(reportId);
        if (reportOptional.isPresent()) {
            Report report = reportOptional.get();
            return new ResponseEntity<>(report, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("There is no report against this ID", HttpStatus.NOT_FOUND);
        }

    }

}
