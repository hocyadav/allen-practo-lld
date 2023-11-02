package io.hari.lld.exceptions;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
