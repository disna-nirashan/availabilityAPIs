package com.travel.availabilityAPIs.models;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hotelKey")
    private  int hotelKey;

    @Column(name = "hotelID")
    private String hotelID;
    @Column(name = "phone")
    private String phone;


    @ManyToOne
    @JoinColumn(name = "locationKey")
    private Location locationDetails;

    public int getHotelKey() {
        return hotelKey;
    }

    public void setHotelKey(int hotelKey) {
        this.hotelKey = hotelKey;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(Location locationDetails) {
        this.locationDetails = locationDetails;
    }


}
