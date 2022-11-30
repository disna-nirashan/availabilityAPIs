package com.travel.availabilityapiss.services;

import com.travel.availabilityapiss.models.*;
import com.travel.availabilityapiss.repositoryies.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoomsService {
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private RoomsRepository roomsRepo;
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private RoomTypeRepository roomTypeRepo;
    @Autowired
    private RoomsRateRepository roomsRateRepo;
    @Autowired
    private  AllocationRepository allocationRepo;

    public SearchResponse getRoomsAvailability(int locationKey , int adultCount , int infantCount , Timestamp fromDate, Timestamp toDate){

        var totalFax=adultCount+infantCount;
        List<Integer> roomTypeList= roomTypeRepo.findRoomTypes(adultCount,infantCount,totalFax);

        var finalQueryResult=allocationRepo.finalResult(roomTypeList,locationKey,fromDate,toDate);

       SearchResponse searchResponse=new SearchResponse();
       if(!roomTypeList.isEmpty()){
           var sortedList= finalQueryResult.stream().sorted(Comparator.comparingDouble(SearchQueryResult::getroomRate)).collect(Collectors.toList());
           searchResponse.setData(sortedList);
           searchResponse.setMetaData(new ResponeMetaData("Success"));
       }else{


           searchResponse.setErrorData(new ErrorData("Passengers count doesn't match with any rooms !"));
           searchResponse.setMetaData(new ResponeMetaData("Failed"));
        }


        return searchResponse;
    }


}
