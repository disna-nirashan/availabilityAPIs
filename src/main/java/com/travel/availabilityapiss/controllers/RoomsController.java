package com.travel.availabilityapiss.controllers;

import com.travel.availabilityapiss.models.ErrorData;
import com.travel.availabilityapiss.models.ResponeMetaData;
import com.travel.availabilityapiss.models.SearchResponse;
import com.travel.availabilityapiss.repositoryies.LocationRepository;
import com.travel.availabilityapiss.services.RoomsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



@RestController
@Validated
public class RoomsController {
    private static final String FAILED_STATUS = "Failed";
    @Autowired
    RoomsService roomsService;
    @Autowired
    LocationRepository locationRepo;

    @GetMapping("/availability")
    @ApiOperation(value = "Find hotel rooms availability for your details"
    ,notes = "Provide relevent correct data "
            ,response = SearchResponse.class
    )
    public ResponseEntity<SearchResponse>  getRoomsAvailability (
            @NotNull @RequestParam(value ="LocationKey") Integer locationKey,
            @NotNull @Min(1) @RequestParam(value = "AdultCount") Integer adultCount,
            @Valid @NotNull @RequestParam(value = "ChildCount") Integer infantCount ,
            @NotNull @RequestParam(value = "FromDate") Timestamp fromDate ,
            @NotNull @RequestParam(value = "ToDate") Timestamp toDate
    ){
        var loc=locationRepo.findBylocationKey(locationKey);
        if(loc==null){

            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("LocationKey not found in system !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)),HttpStatus.NOT_FOUND);
        }
        var fromDateCheck=checkDatewithCurrentDate(fromDate,"FromDate");
        if(fromDateCheck!=null){
            return fromDateCheck;
        }
        var toDateCheck=checkDatewithCurrentDate(toDate,"ToDate");
        if(toDateCheck!=null){
            return toDateCheck;
        }
        var toFromDatesCheck=checkfromDateAndToDate(fromDate,toDate);
        if(toFromDatesCheck!=null){
            return toFromDatesCheck;
        }


        SearchResponse returnResponce;
        try{
            returnResponce =roomsService.getRoomsAvailability(locationKey,adultCount,infantCount,fromDate,toDate);
            return new ResponseEntity<>(returnResponce ,HttpStatus.OK);
        }catch(Throwable t){
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("Internal Server Error !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)),HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    private ResponseEntity<SearchResponse> checkDatewithCurrentDate(Timestamp checkingDat,String fieldName){

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000").format(new java.util.Date());
        var currentTs = Timestamp.valueOf(timeStamp);
        if(currentTs.compareTo(checkingDat)>0){
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(fieldName+" can't be a past Date !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.BAD_REQUEST);

        }
        return null;
    }

    private ResponseEntity<SearchResponse> checkfromDateAndToDate(Timestamp fromDate,Timestamp toDate){
        if(fromDate.compareTo(toDate)>0){
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("ToDate can't be a past than FromDate !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.BAD_REQUEST);

        }
        return null;
    }


}

