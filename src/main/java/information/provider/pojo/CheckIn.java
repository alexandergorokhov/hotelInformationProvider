package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CheckIn {
    private LocalDateTime from;

    @Override
    public String toString() {
        return "CheckIn{" +
                "from=" + from +
                '}';
    }
}
