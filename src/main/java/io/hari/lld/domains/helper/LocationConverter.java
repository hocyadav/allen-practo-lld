package io.hari.lld.domains.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class LocationConverter implements AttributeConverter<ClinicLocation, String> {
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(ClinicLocation location) {
        if (location==null) return "";
        return new ObjectMapper().writeValueAsString(location);
    }

    @SneakyThrows
    @Override
    public ClinicLocation convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) return new ClinicLocation();
        return new ObjectMapper().readValue(s, ClinicLocation.class);
    }
}
