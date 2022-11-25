package com.travel.availabilityAPIs.repositoryies;

import com.travel.availabilityAPIs.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    Location findBylocationID(String LocationID);
    Location findBylocationKey(int LocationKey);
    long deleteBylocationKey(int locationKey);
}
