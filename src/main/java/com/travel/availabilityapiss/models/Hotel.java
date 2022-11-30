package com.travel.availabilityapiss.models;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelKey")
    private int hotelKey;

    @Column(name = "hotelID")
    private String hotelID;
    @Column(name = "phone")
    private String phone;

    @Column(name = "locationKey")
    private int locationKey;

    public int getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(int locationKey) {
        this.locationKey = locationKey;
    }


//    @ManyToOne
//    @JoinColumn(name = "locationKey")
//    private Location locationDetails;

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


}
