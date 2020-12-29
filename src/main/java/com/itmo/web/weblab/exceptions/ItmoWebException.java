package com.itmo.web.weblab.exceptions;

public class ItmoWebException extends RuntimeException {
    public ItmoWebException() {
        super();
    }
    public ItmoWebException(String message) {
        super(message);
    }
}
