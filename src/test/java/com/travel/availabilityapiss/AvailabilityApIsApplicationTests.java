package com.travel.availabilityapiss;

import com.travel.availabilityapiss.repositoryies.AllocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AvailabilityApIsApplicationTests {
	@Autowired
	AllocationRepository allocationRepository;

//	@Test
//	public void testRepo(){
//		var x = allocationRepository.f();
//		System.out.println(x);
//	}

}
