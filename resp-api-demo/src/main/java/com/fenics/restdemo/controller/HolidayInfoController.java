package com.fenics.restdemo.controller;

import com.fenics.restdemo.model.HolidayRequestDTO;
import com.fenics.restdemo.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/holiday")
@Validated
@RequiredArgsConstructor
public class HolidayInfoController {

    private final HolidayService holidayService;


//    @GetMapping({"/ccy/date", "/date/ccy"})
    @GetMapping
    public Object getAllHolidayInfoByCcyDate(@RequestParam(name = "ccy", required=false) String ccy, @RequestParam(name = "date", required=false) String date) {
        if (ccy == null && date == null) {
            return new ResponseEntity<>(holidayService.getAllHolidayInfo(), HttpStatus.OK);
        }
        else if (date == null) {
            return new ResponseEntity<>(holidayService.getAllHolidayInfoByCcy(ccy), HttpStatus.OK);
        }
        else if (ccy == null) {
            return new ResponseEntity<>(holidayService.getAllHolidayInfoByDate(date), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(holidayService.getAllHolidayInfoByCcyDate(ccy, date), HttpStatus.OK);
        }
    }

    @PostMapping
    public Object saveHolidayInfo(@RequestParam(name = "ccy") String ccy, @RequestParam(name = "date") String date) {
        try {
            HolidayRequestDTO holidayRequestDTO = new HolidayRequestDTO(ccy, LocalDate.parse(date));
            Object savedHolidayInfo = holidayService.saveHolidayInfo(holidayRequestDTO);
            return new ResponseEntity<>(savedHolidayInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public Object deleteHolidayInfo(@RequestParam(name = "ccy") String ccy, @RequestParam(name = "date") String date) {
        try {
            Object savedHolidayInfo = holidayService.deleteHolidayInfo(ccy, LocalDate.parse(date));
            return new ResponseEntity<>(savedHolidayInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
