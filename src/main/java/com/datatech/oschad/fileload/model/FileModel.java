package com.datatech.oschad.fileload.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author N. Krasnov created on 27.03.2018
 */
public class FileModel {
    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
