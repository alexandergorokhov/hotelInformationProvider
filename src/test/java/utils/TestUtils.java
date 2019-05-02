package utils;

import information.provider.pojo.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestUtils {
    public static Hotel getSampleHotel(){
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setPublished(true);
        hotel.setTest(false);
        hotel.setName("ControllerTestHotelOne");
        HotelType hotelType = new HotelType();
        hotelType.setId("HOT");
        hotel.setHotelType(hotelType);
        hotel.setStars(2);
        Location location = new Location();
        City city = new City();
        city.setId(1);
        location.setCity(city);
        location.setAddress("500 East A Stree South");
        location.setZipcode("69153-3111");
        location.setLatitude(new BigDecimal(41.11161));
        location.setLogtitude(new BigDecimal(-101.71544));
        hotel.setLocation(location);
        CheckIn checkIn = new CheckIn();
        checkIn.setFrom(LocalDateTime.now());
        hotel.setCheckIn(checkIn);
        CheckOut checkOut = new CheckOut();
        checkOut.setTo(LocalDateTime.now().plusDays(1));
        MainPicture mainPicture = new MainPicture();
        mainPicture.setUrl("url");
        mainPicture.setId(1);
        mainPicture.setWidth(10);
        mainPicture.setHeight(10);
        mainPicture.setOrder(1);
        PictureCategory pictureCategory = new PictureCategory();
        pictureCategory.setId(1);
        mainPicture.setPictureCategory(pictureCategory);
        hotel.setMainPicture(mainPicture);
        hotel.setNumberOfRooms(11);
        hotel.setCreationDate(LocalDateTime.now().minusDays(1));
        hotel.setCreationDate(LocalDateTime.now());
        return hotel;

    }
}
