package io.hari.lld.domains.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class DoctorSlotsConverter implements AttributeConverter<DoctorSlots, String> {
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(DoctorSlots slots) {
        if (slots==null) return "";
        return new ObjectMapper().writeValueAsString(slots);
    }

    @SneakyThrows
    @Override
    public DoctorSlots convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new DoctorSlots();
        return new ObjectMapper().readValue(s, DoctorSlots.class);
    }
}
