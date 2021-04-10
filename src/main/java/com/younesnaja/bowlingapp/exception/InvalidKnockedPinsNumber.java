package com.younesnaja.bowlingapp.exception;

public class InvalidKnockedPinsNumber extends Throwable {
    @Override
    public String getMessage() {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("\nERROR : The number of pins you knocked down is invalid.\n");
        return errorMessage.toString();
    }
}
