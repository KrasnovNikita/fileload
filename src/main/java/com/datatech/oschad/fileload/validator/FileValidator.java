package com.datatech.oschad.fileload.validator;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author N. Krasnov created on 22.03.2018
 * Класс для валидации файлов
 */
public class FileValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {

    }
}
