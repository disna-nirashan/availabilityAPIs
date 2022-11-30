package com.travel.availabilityapiss.controllers;

import com.travel.availabilityapiss.models.ErrorData;
import com.travel.availabilityapiss.models.Location;
import com.travel.availabilityapiss.models.ResponeMetaData;
import com.travel.availabilityapiss.models.SearchResponse;
import com.travel.availabilityapiss.repositoryies.LocationRepository;
import com.travel.availabilityapiss.services.RoomsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;


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
            , notes = "Provide relevent correct data "

    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Data", response = SearchResponse.class),
            @ApiResponse(code = 404, message = "Object Not found "),
            @ApiResponse(code = 400, message = "Bad Request "),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    public ResponseEntity<SearchResponse> getRoomsAvailability(
            @ApiParam(name = "LocationKey", value = "Location Key of the relevant Location", example = "1") @NotNull @RequestParam(value = "LocationKey") Integer locationKey,
            @ApiParam(name = "AdultCount", value = "Adult Count of the Passengers", example = "1") @NotNull @Min(1) @RequestParam(value = "AdultCount") Integer adultCount,
            @ApiParam(name = "ChildCount", value = "Child Count of the Passengers", example = "1") @NotNull @Min(0) @RequestParam(value = "ChildCount") Integer infantCount,
            @ApiParam(name = "FromDate", value = "Check in Date", example = "2022-12-10 00:00:00") @NotNull @RequestParam(value = "FromDate") Timestamp fromDate,
            @ApiParam(name = "ToDate", value = "Check out Date", example = "2022-12-11 00:00:00") @NotNull @RequestParam(value = "ToDate") Timestamp toDate
    ) {
        var loc = locationRepo.findBylocationKey(locationKey);
        // loc is Location type variable when it's empty or null then send object not found (404) as response
        Optional<Location> checkLocNull = Optional.ofNullable(loc);
        if (checkLocNull.isEmpty()) {

            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("LocationKey not found in system !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.NOT_FOUND);
        }
        var fromDateCheck = checkDatewithCurrentDate(fromDate, "FromDate");
        if (fromDateCheck != null) {
            return fromDateCheck;
        }
        var toDateCheck = checkDatewithCurrentDate(toDate, "ToDate");
        if (toDateCheck != null) {
            return toDateCheck;
        }
        var toFromDatesCheck = checkfromDateAndToDate(fromDate, toDate);
        if (toFromDatesCheck != null) {
            return toFromDatesCheck;
        }


        SearchResponse returnResponce;
        try {
            returnResponce = roomsService.getRoomsAvailability(locationKey, adultCount, infantCount, fromDate, toDate);
            return new ResponseEntity<>(returnResponce, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("Internal Server Error !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    private ResponseEntity<SearchResponse> checkDatewithCurrentDate(Timestamp checkingDat, String fieldName) {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000").format(new java.util.Date());
        Calendar paramDate = Calendar.getInstance();
        paramDate.setTime(checkingDat);
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(Timestamp.valueOf(timeStamp));
        if (currentDate.compareTo(paramDate) > 0) {
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError(fieldName + " can't be a past Date !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.BAD_REQUEST);

        }
        return null;
    }

    private ResponseEntity<SearchResponse> checkfromDateAndToDate(Timestamp fromDate, Timestamp toDate) {
        Calendar fromDateParam = Calendar.getInstance();
        fromDateParam.setTime(fromDate);
        Calendar toDateParam = Calendar.getInstance();
        toDateParam.setTime(toDate);
        if (fromDateParam.compareTo(toDateParam) > 0) {
            return new ResponseEntity<>(SearchResponse.create().setErrorData(ErrorData.create().setError("ToDate can't be a past than FromDate !")).setMetaData(ResponeMetaData.create().setStatus(FAILED_STATUS)), HttpStatus.BAD_REQUEST);

        }
        return null;
    }


}

