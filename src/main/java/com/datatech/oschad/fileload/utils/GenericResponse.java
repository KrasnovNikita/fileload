package com.datatech.oschad.fileload.utils;

import lombok.Data;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * Класс обертка. Используется в ответах REST контроллеров.
 * Предоставляет удобный интерфейс для генерации ответа клиенту.
 *
 * @author N. Krasnov created on 27.03.2018
 */
@Data
public class GenericResponse<T> {

    private int code;
    private String error;
    private String message;
    private T data;

    public static <T> GenericResponse<T> success(T data, int httpCode) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setCode(httpCode);
        response.setData(data);
        return response;
    }

    public static <T> GenericResponse<T> success(T data) {
        return success(data, HTTP_OK);
    }

    public static <T> GenericResponse<T> success() {
        return success(null);
    }

    /**
     * Метод который генерирует ответ с ошибкой.
     * @param code код ошибки. Например: 400
     * @param error короткое сообщение об ошибке. Пример: "UserAlreadyExist"
     * @param message подробное описание ошибки.
     */
    public static <T> GenericResponse<T> error(int code, String error, String message) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setCode(code);
        response.setError(error);
        response.setMessage(message);
        return response;
    }

    @Deprecated
    public static <T> GenericResponse<T> error(String error, int code) {
        GenericResponse<T> response = error(error);
        response.setCode(code);
        return response;
    }

    @Deprecated
    public static <T> GenericResponse<T> error(String error) {
        GenericResponse<T> response = new GenericResponse<>();
        response.setError(error);
        return response;
    }

}
