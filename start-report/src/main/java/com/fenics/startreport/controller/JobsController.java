package com.fenics.startreport.controller;

import com.fenics.startreport.models.Job;
import com.fenics.startreport.service.JobsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/jobs")
@Validated
@RequiredArgsConstructor
public class JobsController {

    private final JobsService jobsService;

    @PostMapping
    public Object startReport() {
        System.out.println("here");
        try {
            // calls a report
            // makes a job to track if done or not
            Object savedJob = jobsService.newJob();
            return new ResponseEntity<>(savedJob, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("exception");
            return new ResponseEntity<>("wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{jobId}")
    public Object getJobById(@PathVariable(name = "jobId") Integer jobId, HttpServletResponse response) throws IOException {
        Optional<Job> jobOptional = jobsService.findJobById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            if (job.getStatus().equals("pending")) {
                return new ResponseEntity<>(job, HttpStatus.OK);
            }
            if (job.getStatus().equals("done")) {
                response.sendRedirect("/reports/" + job.getResourceId());
                return new ResponseEntity<>(HttpStatus.FOUND);
            }
            return new ResponseEntity<>(job, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no job against this ID", HttpStatus.NOT_FOUND);
        }
    }

}
