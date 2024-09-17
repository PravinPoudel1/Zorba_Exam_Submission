package com.springmvcexam.exception;

public class InvalidMobileNumber extends RuntimeException{
    public InvalidMobileNumber(String message) {
        super(message);
    }
}
