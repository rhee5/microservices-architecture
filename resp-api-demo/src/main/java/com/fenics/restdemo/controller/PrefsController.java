package com.fenics.restdemo.controller;

import com.fenics.restdemo.service.PrefsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prefs")
@Validated
public class PrefsController {

    private final PrefsService prefsService;

    public PrefsController(PrefsService prefsService) {
        this.prefsService = prefsService;
    }

    // problem with prefValue - only for ()
    @GetMapping
    public Object getPrefsData(@RequestParam(name = "userName", required=false) String UN,
                               @RequestParam(name = "prefName", required=false) String PN,
                               @RequestParam(name = "prefValue", required=false) String PV) {
        if (UN == null && PN == null && PV == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsData(), HttpStatus.OK);
        }
        else if (UN == null && PN == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataPV(PV), HttpStatus.OK);
        }
        else if (UN == null && PV == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataPN(PN), HttpStatus.OK);
        }
        else if (PN == null && PV == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataUN(UN), HttpStatus.OK);
        }

        else if (PV == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataUNPN(UN, PN), HttpStatus.OK);
        }
        else if (PN == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataUNPV(UN, PV), HttpStatus.OK);
        }
        else if (UN == null) {
            return new ResponseEntity<>(prefsService.getAllPrefsDataPNPV(PN, PV), HttpStatus.OK);
        }
        return new ResponseEntity<>(prefsService.getAllPrefsDataUNPNPV(UN, PN, PV), HttpStatus.OK);

    }

    @PostMapping
    public Object saveHolidayInfo(@RequestParam(name = "userName") String UN,
                                  @RequestParam(name = "prefName") String PN,
                                  @RequestParam(name = "prefValue") String PV) {
        try {
            System.out.println("here1");
            Object savedPrefsData = prefsService.savePrefsData(UN, PN, PV);
            System.out.println("here");
            return new ResponseEntity<>(savedPrefsData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public Object deleteHolidayInfo(@RequestParam(name = "userName") String UN,
                                    @RequestParam(name = "prefName") String PN,
                                    @RequestParam(name = "prefValue") String PV) {
        try {
            Object delPrefsData = prefsService.deletePrefsData(UN, PN, PV);
            return new ResponseEntity<>(delPrefsData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}