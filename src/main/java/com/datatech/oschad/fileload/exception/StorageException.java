package com.datatech.oschad.fileload.exception;

/**
 * @author N. Krasnov created on 22.03.2018
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
