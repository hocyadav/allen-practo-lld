package io.hari.lld.services;

import io.hari.lld.domains.Clinic;
import io.hari.lld.repo.BaseRepo;
import io.hari.lld.repo.ClinicRepo;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Service
@Validated
public class ClinicService extends BaseService<Clinic>{

    private final ClinicRepo clinicRepo;

    public ClinicService(BaseRepo<Clinic> repo, ClinicRepo clinicRepo) {
        super(repo);
        this.clinicRepo = clinicRepo;
    }


    public void addOnlyClinic(@Valid String clinicName){
        Clinic clinic = Clinic.builder().name(clinicName).build();
        this.save(clinic);
        System.out.println("new clinic added !!");
    }

    public void addNewCenterLocationToClinic(Long clinicId, String location){
        Optional<Clinic> byId = this.findById(clinicId);
        byId.ifPresent(clinic -> {
            Map<String, List<Long>> clinicCenterDoctors = clinic.getClinicCenters().getClinicCenterDoctors();
            if (!clinicCenterDoctors.containsKey(location)) {
                clinicCenterDoctors.put(location, new LinkedList<>());
                this.save(clinic);
            } else {
                System.out.println("location present, not adding !!");
            }
        });
    }

}
