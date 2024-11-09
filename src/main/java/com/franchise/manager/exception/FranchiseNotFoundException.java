package com.franchise.manager.exception;

public class FranchiseNotFoundException extends RuntimeException {

    public FranchiseNotFoundException(String message) {
        super(message);
    }
}
