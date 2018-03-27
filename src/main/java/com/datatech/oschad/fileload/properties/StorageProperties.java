package com.datatech.oschad.fileload.properties;

import org.springframework.stereotype.Component;

/**
 * @author N. Krasnov created on 22.03.2018
 */

@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

}
