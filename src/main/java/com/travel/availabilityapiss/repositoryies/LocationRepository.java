package com.travel.availabilityapiss.repositoryies;

import com.travel.availabilityapiss.models.Location;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Integer> {


    //    @Query("select l from Location l where l.locationKey = ?1")
    @Cacheable(cacheNames = {"locationCache"}, key = "#locationKey")
    Location findBylocationKey(int locationKey);

}
