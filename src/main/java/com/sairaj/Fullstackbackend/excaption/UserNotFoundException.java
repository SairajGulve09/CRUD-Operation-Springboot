package com.sairaj.Fullstackbackend.excaption;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id)
    {
        super("User with id not found" + id);
    }
}
