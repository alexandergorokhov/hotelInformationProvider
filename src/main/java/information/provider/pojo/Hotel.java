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

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", published=" + published +
                ", test=" + test +
                ", name='" + name + '\'' +
                ", hotelType=" + hotelType +
                ", stars=" + stars +
                ", location=" + location +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", mainPicture=" + mainPicture +
                ", numberOfRooms=" + numberOfRooms +
                ", creationDate=" + creationDate +
                ", lastmodifiedDate=" + lastmodifiedDate +
                '}';
    }

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
