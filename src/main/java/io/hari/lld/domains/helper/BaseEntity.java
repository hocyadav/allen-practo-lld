package io.hari.lld.domains.helper;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
@Getter @ToString
@MappedSuperclass
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
