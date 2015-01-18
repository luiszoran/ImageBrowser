package imagebrowser.Control;

import java.awt.event.ActionEvent;
import imagebrowser.UI.ImageViewer;

public class NextImageCommand implements Command {

    private final ImageViewer viewer;

    public NextImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
