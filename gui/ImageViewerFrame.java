import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class ImageViewerFrame extends JFrame {
    private JLabel imageLabel;
    private JButton loadButton;

    public ImageViewerFrame() {
        setTitle("Image Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("No Image", JLabel.CENTER);
        loadButton = new JButton("Load Image");

        add(imageLabel, BorderLayout.CENTER);
        add(loadButton, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                int returnValue = fileChooser.showOpenDialog(ImageViewerFrame.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                    imageLabel.setIcon(imageIcon);
                    imageLabel.setText("");
                }
            }
        });

        setLocationRelativeTo(null);
    }
}
