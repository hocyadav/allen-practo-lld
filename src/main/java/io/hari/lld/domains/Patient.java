package io.hari.lld.domains;

import io.hari.lld.domains.helper.BaseEntity;
import io.hari.lld.domains.helper.Booking;
import io.hari.lld.domains.helper.BookingConverter;
import lombok.*;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "patients")
public class Patient extends BaseEntity {
    String name;
    String dob;

    @Builder.Default
    @Convert(converter = BookingConverter.class )
    Booking bookings = new Booking();
}
