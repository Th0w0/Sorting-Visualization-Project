package OOP.Group2.Visualizer.screen.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import OOP.Group2.Visualizer.screen.mainMenu;

public class menuHelping {
    private static final int WIDTH = 1920, HEIGHT = 1090;

    public menuHelping() {
        initialize();
    }

    private void initialize() {
        JFrame helpFrame = new JFrame("Help Guide");
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setSize(WIDTH, HEIGHT);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setBackground(colorConcept.BACKGROUND);
        // Create back button
        JButton backButton = new JButton("< Back to the menu");
        backButton.setBackground(colorConcept.TRANSPARENT);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set larger and nicer font
        backButton.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
        backButton.setBorderPainted(false); // Remove border
        backButton.setContentAreaFilled(false); // Remove background fill
        backButton.setFocusPainted(false); // Remove focus border
        backButton.setMargin(new Insets(0, 10, 0, 0)); // Remove margin
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainMenu().setVisible(true);
                helpFrame.dispose(); // Close the help frame
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(colorConcept.BACKGROUND);

        // Panel to hold images
        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        imagePanel.setBackground(colorConcept.BACKGROUND);
        for (int i = 1; i <= 4; i++) {
            JLabel label = new JLabel(new ImageIcon("D:\\github\\SortingDemonstrate\\src\\OOP\\Group2\\Visualizer\\graphicsElements\\helping\\helping" + i + ".png"));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(label);
        }

        panel.add(backButton, BorderLayout.NORTH);
        panel.add(imagePanel, BorderLayout.CENTER);

        helpFrame.add(panel);
        helpFrame.setVisible(true); // Display the JFrame
    }

    public static void main(String[] args) {
        new menuHelping();
    }
}
