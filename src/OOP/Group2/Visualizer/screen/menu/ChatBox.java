package OOP.Group2.Visualizer.screen.menu;

import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatBox extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea chatArea;

    public ChatBox() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 790);
        setTitle("Q&A");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font(null, Font.BOLD, 13));
        chatArea.setForeground(colorConcept.TEXT);
        chatArea.setBackground(colorConcept.CANVAS_BACKGROUND);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setBackground(colorConcept.CANVAS_BACKGROUND);
        panel.setLayout(new BorderLayout(0, 0));

        textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);
        textField.setFont(new Font(null, Font.BOLD, 11));
        textField.setBackground(colorConcept.CANVAS_BACKGROUND);
        textField.setForeground(colorConcept.TEXT);
        textField.setColumns(10);

        JButton btnSend = new JButton("Send");
        btnSend.setBackground(colorConcept.TEXT_YELLOW);
        btnSend.setForeground(colorConcept.TEXT);
        btnSend.setFocusable(false);
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                if (!userInput.isEmpty()) {
                    chatArea.append("You: " + userInput + "\n\n");
                    String answer = ChatGPTAPI.chatGPT(userInput);
                    textField.setText("");
                    chatArea.append("BACH KHOA TOAN THU: " + answer + "\n\n");
                }
            }
        });
        panel.add(btnSend, BorderLayout.EAST);

        JButton btnClear = new JButton("Clear");
        btnClear.setFocusable(false);
        btnClear.setBackground(colorConcept.TEXT_YELLOW);
        btnClear.setForeground(colorConcept.TEXT);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatArea.setText("");
            }
        });
        panel.add(btnClear, BorderLayout.WEST);
    }
}
