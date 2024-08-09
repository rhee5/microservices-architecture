package com.fenics.restdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "conventions", schema = "dbo")
public class Conventions {

    @EmbeddedId
    private ConventionsKey conventionsKey;

    public Conventions() {
        conventionsKey = new ConventionsKey();
    }

    public void setKey(String ccy, String ctr) {
        conventionsKey.setCtr(ctr);
        conventionsKey.setCcy(ccy);
    }

    @Column(name = "prec")
    private Short prec;

    @Column(name = "precCode")
    private Short precCode;

    @Column(name = "ctrPrec")
    private Short ctrPrec;

    @Column(name = "ctrPrecCode")
    private Short ctrPrecCode;

    public void setPrec(Short prec, Short precCode, Short ctrPrec, Short ctrPrecCode) {
        this.prec = prec;
        this.precCode = precCode;
        this.ctrPrec = ctrPrec;
        this.ctrPrecCode = ctrPrecCode;
    }

    @Column(name = "depoInWorkdays")
    private Short depoInWorkdays;

    @Column(name = "ctrDepoInWorkdays")
    private Short ctrDepoInWorkdays;

    public void setDepo(Short depoInWorkdays, Short ctrDepoInWorkdays) {
        this.depoInWorkdays = depoInWorkdays;
        this.ctrDepoInWorkdays = ctrDepoInWorkdays;
    }

    @Column(name = "spotDays")
    private Short spotDays;

    @Column(name = "spotDaysCode")
    private Short spotDaysCode;

    @Column(name = "spotFormat")
    private Short spotFormat;

    @Column(name = "spotFormatCode")
    private Short spotFormatCode;

    @Column(name = "ctrSpotFormat")
    private Short ctrSpotFormat;

    @Column(name = "ctrSpotFormatCode")
    private Short ctrSpotFormatCode;

    public void setSpot(Short spotDays, Short spotDaysCode, Short spotFormat,
                        Short spotFormatCode, Short ctrSpotFormat, Short ctrSpotFormatCode) {
        this.spotDays = spotDays;
        this.spotDaysCode = spotDaysCode;
        this.spotFormat = spotFormat;
        this.spotFormatCode = spotFormatCode;
        this.ctrSpotFormat = ctrSpotFormat;
        this.ctrSpotFormatCode = ctrSpotFormatCode;
    }

    @Column(name = "yearDays")
    private Short yearDays;

    @Column(name = "yearDaysCode")
    private Short yearDaysCode;

    @Column(name = "ctrYearDays")
    private Short ctrYearDays;

    @Column(name = "ctrYearDaysCode")
    private Short ctrYearDaysCode;

    public void setYears(Short yearDays, Short yearDaysCode, Short ctrYearDays, Short ctrYearDaysCode) {
        this.yearDays = yearDays;
        this.yearDaysCode = yearDaysCode;
        this.ctrYearDays = ctrYearDays;
        this.ctrYearDaysCode = ctrYearDaysCode;
    }

    @Column(name = "alignedCcy", length = 10)
    private String alignedCcy;

    @Column(name = "alignedCcyCode")
    private Short alignedCcyCode;

    @Column(name = "ctrAlignedCcy", length = 10)
    private String ctrAlignedCcy;

    @Column(name = "ctrAlignedCcyCode")
    private Short ctrAlignedCcyCode;

    public void setAligned(String alignedCcy, Short alignedCcyCode, String ctrAlignedCcy, Short ctrAlignedCcyCode) {
        this.alignedCcy = alignedCcy;
        this.alignedCcyCode = alignedCcyCode;
        this.ctrAlignedCcy = ctrAlignedCcy;
        this.ctrAlignedCcyCode = ctrAlignedCcyCode;
    }

    @Column(name = "swapFeedPrec")
    private Short swapFeedPrec;

    @Column(name = "swapFeedPrecCode")
    private Short swapFeedPrecCode;

    @Column(name = "swapFeedCtrPrec")
    private Short swapFeedCtrPrec;

    @Column(name = "swapFeedCtrPrecCode")
    private Short swapFeedCtrPrecCode;

    public void setSwap(Short swapFeedPrec, Short swapFeedPrecCode, Short swapFeedCtrPrec, Short swapFeedCtrPrecCode) {
        this.swapFeedPrec = swapFeedPrec;
        this.swapFeedPrecCode = swapFeedPrecCode;
        this.swapFeedCtrPrec = swapFeedCtrPrec;
        this.swapFeedCtrPrecCode = swapFeedCtrPrecCode;
    }

    @Column(name = "crossArb")
    private Integer crossArb;

    @Column(name = "whichDelta")
    private Integer whichDelta;

    @Column(name = "fwdFactor")
    private Float fwdFactor;

    @Column(name = "fwdFactorCode")
    private Short fwdFactorCode;

    @Column(name = "isConstantForward")
    private Short isConstantForward;

    public void setRest(Integer crossArb, Integer whichDelta, Float fwdFactor, Short fwdFactorCode, Short isConstantForward) {
        this.crossArb = crossArb;
        this.whichDelta = whichDelta;
        this.fwdFactor = fwdFactor;
        this.fwdFactorCode = fwdFactorCode;
        this.isConstantForward = isConstantForward;
    }

    public String getCcy() {
        return conventionsKey.getCcy();
    }
    public String getCtr() {
        return conventionsKey.getCtr();
    }
}
