package io.hari.lld.controller;

import io.hari.lld.domains.Clinic;
import io.hari.lld.domains.helper.ClinicCenters;
import io.hari.lld.repo.ClinicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PractoController {

    private final ClinicRepo clinicService;

    @GetMapping
    public List<Clinic> getAllClinics(){
        HashMap<String, List<Long>> clinicCenterDoctors = new HashMap<>();
        clinicCenterDoctors.put("marathelli", new LinkedList<>());
        clinicCenterDoctors.put("hsr", new LinkedList<>());
        clinicService.save(Clinic.builder().name("clinic1")
                        .clinicCenters(ClinicCenters.builder()
                                .clinicCenterDoctors(clinicCenterDoctors)
                                .build())
                .build());
        return clinicService.findAll();
    }

    @PostMapping
    public Clinic addClinics(Clinic clinic){
        return clinicService.save(clinic);
    }






}
