package com.fenics.startreport.repository;

import com.fenics.startreport.models.Job;
import com.fenics.startreport.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportsRepository extends JpaRepository<Report, Integer>{

}