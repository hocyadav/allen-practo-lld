package io.hari.lld.domains.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class ClinicCentersConverter implements AttributeConverter<ClinicCenters, String> {
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(ClinicCenters centers) {
        if (centers==null) return "";
        return new ObjectMapper().writeValueAsString(centers);
    }

    @SneakyThrows
    @Override
    public ClinicCenters convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new ClinicCenters();
        return new ObjectMapper().readValue(s, ClinicCenters.class);
    }
}
