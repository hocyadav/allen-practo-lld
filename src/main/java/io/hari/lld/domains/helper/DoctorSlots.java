package io.hari.lld.domains.helper;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DoctorSlots {
    /**
     * key : center location
     * value : all locations slot
     */
    @Builder.Default
    Map<String, List<Slot>> map= new HashMap<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Slot {
        String startTime;
        String endTime;
    }
}
