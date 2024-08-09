package com.fenics.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HolidayResponseDTO {
    private String ccy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate holidayDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime ts;

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
    public void setHolidayDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }
}
