package com.fenics.restdemo.controller;

import com.fenics.restdemo.model.Conventions;
import com.fenics.restdemo.service.ConventionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conventions")
@RequiredArgsConstructor
@Validated
public class ConventionsController {

    private final ConventionsService conventionsService;

    @GetMapping
    public Object getConventions(@RequestParam(name = "ccy", required=false) String ccy,
                               @RequestParam(name = "ctr", required=false) String ctr) {
        if (ccy == null && ctr == null) {
            return new ResponseEntity<>(conventionsService.getAllConventions(), HttpStatus.OK);
        }
        else if (ccy == null) {
            return new ResponseEntity<>(conventionsService.getAllConventionsCtr(ctr), HttpStatus.OK);
        }
        else if (ctr == null) {
            return new ResponseEntity<>(conventionsService.getAllConventionsCcy(ccy), HttpStatus.OK);
        }
        return new ResponseEntity<>(conventionsService.getAllConventionsCcyCtr(ccy, ctr), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveConventions(
            @RequestParam(name = "ccy") String ccy,
            @RequestParam(name = "ctr") String ctr,
            @RequestParam(name = "prec", required = false) Short prec,
            @RequestParam(name = "precCode", required = false) Short precCode,
            @RequestParam(name = "ctrPrec", required = false) Short ctrPrec,
            @RequestParam(name = "ctrPrecCode", required = false) Short ctrPrecCode,
            @RequestParam(name = "depoInWorkdays", required = false) Short depoInWorkdays,
            @RequestParam(name = "ctrDepoInWorkdays", required = false) Short ctrDepoInWorkdays,
            @RequestParam(name = "spotDays", required = false) Short spotDays,
            @RequestParam(name = "spotDaysCode", required = false) Short spotDaysCode,
            @RequestParam(name = "spotFormat", required = false) Short spotFormat,
            @RequestParam(name = "spotFormatCode", required = false) Short spotFormatCode,
            @RequestParam(name = "ctrSpotFormat", required = false) Short ctrSpotFormat,
            @RequestParam(name = "ctrSpotFormatCode", required = false) Short ctrSpotFormatCode,
            @RequestParam(name = "yearDays", required = false) Short yearDays,
            @RequestParam(name = "yearDaysCode", required = false) Short yearDaysCode,
            @RequestParam(name = "ctrYearDays", required = false) Short ctrYearDays,
            @RequestParam(name = "ctrYearDaysCode", required = false) Short ctrYearDaysCode,
            @RequestParam(name = "alignedCcy", required = false) String alignedCcy,
            @RequestParam(name = "alignedCcyCode", required = false) Short alignedCcyCode,
            @RequestParam(name = "ctrAlignedCcy", required = false) String ctrAlignedCcy,
            @RequestParam(name = "ctrAlignedCcyCode", required = false) Short ctrAlignedCcyCode,
            @RequestParam(name = "swapFeedPrec", required = false) Short swapFeedPrec,
            @RequestParam(name = "swapFeedPrecCode", required = false) Short swapFeedPrecCode,
            @RequestParam(name = "swapFeedCtrPrec", required = false) Short swapFeedCtrPrec,
            @RequestParam(name = "swapFeedCtrPrecCode", required = false) Short swapFeedCtrPrecCode,
            @RequestParam(name = "crossArb", required = false) Integer crossArb,
            @RequestParam(name = "whichDelta", required = false) Integer whichDelta,
            @RequestParam(name = "fwdFactor", required = false) Float fwdFactor,
            @RequestParam(name = "fwdFactorCode", required = false) Short fwdFactorCode,
            @RequestParam(name = "isConstantForward") Short isConstantForward) {

        try {
            Conventions conventions = new Conventions();
            conventions.setKey(ccy, ctr);
            conventions.setPrec(prec, precCode, ctrPrec, ctrPrecCode);
            conventions.setDepo(depoInWorkdays, ctrDepoInWorkdays);
            conventions.setSpot(spotDays, spotDaysCode, spotFormat, spotFormatCode, ctrSpotFormat, ctrSpotFormatCode);
            conventions.setYears(yearDays, yearDaysCode, ctrYearDays, ctrYearDaysCode);
            conventions.setAligned(alignedCcy, alignedCcyCode, ctrAlignedCcy, ctrAlignedCcyCode);
            conventions.setSwap(swapFeedPrec, swapFeedPrecCode, swapFeedCtrPrec, swapFeedCtrPrecCode);
            conventions.setRest(crossArb, whichDelta, fwdFactor, fwdFactorCode, isConstantForward);

            Object savedConventions = conventionsService.saveConventions(conventions);
            return new ResponseEntity<>(savedConventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public Object deleteHolidayInfo(@RequestParam(name = "ccy") String ccy,
                                    @RequestParam(name = "ctr") String ctr) {
        try {
            Object delConvention = conventionsService.deleteConvention(ccy, ctr);
            return new ResponseEntity<>(delConvention, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}