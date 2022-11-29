package com.travel.availabilityapiss.models;

import com.fasterxml.jackson.annotation.JsonInclude;

public interface SearchQueryResult {


    String getHotel();
    String getRoom_Type();
    Integer getNo_of_Available_Rooms();
    Double getRoom_rate();



}
