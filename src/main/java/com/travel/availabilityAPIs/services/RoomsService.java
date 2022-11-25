package com.travel.availabilityAPIs.services;

import com.travel.availabilityAPIs.repositoryies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
    @Autowired
    private RoomsRepository roomsRepo;
    private LocationRepository locationRepo;
    private HotelRepository hotelRepo;
    private RoomTypeRepository roomTypeRepo;
    private RoomsRateRepository roomsRateRepo;
    private  AllocationRepository allocationRepo;
}
