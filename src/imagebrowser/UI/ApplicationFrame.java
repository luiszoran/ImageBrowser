package imagebrowser.UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import imagebrowser.Control.ActionListenerFactory;
import java.awt.BorderLayout;
import java.awt.HeadlessException;

public class ApplicationFrame extends JFrame {

    private ActionListenerFactory factory;
    private int index = 0;
    private ImageViewer imageViewer;

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Image Browser");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 800);
        this.createComponents();
    }

    private void createComponents() {
        this.add(createToolbarPanel(), BorderLayout.SOUTH);
        this.add(createImagePanel());
    }
    
    private JButton createNextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(factory.createActionListener("Next"));
        return button;
    }
    
    private JButton createPrevButton() {
        JButton button = new JButton("Prev");
        button.addActionListener(factory.createActionListener("Prev"));
        return button;
    }
        
    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        this.imageViewer = panel;
        return panel;
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());        
        return panel;
    }
}
