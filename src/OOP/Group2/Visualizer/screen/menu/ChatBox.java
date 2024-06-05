package OOP.Group2.Visualizer.screen.menu;

import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import OOP.Group2.Visualizer.graphicsElements.env;
public class ChatBox extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextPane chatPane;
    private JLabel loadingLabel;

    public ChatBox() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 790);
        setTitle("AI Assisstant");
        ImageIcon logoIcon = new ImageIcon(env.AVATAR_AI);
        Image logo = logoIcon.getImage(); // Extract the Image from ImageIcon
        setIconImage(logo); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        chatPane = new JTextPane();
        chatPane.setEditable(false);
        chatPane.setFont(new Font(null, Font.BOLD, 13));
        chatPane.setForeground(colorConcept.TEXT);
        JScrollPane scrollPane = new JScrollPane(chatPane);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setBackground(colorConcept.CANVAS_BACKGROUND);
        panel.setLayout(new BorderLayout(0, 0));

        textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);
        textField.setFont(new Font(null, Font.BOLD, 11));
        textField.setForeground(colorConcept.TEXT);
        textField.setColumns(10);

        // Create the loading label
        loadingLabel = new JLabel(new ImageIcon(env.WAITING_TEXT));
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);
        loadingLabel.setVisible(false); // Initially hidden
        contentPane.add(loadingLabel, BorderLayout.NORTH);

        JButton btnSend = new JButton("Send");
        btnSend.setBackground(colorConcept.TEXT_YELLOW);
        btnSend.setForeground(colorConcept.TEXT);
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                if (!userInput.isEmpty()) {
                    appendToPane(chatPane, "You: " + userInput + "\n", Color.RED);
                    textField.setText(""); // Clear the text field after sending

                    // Show the loading GIF
                    loadingLabel.setVisible(true);

                    // Create a new Thread to call the API and display the answer
                    new Thread(() -> {
                        String answer = VirtualAssisstant.chatGPT(userInput);
                        SwingUtilities.invokeLater(() -> {
                            // Hide the loading GIF
                            loadingLabel.setVisible(false);
                            appendToPane(chatPane, "BACH KHOA TOAN THU: \n", Color.RED);
                            appendToPane(chatPane, answer + "\n", colorConcept.TEXT);
                        });
                    }).start();
                }
            }
        });
        panel.add(btnSend, BorderLayout.EAST);

        JButton btnClear = new JButton("Clear");
        btnClear.setBackground(colorConcept.TEXT_YELLOW);
        btnClear.setForeground(colorConcept.TEXT);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatPane.setText("");
            }
        });
        panel.add(btnClear, BorderLayout.WEST);
    }

    private void appendToPane(JTextPane tp, String msg, Color c) {
        StyledDocument doc = tp.getStyledDocument();
        Style style = tp.addStyle("Color Style", null);
        StyleConstants.setForeground(style, c);
        try {
            doc.insertString(doc.getLength(), msg, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
