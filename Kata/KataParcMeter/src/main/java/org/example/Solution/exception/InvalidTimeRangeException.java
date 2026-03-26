package org.example.Solution.exception;

public class InvalidTimeRangeException extends ParkingException {
    public InvalidTimeRangeException(String message) {
        super("Invalid time range: " + message);
    }
}
