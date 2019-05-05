package information.provider.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Getter
@Setter
public class Hotel {
    @Id
    private long id;
    private boolean published;
    private boolean test;
    private String name;
    private HotelType hotelType;
    private int stars;
    private Location location;
    private CheckIn checkIn;
    private CheckOut checkOut;
    private MainPicture mainPicture;
    private int numberOfRooms;
    private LocalDateTime creationDate;
    private LocalDateTime lastmodifiedDate;

}
