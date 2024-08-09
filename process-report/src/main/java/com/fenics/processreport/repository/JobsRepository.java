package com.fenics.processreport.repository;

import com.fenics.processreport.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT j FROM Job j WHERE j.resourceId = :resourceId")
    Optional<Job> findByResourceId(@Param("resourceId") int resourceId);

}
