package io.hari.lld.services;

import io.hari.lld.domains.Clinic;
import io.hari.lld.domains.Doctor;
import io.hari.lld.exceptions.NotFoundException;
import io.hari.lld.repo.BaseRepo;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Service
@Validated
public class DoctorService extends BaseService<Doctor>{

    private final ClinicService clinicService;

    public DoctorService(BaseRepo<Doctor> repo, ClinicService clinicService) {
        super(repo);
        this.clinicService = clinicService;
    }

    /**
     * Approach:
     * validate clinic
     * validate doc
     * fetch clinic location and add dr id
     *
     * @param doctor
     * @param clinicId
     * @param clinicLocation
     */
    public void addDoctorToClinic(@NotNull Doctor doctor,
                                  @NotNull Long clinicId,
                                  @NotNull String clinicLocation){
        Optional<Clinic> fetchedClinic = clinicService.findById(clinicId);
        if (!fetchedClinic.isPresent()) throw new NotFoundException("not found clinic" + clinicId);

        fetchedClinic.ifPresent(clinic -> {
            Map<String, List<Long>> clinicCenterDoctors = clinic.getClinicCenters().getClinicCenterDoctors();
            clinicCenterDoctors.get(clinicLocation).add(doctor.getId());
            clinicService.save(clinic);
        });
        System.out.println("Dr added to clinic !!");
    }
}
