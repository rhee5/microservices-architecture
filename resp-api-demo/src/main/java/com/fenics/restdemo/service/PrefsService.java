package com.fenics.restdemo.service;

import com.fenics.restdemo.model.*;
import com.fenics.restdemo.repository.PrefsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrefsService {

    private final PrefsRepository prefsRepository;

    public Object getAllPrefsData() {
        return prefsRepository.findAll().stream().collect(Collectors.toList());
    }

    public Object getAllPrefsDataPV(String PV) {
        return prefsRepository.findAllByPV(PV).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataPN(String PN) {
        return prefsRepository.findAllByPN(PN).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataUN(String UN) {
        return prefsRepository.findAllByUN(UN).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataUNPN(String UN, String PN) {
        return prefsRepository.findAllByUNPN(UN, PN).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataUNPV(String UN, String PV) {
        return prefsRepository.findAllByUNPV(UN, PV).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataPNPV(String PN, String PV) {
        return prefsRepository.findAllByPNPV(PN, PV).stream()
                .collect(Collectors.toList());
    }

    public Object getAllPrefsDataUNPNPV(String UN, String PN, String PV) {
        return prefsRepository.findAllByUNPNPV(UN, PN, PV).stream().collect(Collectors.toList());
//                .map(pref -> Collections.singletonList(pref)) // Wrap in a list
//                .orElse(Collections.emptyList());
    }


    public Object savePrefsData(String UN, String PN, String PV) {
        List<Prefs> prefsData = prefsRepository.findAllByUNPNPV(UN, PN, PV);
        if (prefsData.size() >= 1) {
            return new ResponseEntity<>("preference already in database", HttpStatus.BAD_REQUEST);
        }

        Prefs prefs = new Prefs();
        prefs.setUserName(UN);
        prefs.setPrefName(PN);
        prefs.setPrefValue(PV);
        Prefs savedPrefs = prefsRepository.save(prefs);
        return savedPrefs;
    }

    public Object deletePrefsData(String UN, String PN, String PV) {
        List<Prefs> prefsData = prefsRepository.findAllByUNPNPV(UN, PN, PV);
        if (prefsData.size() == 0) {
            return new ResponseEntity<>("Holiday doesn't exist", HttpStatus.BAD_REQUEST);
        }

        prefsRepository.deletePrefsData(UN, PV, PN);
        return prefsData;
    }
}