package information.provider.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document(collection = "hotels")
public class Hotel {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
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
