package com.tormodaase.footballAPI.objects.exceptions;

public class JSONMismatchException extends Exception {
    public JSONMismatchException(String errorMessage) {
        super(errorMessage);
    }
}
