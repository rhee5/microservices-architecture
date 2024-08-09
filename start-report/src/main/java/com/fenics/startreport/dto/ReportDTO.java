package com.fenics.startreport.dto;

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
}
