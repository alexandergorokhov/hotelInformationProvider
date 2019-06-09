package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class MainPicture {
    private String url;
    @Id
    private long id;
    private int width;
    private int height;
    private int order;
    private PictureCategory pictureCategory;

    @Override
    public String toString() {
        return "MainPicture{" +
                "url='" + url + '\'' +
                ", id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", order=" + order +
                ", pictureCategory=" + pictureCategory +
                '}';
    }
}
