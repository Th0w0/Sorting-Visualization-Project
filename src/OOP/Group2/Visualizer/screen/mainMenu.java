package OOP.Group2.Visualizer.screen;


//import libaries
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import internal
import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import OOP.Group2.Visualizer.screen.menu.menuSortingBasic;


public class mainMenu extends JFrame{
    private JPanel mainPanel, container;
    private JLabel titleLabel;
    private JButton helpMenuButton, quitButton, sortBasicButton, sortMultiButton;
    private static final int WIDTH = 1024, HEIGHT = 768;

    public mainMenu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setBackground(colorConcept.BACKGROUND);
        setTitle("TEAM 2's Sorting Visualizer");
        initialize();
        setVisible(true);
    }
    private void initialize(){
        int topPadding = 100;
        int leftPadding = 0;
        int bottomPadding = 10;
        int rightPadding = 0;

        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(colorConcept.BACKGROUND);

        // add title label
        titleLabel = new JLabel("Sorting Visualizer");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 50f));
        titleLabel.setForeground(colorConcept.TEXT);
        titleLabel.setBorder(new EmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));

        //add basic sort button 
        sortBasicButton = new JButton("Basic Sort");
        sortBasicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // new menuSortingBasic().setVisible(true);
                dispose();
            }
        });



    }
}
