package com.travel.availabilityapiss.models;

public class ErrorData {

    private String error;
    public static ErrorData create(){
        return new ErrorData();
    }

    public ErrorData() {
    }

    public ErrorData(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public ErrorData setError(String error) {
        this.error = error;
        return this;
    }
}
