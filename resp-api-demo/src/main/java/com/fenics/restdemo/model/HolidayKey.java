package com.fenics.restdemo.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HolidayKey implements Serializable {

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 4, message = "ccy must be 3 or 4 characters")
    private String ccy;

    @Column(nullable = false,name="holidayDate")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate holidayDate;

    public LocalDate getHolidayDate() {
        return holidayDate;
    }
    public String getCcy() {
        return ccy;
    }
}
