package com.travel.availabilityAPIs.repositoryies;


import com.travel.availabilityAPIs.models.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
