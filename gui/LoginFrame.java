import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ImageViewerFrame imageViewerFrame;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if ((username.equals("user") && password.equals("password")) || 
                    (username.equals("admin") && password.equals("123"))) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login Successful!");
                    openImageViewer();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials. Try again.");
                }
            }
        });

        setLocationRelativeTo(null);
    }

    private void openImageViewer() {
        if (imageViewerFrame == null) {
            imageViewerFrame = new ImageViewerFrame();
            imageViewerFrame.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
