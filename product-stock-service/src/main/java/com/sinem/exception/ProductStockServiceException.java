package com.sinem.exception;

import lombok.Getter;

@Getter
public class ProductStockServiceException extends RuntimeException{
    private final ErrorType errorType;

    public ProductStockServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ProductStockServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
