package io.hari.lld.services;

import io.hari.lld.domains.Patient;
import io.hari.lld.repo.BaseRepo;
import org.springframework.stereotype.Service;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Service
public class PatientService extends BaseService<Patient>{

    public PatientService(BaseRepo<Patient> repo) {
        super(repo);
    }
}
