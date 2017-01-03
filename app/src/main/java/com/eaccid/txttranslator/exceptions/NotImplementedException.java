package com.eaccid.txttranslator.exceptions;

public class NotImplementedException extends RuntimeException {

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Exception e) {
        super(message, e);
    }
}
