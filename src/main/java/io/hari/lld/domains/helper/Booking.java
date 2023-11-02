package io.hari.lld.domains.helper;

import lombok.*;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Booking {
    Long patientId;
    Long doctorId;
    Long clinicId;
}
