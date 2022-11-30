package com.travel.availabilityapiss.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Meta data of the api call")

public class ResponeMetaData {
    @ApiModelProperty(notes = "Status of response")

    private String status;

    public String getStatus() {
        return status;
    }

    public ResponeMetaData setStatus(String status) {
        this.status = status;
        return this;
    }

    public ResponeMetaData(String status) {
        this.status = status;
    }

    public static ResponeMetaData create(){
          return new ResponeMetaData();
      }

    public ResponeMetaData() {
    }
}
