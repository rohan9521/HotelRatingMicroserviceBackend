package com.lcwd.hotel.HotelService.Exceptions;
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource Not Found on Server!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}