package com.fenics.startreport.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "reports", schema = "dbo")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String reportName;
    private int scheduled;
    private Date timestamp;
    @Column(name = "userid")
    private String userId;
    private Long lifeSpan;
    private int status;
    private String bookIds;
}
