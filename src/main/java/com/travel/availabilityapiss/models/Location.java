package com.travel.availabilityapiss.models;

import javax.persistence.*;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="locationKey")
    private  int locationKey;

    @Column(name = "locationID")
    private String locationID;

    @Column(name = "postalCode")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }




    public int getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(int locationKey) {
        this.locationKey = locationKey;
    }



}
