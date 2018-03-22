package com.datatech.oschad.fileload.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author N. Krasnov created on 22.03.2018
 */

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
