package com.travel.availabilityapiss.repositoryies;


import com.travel.availabilityapiss.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
