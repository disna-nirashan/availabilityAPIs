package com.travel.availabilityAPIs.models;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomTypeKey")
    private int roomTypeKey;
    @Column (name = "roomTypeID")
    private String roomTypeID;
    @Column(name = "adultCount")
    private int adultCount;
    @Column(name = "infantCount")
    private int infantCount;
    @Column(name = "totalFax")
    private int totalFax;

    public int getRoomTypeKey() {
        return roomTypeKey;
    }

    public void setRoomTypeKey(int roomTypeKey) {
        this.roomTypeKey = roomTypeKey;
    }

    public String getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(String roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getInfantCount() {
        return infantCount;
    }

    public void setInfantCount(int infantCount) {
        this.infantCount = infantCount;
    }

    public int getTotalFax() {
        return totalFax;
    }

    public void setTotalFax(int totalFax) {
        this.totalFax = totalFax;
    }



}
