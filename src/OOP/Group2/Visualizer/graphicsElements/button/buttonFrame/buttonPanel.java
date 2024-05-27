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
    private static final int BUTTON_WIDTH = 200, BUTTON_HEIGHT = 60;
    private JLabel[] buttons;
    private SortButtonListener listener;
    private int number = 9; 

    public buttonPanel(SortButtonListener listener){
        super();
        this.listener = listener;

        buttons = new JLabel[number];
        for (int i = 0; i < buttons.length; i++)
        buttons[i] = new JLabel();

        initButtons(buttons[0], "create_button", 0);
        initButtons(buttons[1], "radix_button", 1);
        initButtons(buttons[2], "counting_button", 2);
        initButtons(buttons[3], "merge_button", 3);
        initButtons(buttons[4], "quick_sort_button", 4);
        initButtons(buttons[5], "bubble_button", 5);
        initButtons(buttons[6], "selection_button", 6);
        initButtons(buttons[7], "shell_button", 7);
        initBackButton(buttons[8], 8);
        setLayout(null);
        for (int i = 0; i < buttons.length; i++) {
            if (i == 0) buttons[i].setBounds(10, 20, BUTTON_WIDTH, BUTTON_HEIGHT);
            else buttons[i].setBounds(10, 45 + (BUTTON_HEIGHT + 15) * i, BUTTON_WIDTH, BUTTON_HEIGHT);
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
                listener.sortButtonClicked(id);
                setButtonIcon(button, name + "_entered");
            }
        });
        button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    public void setButtonIcon(JLabel button, String iconName ){
        String currentDirectory = System.getProperty("user.dir"); // Lấy đường dẫn thư mục hiện tại của ứng dụng
		// System.out.println(currentDirectory);
		String path = String.format("%s/buttons/%s.png", currentDirectory, iconName); //dynamic đường dẫn
        button.setIcon(new ImageIcon(path));
    }
    private void initBackButton(JLabel button, int id) {
        button.setText("< Back to menu");
        Font buttonFont = button.getFont().deriveFont(Font.BOLD, 20f);
        Dimension buttonSize = new Dimension(200, 80);
        button.setFont(buttonFont);
        button.setPreferredSize(buttonSize);
        button.setForeground(colorConcept.TEXT);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.sortButtonClicked(id);
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


    public interface SortButtonListener {
        void sortButtonClicked(int id);
    }
}
