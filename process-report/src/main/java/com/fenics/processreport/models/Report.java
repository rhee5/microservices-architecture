package com.fenics.processreport.models;

import com.fenics.processreport.controller.StringListConverter;
import com.fenics.processreport.dto.ReportDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "reports", schema = "dbo")
public class Report {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @Column(name = "report_name")
    private String reportName;

    private int scheduled;

    private Date timestamp;

    @Column(name = "userid")
    private String userId;

    @Column(name = "life_span")
    private Long lifeSpan;

    private int status;

    @Column(name="book_ids")
    @Convert(converter = StringListConverter.class)
    private List<String> bookIds;

    public void setId(int resourceid) {
        id = resourceid;
    }

    public void setInfo(ReportDTO info) {
        content = info.getContent();
        reportName = info.getReportName();
        scheduled = info.getScheduled();
        timestamp = info.getTimestamp();
        userId = info.getUserid();
        lifeSpan = info.getLifeSpan();
        status = info.getStatus();
        bookIds = info.getBookIds();
    }
}
