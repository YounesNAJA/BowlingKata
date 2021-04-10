package com.younesnaja.bowlingapp.exception;

public class MaxKnockedPinsExceededException extends Throwable {
    @Override
    public String getMessage() {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("\nERROR : You have reached the max number of pins knocked down.\n");
        return errorMessage.toString();
    }
}
