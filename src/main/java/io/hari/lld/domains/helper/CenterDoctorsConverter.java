package io.hari.lld.domains.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class CenterDoctorsConverter implements AttributeConverter<CenterDoctors, String> {
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(CenterDoctors doctors) {
        if (doctors==null) return "";
        return new ObjectMapper().writeValueAsString(doctors);
    }

    @SneakyThrows
    @Override
    public CenterDoctors convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new CenterDoctors();
        return new ObjectMapper().readValue(s, CenterDoctors.class);
    }
}
