package OOP.Group2.Visualizer.screen;


//import libaries
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import internal
import OOP.Group2.Visualizer.graphicsElements.color.*;
import OOP.Group2.Visualizer.screen.menu.*;


public class mainMenu extends JFrame{
    private JPanel mainPanel, container;
    private JLabel titleLabel;
    private JButton helpMenuButton, quitButton, sortBasicButton, sortMultiButton;
    private static final int WIDTH = 1920, HEIGHT = 1090;

    public mainMenu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setTitle("TEAM 2's Sorting Visualizer");

        // Load GIF
        ImageIcon gifIcon = new ImageIcon("D:\\code\\SortingDemonstrate\\src\\OOP\\Group2\\Visualizer\\graphicsElements\\background\\menuBackground.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setLayout(new BorderLayout());

        setContentPane(gifLabel);
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
        container.setBackground(colorConcept.TRANSPARENT);

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
                new menuSortingBasic().setVisible(true);
                dispose();
            }
        });
        //add multi sort button 
        sortMultiButton = new JButton("Multiple Sort");
        sortMultiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // new menuSortingMulti().setVisible(true);
                dispose();
            }
        });

        //add help button
        helpMenuButton = new JButton("Help");
        helpMenuButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                new menuHelping(); 
                dispose();
            }
        });

        //add quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int input = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Quit", 2);
                //0=yes, 1=no
                if(input == 0){
                    System.exit(0);
                }
            }
        });
        
        //set font, size for button
        Font buttonnFont = sortBasicButton.getFont().deriveFont(Font.PLAIN, 30f);
        Dimension buttonSize = new Dimension(320,75);
        sortBasicButton.setFont(buttonnFont);
        sortMultiButton.setFont(buttonnFont);
        helpMenuButton.setFont(buttonnFont);
        quitButton.setFont(buttonnFont);
        sortBasicButton.setPreferredSize(buttonSize);
        sortMultiButton.setPreferredSize(buttonSize);
        helpMenuButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

        //add title Sorting Visualization
        container.add(titleLabel,BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        buttonPanel.add(sortBasicButton,gbc);
        gbc.gridy++;
        buttonPanel.add(sortMultiButton,gbc);
        gbc.gridy++;
        buttonPanel.add(helpMenuButton,gbc);
        gbc.gridy++;
        buttonPanel.add(quitButton,gbc);
        buttonPanel.setBackground(colorConcept.TRANSPARENT);

        container.add(buttonPanel,BorderLayout.CENTER);



    }
}
