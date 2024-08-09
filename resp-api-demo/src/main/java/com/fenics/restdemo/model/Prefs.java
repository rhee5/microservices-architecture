package com.fenics.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "prefs", schema = "dbo")
public class Prefs {

    @EmbeddedId
    private PrefsKey prefsKey;

    @Column(name = "prefValue", columnDefinition = "varchar(MAX)")
    private String prefValue;

    public Prefs () {
        prefsKey = new PrefsKey();
        prefValue = "";
    }

    public String getUserName() {
        return prefsKey.getUserName();
    }

    public void setUserName(String userName) {
        prefsKey.setUserName(userName);
    }

    public String getPrefName() {
        return prefsKey.getPrefName();
    }

    public void setPrefName(String prefName) {
        prefsKey.setPrefName(prefName);
    }

    public String getPrefValue() {
        return prefValue;
    }

    public void setPrefValue(String prefValue) {
        this.prefValue = prefValue;
    }
}