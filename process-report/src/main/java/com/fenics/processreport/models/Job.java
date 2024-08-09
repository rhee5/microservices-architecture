package com.fenics.processreport.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs", schema = "dbo")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

    private String status;

    private String resource;

   // @Column(name = "resource_id")
    private Integer resourceId;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getJobId() {
        return jobId;
    }

    @PrePersist
    public void generateResourceId() {
        if (resourceId == null) {
            resourceId = new java.util.Random().nextInt(Integer.MAX_VALUE) + 1;
        }
    }

    public String getStatus() {
        return status;
    }

    public int getResourceId() {
        return resourceId;
    }

}
