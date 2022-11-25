package com.travel.availabilityAPIs.models;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomsKey")
    private int roomsKey;
    @Column(name = "roomsCount")
    private int roomsCount;

    @ManyToOne
    @JoinColumn(name = "roomTyypeKey")
    private RoomType roomTypeDetails;

    @ManyToOne
    @JoinColumn(name = "hotelKey")
    private Hotel hotelDetails;

    public int getRoomsKey() {
        return roomsKey;
    }

    public void setRoomsKey(int roomsKey) {
        this.roomsKey = roomsKey;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public RoomType getRoomTypeDetails() {
        return roomTypeDetails;
    }

    public void setRoomTypeDetails(RoomType roomTypeDetails) {
        this.roomTypeDetails = roomTypeDetails;
    }

    public Hotel getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Hotel hotelDetails) {
        this.hotelDetails = hotelDetails;
    }


}
