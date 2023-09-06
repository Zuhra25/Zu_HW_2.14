package org.example.exceptions;

public class BadSizeException extends RuntimeException {
    public BadSizeException() {
    }

    public BadSizeException(String message) {
        super(message);
    }

    public BadSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadSizeException(Throwable cause) {
        super(cause);
    }

    public BadSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
