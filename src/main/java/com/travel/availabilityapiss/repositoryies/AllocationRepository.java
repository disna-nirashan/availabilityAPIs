package com.travel.availabilityapiss.repositoryies;


import com.travel.availabilityapiss.models.Allocation;
import com.travel.availabilityapiss.models.SearchQueryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {



    @Query("select h.hotelID as hotel ,rt.roomTypeID as roomType ,rt.adultCount as adultCount ,rt.infantCount as childCount,(r.roomsCount-COALESCE(a.allocatedCount,0)) as noOfAvailableRooms,rr.rate as roomRate from Rooms r inner join  Hotel h on r.hotelKey=h.hotelKey inner join Location l on h.locationKey=l.locationKey inner join RoomType rt on r.roomTypeKey=rt.roomTypeKey inner join RoomsRate rr on (rr.roomsKey=r.roomsKey and :fromDate between rr.startDate and rr.endDate) left outer join Allocation a on a.roomsKey=r.roomsKey AND a.allocatedCount=(select max(al.allocatedCount) from Allocation al where al.roomsKey=a.roomsKey AND ((al.startDate>= :fromDate AND al.startDate <=:toDate) OR (al.endDate<=:toDate AND al.endDate >=:fromDate) OR   (al.startDate<= :fromDate  AND al.endDate >=:fromDate  )   OR (al.startDate <= :toDate  AND al.endDate >= :toDate ))  group by al.roomsKey) where l.locationKey=:locationKey and r.roomTypeKey in :roomTypes")
            
            
//    @Query("select a from Allocation a where a.allocatedCount=(select   max(al.allocatedCount) from Allocation al where al.roomsKey=a.roomsKey group by al.roomsKey) AND(  (a.startDate<= :fromDate AND a.endDate >=:fromDate) OR (a.startDate <= :toDate AND a.endDate >= :toDate))")
    List<SearchQueryResult> finalResult(@Param("roomTypes") List<Integer> roomTypeList ,@Param("locationKey") int locationKey ,@Param("fromDate") Timestamp fromDate ,@Param("toDate") Timestamp toDate);

}
