package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CheckOut {
    private LocalDateTime to;

    @Override
    public String toString() {
        return "CheckOut{" +
                "to=" + to +
                '}';
    }
}
