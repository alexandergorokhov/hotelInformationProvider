package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class HotelType {
    @Id
    private String id;
}
