package io.hari.lld;

import io.hari.lld.domains.Clinic;
import io.hari.lld.domains.Doctor;
import io.hari.lld.domains.Patient;
import io.hari.lld.domains.helper.ClinicCenters;
import io.hari.lld.domains.helper.DoctorSlots;
import io.hari.lld.repo.ClinicRepo;
import io.hari.lld.repo.DoctorRepo;
import io.hari.lld.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Profile("dev")
@Component
@RequiredArgsConstructor
public class DevTest {
    private final ClinicRepo clinicService;
    private final DoctorRepo doctorService;
    private final PatientRepo patientService;

    @PostConstruct
    public void foo(){
        System.out.println("hello");

        // add doctor
        Doctor doctor1 = Doctor.builder()
                .name("doctor 1")
                .specialization(Doctor.Specialization.heart)
                .build();

        Map<String, List<DoctorSlots.Slot>> slotsMap = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
//        slotsMap.put("bangalore", Arrays.asList(
//                DoctorSlots.Slot.builder()
//                        .startTime(now.toString())
//                        .endTime(now.s)
//                        .build()
//        ))
        Doctor doctor2 = Doctor.builder()
                .name("doctor 2")
                .specialization(Doctor.Specialization.heart)
                .doctorSlots(DoctorSlots.builder()
                        .map(slotsMap)
                        .build())
                .build();

        doctorService.save(doctor1);
        doctorService.save(doctor2);
        doctorService.findAll().forEach(doctor -> System.out.println("doctor = " + doctor));

        // add clinic

        Map<String, List<Long>> locationDr = new HashMap<>();
        locationDr.put("banaglore", Arrays.asList(doctor1.getId(), doctor2.getId()));
        Clinic clinic1 = Clinic.builder()
                .name("clinic 1")
                .clinicCenters(ClinicCenters.builder()
                        .clinicCenterDoctors(locationDr)
                        .build())
                .build();
        clinicService.save(clinic1);
        clinicService.findAll().forEach(clinic -> System.out.println("clinic = " + clinic));


        // find all clinic doctors
        clinicService.findAll().forEach(clinic -> System.out.println("clinic = " + clinic));




        // add patient
        patientService.save(Patient.builder()
                        .name("patient 1")
                        .dob(LocalDate.of(1990, 7 , 26).toString())
                .build());

        patientService.findAll().forEach(patient -> System.out.println("patient = " + patient));





    }
}
//
//1. Add Clinic Centre : CRUD
//
//        2. Add doctors to the clinic with their specialization :
//
//        3. Register the patient :  CRUD
//
//        4. List the doctors (fresh booking / filtered list having doctors whom were consulted in the past)
//
//        5. Do the booking