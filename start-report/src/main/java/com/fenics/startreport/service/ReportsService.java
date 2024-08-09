package com.fenics.startreport.service;

import com.fenics.startreport.models.Job;
import com.fenics.startreport.models.Report;
import com.fenics.startreport.repository.JobsRepository;
import com.fenics.startreport.repository.ReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportsService {
    private final ReportsRepository reportsRepository;

    public Optional<Report> findReportById(int id) {
        return reportsRepository.findById(id);
    }
}
