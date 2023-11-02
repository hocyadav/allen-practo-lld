package io.hari.lld.domains;

import io.hari.lld.domains.helper.BaseEntity;
import io.hari.lld.domains.helper.ClinicCenters;
import io.hari.lld.domains.helper.ClinicCentersConverter;
import lombok.*;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@ToString(callSuper = true)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name = "clinics")
public class Clinic extends BaseEntity {
    String name;

    @Builder.Default
    @Convert(converter = ClinicCentersConverter.class)
    ClinicCenters clinicCenters = new ClinicCenters();
}
