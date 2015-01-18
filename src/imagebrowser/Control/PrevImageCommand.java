package imagebrowser.Control;

import java.awt.event.ActionEvent;
import imagebrowser.UI.ImageViewer;

public class PrevImageCommand implements Command {

    private final ImageViewer viewer;

    public PrevImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        viewer.setImage(viewer.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
