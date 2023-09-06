package org.example.exceptions;

public class BadParamException extends RuntimeException {
    public BadParamException() {
    }

    public BadParamException(String message) {
        super(message);
    }

    public BadParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadParamException(Throwable cause) {
        super(cause);
    }

    public BadParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
