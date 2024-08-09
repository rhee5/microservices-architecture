package com.fenics.startreport.service;

import com.fenics.startreport.models.Job;
import com.fenics.startreport.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobsService {

    private final JobsRepository jobsRepository;

    public Job newJob() {
        Job job = new Job();
        job.setStatus("pending");
        job.setResource("report");
        System.out.println("before repo");
        System.out.println(job.getJobId());
        Job savedJob = jobsRepository.save(job);
        System.out.println(savedJob);
        return savedJob;
    }

    public Job createJob(Job job) {
        return jobsRepository.save(job);
    }

    public Optional<Job> findJobById(Integer id) {
        return jobsRepository.findById(id);
    }

}
