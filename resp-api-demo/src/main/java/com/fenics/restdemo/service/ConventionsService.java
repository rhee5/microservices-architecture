package com.fenics.restdemo.service;

import com.fenics.restdemo.model.Conventions;
import com.fenics.restdemo.repository.ConventionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConventionsService {

    private final ConventionsRepository conventionsRepository;

    @Cacheable("conventionsInfo")
    public Object getAllConventions() {
        simulateSlowService();
        return conventionsRepository.findAll().stream().collect(Collectors.toList());
    }

    public void simulateSlowService() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public Object getAllConventionsCtr(String ctr) {
        return conventionsRepository.findAllByCtr(ctr).stream()
                .collect(Collectors.toList());
    }

    public Object getAllConventionsCcy(String ccy) {
        return conventionsRepository.findAllByCcy(ccy).stream()
                .collect(Collectors.toList());
    }

    public Object getAllConventionsCcyCtr(String ccy, String ctr) {
        return conventionsRepository.findAllByCcyCtr(ccy, ctr).stream()
                .collect(Collectors.toList());
    }

    public Object saveConventions(Conventions conventions) {
        List<Conventions> conventionData = conventionsRepository.findAllByCcyCtr(conventions.getCcy(), conventions.getCtr());
        if (conventionData.size() >= 1) {
            return new ResponseEntity<>("convention already in database", HttpStatus.BAD_REQUEST);
        }
        return conventionsRepository.save(conventions);
    }

    public Object deleteConvention(String ccy, String ctr) {
        List<Conventions> convention = conventionsRepository.findAllByCcyCtr(ccy, ctr);
        if (convention.size() == 0) {
            return new ResponseEntity<>("Holiday doesn't exist", HttpStatus.BAD_REQUEST);
        }
        conventionsRepository.deleteConvention(ccy, ctr);
        return convention;
    }
}