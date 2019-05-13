package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class PictureCategory {
    @Id
    private long id;

    @Override
    public String toString() {
        return "PictureCategory{" +
                "id=" + id +
                '}';
    }
}
