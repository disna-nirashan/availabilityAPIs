package com.travel.availabilityapiss.repositoryies;

import com.travel.availabilityapiss.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

//   @Query("SELECT r.roomTypeKey FROM RoomType r WHERE (r.adultCount=:adultCount AND r.infantCount=:infantCount) OR ( r.totalFax>=:totalFax AND r.roomTypeID='Family') OR (r.roomTypeID!='Family' AND r.adultCount >= (:adultCount+(:infantCount-r.infantCount)))")

//    @Query("SELECT r.roomTypeKey FROM RoomType r WHERE (r.adultCount+r.infantCount)>=:totalFax AND r.adultCount>=:adultCount")

    @Query("select r.roomTypeKey from RoomType r where (((COALESCE(r.adultCount,0) + COALESCE(r.infantCount,0))>= COALESCE(:totalFax,0) AND COALESCE(r.adultCount ,0)>= COALESCE(:adultCount ,0)) OR ( COALESCE(r.totalFax ,0)>=COALESCE(:totalFax ,0) AND r.roomTypeID='Family')) AND (:adultCount!=0 OR :infantCount!=0)")
    List<Integer> findRoomTypes(@Param("adultCount") int adultCount, @Param("infantCount") int infantCount, @Param("totalFax") int totalFax);
}
