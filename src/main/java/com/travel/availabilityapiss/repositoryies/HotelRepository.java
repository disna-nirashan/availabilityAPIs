package com.travel.availabilityapiss.repositoryies;


import com.travel.availabilityapiss.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    //List findBylocationKey(int locationKey);
}
