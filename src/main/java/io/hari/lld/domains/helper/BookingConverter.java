package io.hari.lld.domains.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class BookingConverter  implements AttributeConverter<Booking, String> {
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Booking booking) {
        if (booking==null) return "";
        return new ObjectMapper().writeValueAsString(booking);
    }

    @SneakyThrows
    @Override
    public Booking convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new Booking();
        return new ObjectMapper().readValue(s, Booking.class);
    }
}
