package information.provider.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
public class Location {
    private City city;
    private String address;
    private String zipcode;
    private BigDecimal latitude;
    private BigDecimal logtitude;

}
