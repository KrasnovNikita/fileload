package com.datatech.oschad.fileload.exception;

/**
 * @author N. Krasnov created on 22.03.2018
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
