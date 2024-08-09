package com.fenics.startreport.repository;

import com.fenics.startreport.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

}
