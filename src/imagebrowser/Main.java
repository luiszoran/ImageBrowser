package imagebrowser;

import imagebrowser.Control.ActionListenerFactory;
import imagebrowser.Control.Command;
import imagebrowser.Control.NextImageCommand;
import imagebrowser.Control.PrevImageCommand;
import imagebrowser.Model.Image;
import imagebrowser.Persistence.FileImageListLoader;
import imagebrowser.UI.ApplicationFrame;
import imagebrowser.UI.ImageViewer;
import imagebrowser.UI.ImagePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new Main().execute();
    }

    private static final String filename = "C:\\Fotos";
    private ApplicationFrame frame;
    private Map<String, Command> commandMap;
   
    private void execute() {
        List<Image> images = new FileImageListLoader(filename).load();
        frame = createApplicationFrame();
        frame.getImageViewer().setImage(images.get(0));
        createCommands();
        frame.setVisible(true);

    }

    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action);
                        if (command == null)
                            return;
                        command.execute();
                    }
                };
            }
        });
    }

    private ImageViewer createImageViewer(Image image) {
        ImageViewer viewer = new ImagePanel();
        viewer.setImage(image);
        return viewer;
    }
    
    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewer())); 
    }
}
