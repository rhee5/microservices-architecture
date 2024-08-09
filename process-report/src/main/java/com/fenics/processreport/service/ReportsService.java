package com.fenics.processreport.service;

import com.fenics.processreport.dto.ReportDTO;
import com.fenics.processreport.dto.ReportJobDTO;
import com.fenics.processreport.models.Job;
import com.fenics.processreport.models.Report;
import com.fenics.processreport.repository.JobsRepository;
import com.fenics.processreport.repository.ReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class ReportsService {
    private final ReportsRepository reportsRepository;
    private final JobsRepository jobsRepository;

    public Optional<Report> findReportById(int id) {
        return reportsRepository.findById(id);
    }

    public void doReport(ReportJobDTO info) throws InterruptedException {
        Thread.sleep(10000); // sleep 10 seconds
        int resourceId = info.getResourceId();
        ReportDTO reportDTO = info.getReportDTO();

        //save report
        Report report = new Report();
        report.setInfo(reportDTO);
        report.setId(resourceId);
        Report saveReport = reportsRepository.save(report);

        //update job
        System.out.println("here!");
        Optional<Job> jobOptional = jobsRepository.findByResourceId(resourceId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setStatus("done");
            jobsRepository.save(job);
        }
    }
}
