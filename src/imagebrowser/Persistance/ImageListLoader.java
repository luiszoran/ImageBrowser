package imagebrowser.Persistence;

import java.util.List;
import imagebrowser.Model.Image;

public interface ImageListLoader {

    public List<Image> load();
}
