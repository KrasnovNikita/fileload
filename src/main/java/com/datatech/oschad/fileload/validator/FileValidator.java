package com.datatech.oschad.fileload.validator;

import com.datatech.oschad.fileload.exception.StorageException;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author N. Krasnov created on 22.03.2018
 * Класс для валидации файлов
 */
@Log4j2
public class FileValidator {

    public static void validateFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file " + filename);
        }
        if (filename.contains("..")) {
            // This is a security check
            throw new StorageException(
                    "Cannot store file with relative path outside current directory "
                            + filename);
        }
        if (!filename.contains(".zip")){
            throw new StorageException(
                    "Failed to store file with incorrect extension "
                            + filename);
        }
    }
}
