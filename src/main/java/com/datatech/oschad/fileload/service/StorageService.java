package com.datatech.oschad.fileload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author N. Krasnov created on 22.03.2018
 */
public interface StorageService {

    void init();

    void storeFile(MultipartFile file);

    void deleteAll();
}
