package imagebrowser.Persistence;

import imagebrowser.Model.Bitmap;
import imagebrowser.Model.Image;

public class ProxyImage implements Image {

    private final ImageLoader loader;
    private Image realImage;
    private Image next;
    private Image prev;
    
    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }

    @Override
    public Bitmap getBitmap() {
        checkLoaded();
        return realImage.getBitmap();
    }

    private void checkLoaded() {
        if (realImage == null)
            realImage = loader.load();
        return;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }
}
