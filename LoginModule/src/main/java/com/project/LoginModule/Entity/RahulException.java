package com.project.LoginModule.Entity;


public class RahulException extends Exception {

    // Constructor with no argument
    public RahulException() {
        super();
    }

    // Constructor that accepts a custom error message
    public RahulException(String message) {
        super(message);
    }

    // Constructor that accepts a custom error message and a cause (another Throwable)
    public RahulException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause (another Throwable)
    public RahulException(Throwable cause) {
        super(cause);
    }

    // Optionally, you can override the toString() or getMessage() method to provide a custom message format
    @Override
    public String toString() {
        return "RahulException: " + getMessage();
    }
}
