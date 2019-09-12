package com.example.friends.error;

import java.util.Date;

public class FieldErrorMessage {

    private String field;
    private String message;
    private Date timeStamp;

    public FieldErrorMessage(String field, String message, Date timeStamp) {
        this.field = field;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public FieldErrorMessage() {
    }
}
