package com.boost.webapp.exception;

import lombok.Getter;

@Getter
public class MonolithicManagerException extends RuntimeException{
    private final ErrorType errorType;
    public MonolithicManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public MonolithicManagerException(ErrorType errorType,String message){
        super(message);
        this.errorType=errorType;
    }

}