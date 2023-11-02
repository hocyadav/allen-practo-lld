package io.hari.lld.domains;

import io.hari.lld.domains.helper.BaseEntity;
import io.hari.lld.domains.helper.DoctorSlots;
import io.hari.lld.domains.helper.DoctorSlotsConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity {
    @NotNull
    String name;

    @Enumerated(EnumType.STRING)
    Specialization specialization;

    @Builder.Default
    @Convert(converter = DoctorSlotsConverter.class)
    DoctorSlots doctorSlots = new DoctorSlots();
    
    public static enum Specialization {
        eye,
        nose,
        heart,
        general;
    }
}
