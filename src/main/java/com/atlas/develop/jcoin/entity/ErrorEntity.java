package com.atlas.develop.jcoin.entity;

import java.beans.Transient;
import java.time.LocalDateTime;


public record ErrorEntity(
        LocalDateTime timeStamp,
        String message,
        @Transient
        String errorAuthor,
        int httpStatus
) {

    public static class Builder{

        private LocalDateTime timeStamp;
        private String message;
        private String errorAuthor;
        private int httpStatus;

        public Builder withTimeStamp(LocalDateTime timeStamp){
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder withMessage(String message){
            this.message = message;
            return this;
        }

        public Builder withErrorAuth(String errorAuthor){
            this.errorAuthor = errorAuthor;
            return this;
        }

        public Builder withHttpStatus(int httpStatus){
            this.httpStatus = httpStatus;
            return this;
        }

        public ErrorEntity build(){
            return new ErrorEntity(timeStamp, message, errorAuthor, httpStatus);
        }
    }
}