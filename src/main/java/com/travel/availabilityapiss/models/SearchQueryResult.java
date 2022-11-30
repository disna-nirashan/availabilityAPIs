package com.travel.availabilityapiss.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about rooms availability")
public interface SearchQueryResult {


    @ApiModelProperty(notes = "The Hotel Name")
    String getHotel();

    @ApiModelProperty(notes = "Type of the room")
    String getroomType();

    @ApiModelProperty(notes = "Adult count of the room")
    Integer getadultCount();

    @ApiModelProperty(notes = "Child count of the room")
    Integer getchildCount();

    @ApiModelProperty(notes = "Available room count")
    Integer getnoOfAvailableRooms();

    @ApiModelProperty(notes = "Rate of the room in given time period")
    Double getroomRate();



}
