package com.fenics.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "holidays", schema = "dbo")
public class Holiday {

    @EmbeddedId
    private HolidayKey id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime ts;

    public void setId(HolidayKey id) {
        this.id = id;
    }
    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    public HolidayKey getId() {
        return id;
    }
    public LocalDateTime getTs() {
        return ts;
    }
}
