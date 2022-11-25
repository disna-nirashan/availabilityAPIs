package com.travel.availabilityAPIs.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocationKey")
    private int allocationKey;
    @Column(name = "allocationCount")
    private int allocationCount;
    @Column(name = "startDate")
    private Timestamp startDate;
    @Column(name = "endDate")
    private Timestamp endDate;

    @OneToOne
    @JoinColumn(name = "roomsKey")
    private Rooms roomsDetails;

    public int getAllocationKey() {
        return allocationKey;
    }

    public void setAllocationKey(int allocationKey) {
        this.allocationKey = allocationKey;
    }

    public int getAllocationCount() {
        return allocationCount;
    }

    public void setAllocationCount(int allocationCount) {
        this.allocationCount = allocationCount;
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

    public Rooms getRoomsDetails() {
        return roomsDetails;
    }

    public void setRoomsDetails(Rooms roomsDetails) {
        this.roomsDetails = roomsDetails;
    }


}
