package com.travel.availabilityapiss.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocationKey")
    private int allocationKey;
    @Column(name = "allocatedCount")
    private int allocatedCount;
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


    public int getAllocationKey() {
        return allocationKey;
    }

    public void setAllocationKey(int allocationKey) {
        this.allocationKey = allocationKey;
    }

    public int getAllocatedCount() {
        return allocatedCount;
    }

    public void setAllocatedCount(int allocatedCount) {
        this.allocatedCount = allocatedCount;
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
