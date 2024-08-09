package com.fenics.processreport.dto;

import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDTO {
    private String content;
    private String reportName;
    private int scheduled;
    private Date timestamp;
    private String userid;
    private Long lifeSpan;
    private int status;
    private List<String> bookIds;

    public String getContent() {
        return content;
    }
    public String getReportName() {
        return reportName;
    }
    public int getScheduled() {
        return scheduled;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getUserid() {
        return userid;
    }
    public Long getLifeSpan() {
        return lifeSpan;
    }
    public int getStatus() {
        return status;
    }
    public List<String> getBookIds() {
        return bookIds;
    }
}
