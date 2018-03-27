package com.datatech.oschad.fileload.handler;

import com.datatech.oschad.fileload.exception.StorageException;
import com.datatech.oschad.fileload.utils.GenericResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;


/**
 * @author N. Krasnov created on 27.03.2018
 */
@Log
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebMvc
@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messages;

    private RestExceptionHandler(@Qualifier("messageSource") MessageSource messages) {
        this.messages = messages;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleServerErrorException(
            final Exception ex,
            final WebRequest request) {
        log.warning(org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(ex));
        final GenericResponse body = GenericResponse.error(
                ex.getMessage(), // TODO remove. Just for development.
//                messages.getMessage("internalError", null, locale),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return handleExceptionInternal(
                ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({StorageException.class})
    public ResponseEntity<Object> handleStorageException(
            final Exception ex,
            final WebRequest request) {
        Locale locale = LocaleContextHolder.getLocale();
        String validationError = ex.getMessage();
        final GenericResponse body = GenericResponse.error(
                messages.getMessage(validationError, null, locale),
                HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, body, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }
}
