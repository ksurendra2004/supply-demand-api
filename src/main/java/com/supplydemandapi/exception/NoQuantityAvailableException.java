package com.supplydemandapi.exception;

public class NoQuantityAvailableException extends RuntimeException {

    public NoQuantityAvailableException() {}

    public NoQuantityAvailableException(String message) {
        super(message);
    }
}
