package com.travel.availabilityapiss;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchTest {
//	@Autowired
//	RoomsController roomsController;
//
//
//
//
//
//	@Test
//	 void test_results_sorted(){
//		var result = roomsController.getRoomsAvailability(
//				1,
//				1,
//				1,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		).getBody().getData();
//
//		assertTrue(!result.isEmpty(), "Results not empty");
//		Double lastRate = null;
//		for(var searchResult:result){
//			if(lastRate!=null){
//				assertTrue(lastRate<=searchResult.getroomRate(), "Results sorted");
//			}
//			lastRate = searchResult.getroomRate();
//		}
//	}
//
//	@Test
//	 void test_invalid_location_key(){
//		var result = roomsController.getRoomsAvailability(
//				10000,
//				3,
//				2,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		);
//
//		//assert result.getStatusCodeValue()==405;
//		Assertions.assertEquals(404,result.getStatusCodeValue());
//		Assertions.assertEquals("Failed", result.getBody().getMetaData().getStatus());
//
//		//assert result.getBody().getErrorData().getError().equals("LocationKey not found in system !");
//		Assertions.assertEquals("LocationKey not found in system !",result.getBody().getErrorData().getError());
//
//
//	}
//	@Test
//	 void test_past_fromdate(){
//		var result = roomsController.getRoomsAvailability(
//				1,
//				3,
//				2,
//				Timestamp.valueOf("2022-11-28 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		);
//
//		//Assertions.assertNotEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals(400,result.getStatusCodeValue());
//		Assertions.assertEquals("Failed", result.getBody().getMetaData().getStatus());
//		Assertions.assertEquals("FromDate can't be a past Date !",result.getBody().getErrorData().getError());
//
//
//	}
//
//	@Test
//	 void test_past_todate(){
//		var result = roomsController.getRoomsAvailability(
//				1,
//				3,
//				2,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-11-11 00:00:00")
//		);
//
//		//Assertions.assertNotEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals(400,result.getStatusCodeValue());
//		Assertions.assertEquals("Failed", result.getBody().getMetaData().getStatus());
//		Assertions.assertEquals("ToDate can't be a past Date !",result.getBody().getErrorData().getError());
//
//
//	}
//
//	@Test
//	 void test_todate_past_than_fromdate(){
//		var result = roomsController.getRoomsAvailability(
//				1,
//				3,
//				2,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-09 00:00:00")
//		);
//
//		//Assertions.assertNotEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals(400,result.getStatusCodeValue());
//		Assertions.assertEquals("Failed", result.getBody().getMetaData().getStatus());
//		Assertions.assertEquals("ToDate can't be a past than FromDate !",result.getBody().getErrorData().getError());
//
//
//	}
//
//	@Test
//	 void test_results_one_adult(){
//
//		var result = roomsController.getRoomsAvailability(
//				1,
//				1,
//				0,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		).getBody().getData();
//
//		assertTrue(!result.isEmpty(), "Results not empty");
//		//Double lastRate = null;
//		for(var searchResult:result){
//			//if(lastRate!=null){
//			boolean cond=1<=searchResult.getadultCount() || searchResult.getroomType().equals("Family");
//			Assertions.assertTrue(cond, "Results Incorrect");
//			//}
//			//lastRate = searchResult.getroomRate();
//		}
//	}
//
//	@Test
//	 void test_invalid_passegnger_count(){
//		var result = roomsController.getRoomsAvailability(
//				1,
//				3,
//				3,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		);
//
//		//Assertions.assertNotEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals("Failed", result.getBody().getMetaData().getStatus());
//		Assertions.assertEquals("Passengers count doesn't match with any rooms !",result.getBody().getErrorData().getError());
//
//
//	}
//@Test
//	 void test_results_one_adult_and_one_child(){
//
//		var result = roomsController.getRoomsAvailability(
//				1,
//				1,
//				1,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		).getBody().getData();
//
//		assertTrue(!result.isEmpty(), "Results not empty");
//		//Double lastRate = null;
//		for(var searchResult:result){
//			//if(lastRate!=null){
//			boolean cond= searchResult.getroomType().equals("Family") ||(2<=(searchResult.getadultCount()+searchResult.getchildCount())&&1<=searchResult.getadultCount());
//			Assertions.assertTrue(cond, "Results Incorrect");
//			//}
//			//lastRate = searchResult.getroomRate();
//		}
//	}
//
//	@Test
//
//	 void test_results_one_adult_and_three_child(){
//
//		var result = roomsController.getRoomsAvailability(
//				1,
//				1,
//				3,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		).getBody().getData();
//
//		assertTrue(!result.isEmpty(), "Results not empty");
//		//Double lastRate = null;
//		for(var searchResult:result){
//			//if(lastRate!=null){
//			boolean cond= searchResult.getroomType().equals("Family") ||(4<=(searchResult.getadultCount()+searchResult.getchildCount())&&1<=searchResult.getadultCount());
//			Assertions.assertTrue(cond, "Results Incorrect");
//			//}
//			//lastRate = searchResult.getroomRate();
//		}
//	}
//
//	@Test
//
//	 void test_results_one_adult_and_four_child(){
//
//		var result = roomsController.getRoomsAvailability(
//				1,
//				1,
//				4,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		).getBody().getData();
//
//		assertTrue(!result.isEmpty(), "Results not empty");
//		//Double lastRate = null;
//		for(var searchResult:result){
//			//if(lastRate!=null){
//			boolean cond= searchResult.getroomType().equals("Family") ||(5<=(searchResult.getadultCount()+searchResult.getchildCount())&&1<=searchResult.getadultCount());
//			Assertions.assertTrue(cond, "Results Incorrect");
//			//}
//			//lastRate = searchResult.getroomRate();
//		}
//	}
//
//	@Test
//	 void test_valied_locationKey_but_no_hotels_or_rooms_configured(){
//		var result = roomsController.getRoomsAvailability(
//				10,
//				1,
//				0,
//				Timestamp.valueOf("2022-12-10 00:00:00"),
//				Timestamp.valueOf("2022-12-11 00:00:00")
//		);
//
//		//Assertions.assertNotEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals(200,result.getStatusCodeValue());
//		Assertions.assertEquals("Success", result.getBody().getMetaData().getStatus());
//		Assertions.assertTrue(result.getBody().getData().isEmpty());
//
//
//	}


}
