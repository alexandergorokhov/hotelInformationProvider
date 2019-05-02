package information.provider.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainPicture {
    private String url;
    private long id;
    private int width;
    private int height;
    private int order;
    private PictureCategory pictureCategory;
}
