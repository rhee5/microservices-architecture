package com.fenics.restdemo.service;

import com.fenics.restdemo.model.Holiday;
import com.fenics.restdemo.model.HolidayKey;
import com.fenics.restdemo.model.HolidayRequestDTO;
import com.fenics.restdemo.model.HolidayResponseDTO;
import com.fenics.restdemo.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HolidayService {

    private final HolidayRepository holidayRepository;

    @Cacheable("holidayInfo")
    public Object getAllHolidayInfo() {
        simulateSlowService();
        return holidayRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public void simulateSlowService() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public Object getAllHolidayInfoByCcy(String ccy) {
        return holidayRepository.findAllByCcy(ccy).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Object getAllHolidayInfoByDate(String date) {
        LocalDate formDate = LocalDate.parse(date);
        return holidayRepository.findAllByDate(formDate).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Object getAllHolidayInfoByCcyDate(String ccy, String date) {
        LocalDate dateForm = LocalDate.parse(date);
        return holidayRepository.findAllByCcyAndHolidayDate(ccy, dateForm)
                .map(holiday -> Collections.singletonList(convertToResponseDTO(holiday))) // Wrap in a list
                .orElse(Collections.emptyList());
    }

    public Object saveHolidayInfo(HolidayRequestDTO holidayRequestDTO) {
        Optional<Holiday> holidayInfo = holidayRepository.findAllByCcyAndHolidayDate(holidayRequestDTO.getCcy(), holidayRequestDTO.getHolidayDate());
        if (holidayInfo.isPresent()) {
            return new ResponseEntity<>("Holiday already exists", HttpStatus.BAD_REQUEST);
        }

        Holiday holiday = new Holiday();
        String ccy = holidayRequestDTO.getCcy();
        LocalDate holidayDate = holidayRequestDTO.getHolidayDate();
        holiday.setId(new HolidayKey(ccy, holidayDate));
        holiday.setTs(LocalDateTime.now().withSecond(0).withNano(0));
        Holiday savedHoliday = holidayRepository.save(holiday);
        return convertToResponseDTO(savedHoliday);
    }

    private Object convertToResponseDTO(Holiday holiday) {
        HolidayResponseDTO dto = new HolidayResponseDTO();
        dto.setCcy(holiday.getId().getCcy());
        dto.setHolidayDate(holiday.getId().getHolidayDate());
        dto.setTs(holiday.getTs());
        return dto;
    }

    public Object deleteHolidayInfo(String ccy, LocalDate holidayDate) {
        Object toRet = holidayRepository.findAllByCcyAndHolidayDate(ccy, holidayDate)
                .map(holiday -> Collections.singletonList(convertToResponseDTO(holiday))) // Wrap in a list
                .orElse(Collections.emptyList());

        Optional<Holiday> holidayInfo = holidayRepository.findAllByCcyAndHolidayDate(ccy, holidayDate);

        if (!holidayInfo.isPresent()) {
            return new ResponseEntity<>("Holiday doesn't exist", HttpStatus.BAD_REQUEST);
        }

        //holidayRepository.deleteAll(holidayInfo);
        holidayRepository.deleteByCcyDate(ccy, holidayDate);
        return toRet;
        //return new ResponseEntity<>("im lost", HttpStatus.BAD_GATEWAY);
    }
}
