package com.fenics.restdemo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PrefsKey implements Serializable {

    @Column(nullable = false)
    @NotBlank
    @Size(min = 3, max = 4, message = "ccy must be 3 or 4 characters")
    private String userName;

    @Column(nullable = false)
    @NotBlank
    private String prefName;

    public String getUserName() {
        return userName;
    }
    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}