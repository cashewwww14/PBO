import javax.swing.*;
import java.awt.*;

public class BMIAppGUI {
    private UserManager userManager;
    private JFrame frame;

    public BMIAppGUI() {
        userManager = new UserManager();
        frame = new JFrame("BMI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Ensure the frame is visible
        showLoginScreen();
    }

    private void showLoginScreen() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        gbc.gridy = 2;
        panel.add(registerButton, gbc);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            RegularUser user = userManager.loginUser(username);
            if (user != null) {
                showUserDashboard(user);
            } else {
                JOptionPane.showMessageDialog(frame, "User not found. Please register.");
            }
        });

        registerButton.addActionListener(e -> showRegisterScreen());
    }

    private void showRegisterScreen() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(5);
        JLabel heightLabel = new JLabel("Height (cm):");
        JTextField heightField = new JTextField(5);
        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField(5);
        JLabel genderLabel = new JLabel("Gender:");
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
        JButton registerButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(ageLabel, gbc);

        gbc.gridx = 1;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(heightLabel, gbc);

        gbc.gridx = 1;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(weightLabel, gbc);

        gbc.gridx = 1;
        panel.add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(genderLabel, gbc);

        gbc.gridx = 1;
        panel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();

        registerButton.addActionListener(e -> {
            try {
                String username = usernameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                double height = Double.parseDouble(heightField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                String gender = (String) genderComboBox.getSelectedItem();

                if (userManager.registerUser(username, age, height, weight, gender)) {
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                    showLoginScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for age, height, and weight.");
            }
        });
    }

    private void showUserDashboard(RegularUser user) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);

        double currentBMI = user.calculateBMI();
        double idealMaxWeight = 24.9 * Math.pow(user.height / 100.0, 2);
        double weightToLose = (currentBMI > 24.9) ? user.weight - idealMaxWeight : 0;
        double dailyCalorieIntake = user.calculateCalorieIntake();
        double calorieDeficitPerDay = 500;
        int estimatedDaysToIdealWeight = (weightToLose > 0) ? (int) ((weightToLose * 7700) / calorieDeficitPerDay) : 0;

        infoArea.setText(String.format(
                "BMI: %.2f\n" +
                        "Ideal Weight Range: %s\n" +
                        "Current Calorie Intake/Day: %.2f kcal\n" +
                        "%s\n" +
                        "Nutrition Plan: %s\n",
                currentBMI,
                user.getIdealWeightRange(),
                dailyCalorieIntake,
                user.getHealthAdvice(),
                user.getRecommendedNutrition()
        ));

        if (weightToLose > 0) {
            infoArea.append(String.format("Weight to lose: %.1f kg\nEstimated days to reach ideal weight: %d days\n",
                    weightToLose, estimatedDaysToIdealWeight));
        } else {
            infoArea.append("You are within your ideal weight range. Maintain your healthy lifestyle!\n");
        }

        panel.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> showLoginScreen());
        panel.add(logoutButton, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMIAppGUI::new);
    }
}
