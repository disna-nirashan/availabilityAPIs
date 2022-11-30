package com.travel.availabilityapiss.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Error data of the api call")

public class ErrorData {
    @ApiModelProperty(notes = "Error ")

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
