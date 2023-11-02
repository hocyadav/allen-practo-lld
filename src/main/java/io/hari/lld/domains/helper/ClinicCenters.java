package io.hari.lld.domains.helper;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class ClinicCenters {

    /**
     * key : location name
     * value : list of doctors
     */
    @Builder.Default
    Map<String, List<Long>> clinicCenterDoctors= new HashMap<>();
}
