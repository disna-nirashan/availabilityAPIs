package com.travel.availabilityAPIs.repositoryies;


import com.travel.availabilityAPIs.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
