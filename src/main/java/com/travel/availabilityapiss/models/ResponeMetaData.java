package com.travel.availabilityapiss.models;

public class ResponeMetaData {

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
