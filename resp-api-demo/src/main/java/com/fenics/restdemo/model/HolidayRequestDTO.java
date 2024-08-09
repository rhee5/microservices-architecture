package com.fenics.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HolidayRequestDTO {

    @NotBlank
    @Size(min = 3, max = 4)
    private String ccy;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate holidayDate;

    public String getCcy() {
        return ccy;
    }
    public LocalDate getHolidayDate() {
        return holidayDate;
    }
}
