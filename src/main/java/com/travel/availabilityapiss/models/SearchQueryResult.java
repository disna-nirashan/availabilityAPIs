package com.travel.availabilityapiss.models;

import com.fasterxml.jackson.annotation.JsonInclude;

public interface SearchQueryResult {


    String getHotel();
    String getRoom_Type();
    int getNo_of_Available_Rooms();
    double getRoom_rate();



}
