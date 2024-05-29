package OOP.Group2.Visualizer.graphicsElements.button.buttonFrame;

import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class buttonPanel extends JPanel{
    public static final long serialVersionUID = 1L;
    private static final int BUTTON_WIDTH = 260, BUTTON_HEIGHT = 78;
    private JLabel[] buttons;
    private ButtonListener listener;
    private int number = 9;

    public buttonPanel(ButtonListener listener){
        super();
        this.listener = listener;

        buttons = new JLabel[number];
        for (int i = 0; i < buttons.length; i++)
            buttons[i] = new JLabel();

        initButtons(buttons[0], "random_button", 0);
        initButtons(buttons[1], "unique_button", 1);
        initButtons(buttons[2], "reverse_button", 2);
        initButtons(buttons[3], "nearly_button", 3);
        initButtons(buttons[4], "pause_button", 4);
        initButtons(buttons[5], "continue_button", 5);
        initBackButton(buttons[6], 6);
        setLayout(null);
        for (int i = 0; i < buttons.length; i++) {
            if (i == 6) buttons[i].setBounds(30, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
            else if (i == 5) buttons[i].setBounds(610, 160, BUTTON_WIDTH, BUTTON_HEIGHT);
            else if (i == 4) buttons[i].setBounds(610, 70, BUTTON_WIDTH, BUTTON_HEIGHT);
            else if (i > 1) buttons[i].setBounds(30 + (BUTTON_WIDTH + 30) * (i - 2), 160, BUTTON_WIDTH, BUTTON_HEIGHT);
            else buttons[i].setBounds(30+ (BUTTON_WIDTH + 30) * i, 70, BUTTON_WIDTH, BUTTON_HEIGHT);
            add(buttons[i]);
        }

    }
    private void initButtons(JLabel button, String name, int id) {
        setButtonIcon(button, name);
        button.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}

            public void mouseEntered(MouseEvent e) {
                setButtonIcon(button, name + "_entered");
            }

            public void mouseExited(MouseEvent e) {
                setButtonIcon(button, name);
            }

            public void mousePressed(MouseEvent e) {
                setButtonIcon(button, name + "_pressed");
            }

            public void mouseReleased(MouseEvent e) {
                listener.ButtonClicked(id);
                setButtonIcon(button, name + "_entered");
            }
        });
        button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    public void setButtonIcon(JLabel button, String iconName ){
        String currentDirectory = System.getProperty("user.dir"); // Lấy đường dẫn thư mục hiện tại của ứng dụng
        // System.out.println(currentDirectory);
        String path = String.format("%s/src/OOP/Group2/Visualizer/graphicsElements/button/buttonImage/%s.png", currentDirectory, iconName); //dynamic đường dẫn
        button.setIcon(new ImageIcon(path));
    }
    private void initBackButton(JLabel button, int id) {
        button.setText("< Back to menu");
        Font buttonFont = button.getFont().deriveFont(Font.BOLD, 22f);
        Dimension buttonSize = new Dimension(200, 80);
        button.setFont(buttonFont);
        button.setPreferredSize(buttonSize);
        button.setForeground(colorConcept.TEXT);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.ButtonClicked(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }


    public interface ButtonListener {
        void ButtonClicked(int id);
    }
}
