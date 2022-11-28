package com.travel.availabilityapiss.controllers;

import com.travel.availabilityapiss.models.SearchResponse;
import com.travel.availabilityapiss.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
public class RoomsController {
    @Autowired
    RoomsService roomsService;

    @GetMapping("/travelAPIs/availability")
    public SearchResponse getRoomsAvailability (@RequestParam(value = "LocationKey" )  int locationKey, @RequestParam(value = "AdultCount") int adultCount, @RequestParam(value = "InfantCount") int infantCount , @RequestParam(value = "FromDate")Timestamp fromDate , @RequestParam(value = "ToDate") Timestamp toDate){

        SearchResponse returnResponce;
        returnResponce =roomsService.getRoomsAvailability(locationKey,adultCount,infantCount,fromDate,toDate);
        return returnResponce ;
    }
}

