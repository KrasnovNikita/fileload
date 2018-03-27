package com.datatech.oschad.fileload.validator;

import com.datatech.oschad.fileload.exception.StorageException;
import lombok.extern.log4j.Log4j2;
import org.apache.tika.Tika;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author N. Krasnov created on 22.03.2018
 * Класс для валидации файлов
 */
@Log4j2
public class FileValidator {

    public static void validateFile(MultipartFile file) {
        log.debug("Validating: {}", file);
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (file.isEmpty()) {
            throw new StorageException("uploadFile.empty");
        }
        if (filename.contains("..")) {
            // This is a security check
            throw new StorageException(
                    "uploadFile.path");
        }
        if (!filename.contains(".zip")) {
            throw new StorageException(
                    "uploadFile.extension");
        }
       Tika tika = new Tika();
        try {
            String detectedType = tika.detect(file.getBytes());
            if (!detectedType.equals("application/x-zip-compressed")) {
                throw new StorageException("uploadFile.format");
            }
        } catch (IOException e) {
        }

    }
}
