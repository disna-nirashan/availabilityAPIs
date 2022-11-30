package com.travel.availabilityapiss.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "roomrate")
public class RoomsRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rateKey")
    private int rateKey;
    @Column(name = "rate")
    private double rate;
    @Column(name = "startDate")
    private Timestamp startDate;
    @Column(name = "endDate")
    private Timestamp endDate;

    @Column(name = "roomsKey")
    private int roomsKey;

    public int getRoomsKey() {
        return roomsKey;
    }

    public void setRoomsKey(int roomsKey) {
        this.roomsKey = roomsKey;
    }


    public int getRateKey() {
        return rateKey;
    }

    public void setRateKey(int rateKey) {
        this.rateKey = rateKey;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }


}
