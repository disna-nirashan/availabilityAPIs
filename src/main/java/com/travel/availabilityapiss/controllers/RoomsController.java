package com.travel.availabilityapiss.controllers;

import com.travel.availabilityapiss.models.ErrorData;
import com.travel.availabilityapiss.models.ResponeMetaData;
import com.travel.availabilityapiss.models.SearchResponse;
import com.travel.availabilityapiss.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Date;


@RestController
@Validated
public class RoomsController {
    @Autowired
    RoomsService roomsService;

    @GetMapping("/travelAPIs/availability")
    public ResponseEntity<SearchResponse>  getRoomsAvailability (
            @NotNull @RequestParam(value ="LocationKey") Integer locationKey,
            @NotNull @Min(1) @RequestParam(value = "AdultCount") Integer adultCount,
            @NotNull @RequestParam(value = "InfantCount") Integer infantCount ,
            @NotNull @RequestParam(value = "FromDate") Timestamp fromDate ,
            @NotNull @RequestParam(value = "ToDate") Timestamp toDate
    ){

        SearchResponse returnResponce;
        try{
            returnResponce =roomsService.getRoomsAvailability(locationKey,adultCount,infantCount,fromDate,toDate);
            return new ResponseEntity<>(returnResponce ,HttpStatus.OK);
        }catch(Throwable t){
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("Internal Server Error !")).setMetaData(ResponeMetaData.create().setStatus("Faild")),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

