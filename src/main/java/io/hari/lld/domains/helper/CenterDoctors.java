package io.hari.lld.domains.helper;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CenterDoctors {
    @Builder.Default
    List<Long> doctors = new LinkedList<>();
}
