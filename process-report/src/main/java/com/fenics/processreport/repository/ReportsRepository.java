package com.fenics.processreport.repository;

import com.fenics.processreport.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<Report, Integer>{

}