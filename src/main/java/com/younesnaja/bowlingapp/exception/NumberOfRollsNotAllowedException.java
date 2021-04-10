package com.younesnaja.bowlingapp.exception;

public class NumberOfRollsNotAllowedException extends Throwable {
    @Override
    public String getMessage() {
        return "\nYou are not allowed to do more than 2 turns.\n";
    }
}
