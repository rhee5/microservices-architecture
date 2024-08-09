package com.fenics.restdemo.model;

import lombok.*;
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
public class ConventionsKey implements Serializable {

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 4, message = "ccy must be 3 or 4 characters")
    private String ccy;

    @Column(nullable = false,name="ctr")
    @NotBlank
    @Size(min = 3, max = 4, message = "ccy must be 3 or 4 characters")
    private String ctr;

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
    public String getCtr() {
        return ctr;
    }
    public String getCcy() {
        return ccy;
    }
}