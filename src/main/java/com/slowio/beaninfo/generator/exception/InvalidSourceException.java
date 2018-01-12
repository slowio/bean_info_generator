package com.slowio.beaninfo.generator.exception;

/**
 *
 */
public class InvalidSourceException extends RuntimeException {


    public InvalidSourceException() {
        super();
    }

    public InvalidSourceException(String message) {
        super(message);
    }

    public InvalidSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSourceException(Throwable cause) {
        super(cause);
    }

    protected InvalidSourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
