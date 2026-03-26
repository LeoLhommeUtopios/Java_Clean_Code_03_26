package org.example.Solution.exception;

public class InvalidSessionException extends ParkingException {
    public InvalidSessionException(String message) {
        super("Invalid parking session: " + message);
    }
}
