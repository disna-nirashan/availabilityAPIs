package com.travel.availabilityapiss.models;

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

    @Column(name = "roomTypeKey")
    private int roomTypeKey;

    @Column(name = "hotelKey")
    private int hotelKey;

    public int getRoomTypeKey() {
        return roomTypeKey;
    }

    public void setRoomTypeKey(int roomTypeKey) {
        this.roomTypeKey = roomTypeKey;
    }

    public int getHotelKey() {
        return hotelKey;
    }

    public void setHotelKey(int hotelKey) {
        this.hotelKey = hotelKey;
    }


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


}
