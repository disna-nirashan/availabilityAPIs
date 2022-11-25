package com.travel.availabilityAPIs.repositoryies;

import com.travel.availabilityAPIs.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms ,Integer> {
}
