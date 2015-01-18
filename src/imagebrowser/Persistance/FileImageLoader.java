package imagebrowser.Persistence;

import imagebrowser.UI.SwingBitmap;
import imagebrowser.Model.Image;
import imagebrowser.Model.RealImage;
import imagebrowser.Model.Bitmap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader {

    String filename;

    public FileImageLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public Image load() {
        return new RealImage(loadBitmap());
    }

    private Bitmap loadBitmap() {
        return new SwingBitmap(loadBufferedImage());
    }

    private BufferedImage loadBufferedImage() {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            return null;
        }
    }
}
