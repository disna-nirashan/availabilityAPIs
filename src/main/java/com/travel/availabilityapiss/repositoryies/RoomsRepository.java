package com.travel.availabilityapiss.repositoryies;

import com.travel.availabilityapiss.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {


    // Rooms findByhotelDetails(Hotel hotelDetails);

    //@Query(value = "SELECT r FROM Rooms r WHERE r.hotelDetails = ?1")
    //List findByhotelKey(int hotelKey);


}
