package OOP.Group2.Visualizer.screen.menu;

import OOP.Group2.Visualizer.graphicsElements.animation.sorter.sorter;
import OOP.Group2.Visualizer.graphicsElements.button.buttonFrame.buttonPanel;
import OOP.Group2.Visualizer.graphicsElements.canvas.myCanvas;
import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import OOP.Group2.Visualizer.graphicsElements.myFormatter.myFormatter;
import OOP.Group2.Visualizer.screen.mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import OOP.Group2.Visualizer.graphicsElements.env;

public class menuSortingBasic extends JFrame implements sorter.SortedListener,
        buttonPanel.ButtonListener, myCanvas.VisualizerProvider {
    public static final long serialVersionUID = 10L;
    private static final int WIDTH = 1100, HEIGHT = 768;
    private static final int CAPACITY = 50, FPS = 50;
    private JPanel mainPanel, capacityPanel, fpsPanel, inforPanel, sortPanel;
    private buttonPanel buttonPanel;
    private JLabel capacityLabel, fpsLabel, timeLabel, compLabel, swapLabel, sortLabel;

    private JButton backButton;
    private JFormattedTextField capacityField;
    private JFormattedTextField fpsField;
    private myCanvas canvas;
    private sorter sorter;
    private SwingWorker<Void, Void> sortWorker;
    private ChatBox chatBox;

    public menuSortingBasic() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(WIDTH, HEIGHT + 200));
        setMinimumSize(new Dimension(WIDTH, HEIGHT + 20));
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 20));
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(colorConcept.BACKGROUND);
        setTitle("TEAM 2's Sorting");
        ImageIcon logoIcon = new ImageIcon(env.AVATAR_APP);
        Image logo = logoIcon.getImage(); // Extract the Image from ImageIcon
        setIconImage(logo); 
        initialize();
    }

    private void initialize() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(colorConcept.BACKGROUND);
        add(mainPanel);

        backButton = new JButton("Back to menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainMenu();
                dispose();
            }
        });

        buttonPanel = new buttonPanel(this);
        buttonPanel.setBounds(150, 576, 500, 250);
        buttonPanel.setBackground(colorConcept.BACKGROUND);
        mainPanel.add(buttonPanel);

        canvas = new myCanvas(this);
        int cWidth = 1100;
        int cHeight = 3 * HEIGHT / 4 - 15;
        canvas.setFocusable(false);
        canvas.setMaximumSize(new Dimension(cWidth, cHeight));
        canvas.setMinimumSize(new Dimension(cWidth, cHeight));
        canvas.setPreferredSize(new Dimension(cWidth, cHeight));
        canvas.setBounds(0, 0, cWidth, cHeight);
        mainPanel.add(canvas);
        pack();

        sorter = new sorter(CAPACITY, FPS, this);
        sorter.createRandomArray(canvas.getWidth(), canvas.getHeight());

        JLabel fpsLabel = new JLabel("FPS");
        fpsLabel.setForeground(colorConcept.TEXT);
        fpsLabel.setFont(new Font(null, Font.BOLD, 13));

        NumberFormat format1 = NumberFormat.getNumberInstance();
        myFormatter formatter1 = new myFormatter(format1);
        JFormattedTextField fpsField = new JFormattedTextField(formatter1);
        fpsField.setValue(FPS);
        fpsField.setColumns(3);
        fpsField.setFont(new Font(null, Font.PLAIN, 13));
        fpsField.setForeground(colorConcept.TEXT);
        fpsField.setBackground(colorConcept.CANVAS_BACKGROUND);
        fpsField.setCaretColor(colorConcept.BAR_YELLOW);
        fpsField.setBorder(BorderFactory.createLineBorder(colorConcept.FIELD_BORDER, 1));
        fpsLabel.setLabelFor(fpsField);

        JPanel fpsPanel = new JPanel(new GridLayout(1, 0));
        fpsPanel.add(fpsLabel);
        fpsPanel.add(fpsField);
        fpsPanel.setBackground(colorConcept.BACKGROUND);
        fpsPanel.setBounds(20, 670,130, 40);
        mainPanel.add(fpsPanel);

        fpsField.addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                int value2 = ((Number) fpsField.getValue()).intValue();
                sorter.setFPS(value2);
            }
        });

        JLabel capacityLabel = new JLabel("Capacity");
        capacityLabel.setForeground(colorConcept.TEXT);
        capacityLabel.setFont(new Font(null, Font.BOLD, 13));

        NumberFormat format2 = NumberFormat.getNumberInstance();
        myFormatter formatter2 = new myFormatter(format2);
        JFormattedTextField capacityField = new JFormattedTextField(format2);
        capacityField.setValue(CAPACITY);
        capacityField.setColumns(3);
        capacityField.setFont(new Font(null, Font.PLAIN, 13));
        capacityField.setForeground(colorConcept.TEXT);
        capacityField.setBackground(colorConcept.CANVAS_BACKGROUND);
        capacityField.setCaretColor(colorConcept.BAR_YELLOW);
        capacityField.setBorder(BorderFactory.createLineBorder(colorConcept.FIELD_BORDER, 1));
        capacityLabel.setLabelFor(capacityField);

        JPanel capacityPanel = new JPanel(new GridLayout(1, 0));
        capacityPanel.add(capacityLabel);
        capacityPanel.add(capacityField);
        capacityPanel.setBackground(colorConcept.BACKGROUND);
        capacityPanel.setBounds(20, 620,130, 40);
        mainPanel.add(capacityPanel);

        capacityField.addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                int value1 = ((Number) capacityField.getValue()).intValue();
                sorter.setCapacity(value1);
            }
        });

        timeLabel = new JLabel("Elapsed Time: 0 µs");
        timeLabel.setFont(new Font(null, Font.BOLD, 15));
        timeLabel.setForeground(colorConcept.TEXT);

        compLabel = new JLabel("Comparisons: 0");
        compLabel.setFont(new Font(null, Font.BOLD, 15));
        compLabel.setForeground(colorConcept.TEXT);

        swapLabel = new JLabel("Swaps: 0");
        swapLabel.setFont(new Font(null, Font.BOLD, 15));
        swapLabel.setForeground(colorConcept.TEXT);

        inforPanel = new JPanel(new GridLayout(3, 1));
        inforPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        inforPanel.add(timeLabel);
        inforPanel.add(compLabel);
        inforPanel.add(swapLabel);
        inforPanel.setBackground(colorConcept.BACKGROUND);
        inforPanel.setBounds(860, 610, 200, 110);
        mainPanel.add(inforPanel);

        String[] sortOptions = {
                " ",
                "BubbleSort",
                "CountingSort",
                "MergeSort",
                "QuickSort",
                "RadixSort",
                "SelectionSort",
                "ShellSort"
        };

        sortLabel = new JLabel("Choose an Algorithm:");
        sortLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        sortLabel.setFont(new Font(null, Font.BOLD, 12));
        sortLabel.setForeground(colorConcept.TEXT);

        JComboBox<String> comboBox = new JComboBox<>(sortOptions);
        comboBox.setPreferredSize(new Dimension(100, 35));
        comboBox.setBackground(colorConcept.CANVAS_BACKGROUND);
        comboBox.setForeground(colorConcept.TEXT);
        comboBox.setFont(new Font(null, Font.PLAIN, 14));

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSort = (String) comboBox.getSelectedItem();
                if (selectedSort != null) {
                    switch (selectedSort) {
                        case " ":
                            break;
                        case "BubbleSort":
                            sorter.bubbleSort();
                            break;
                        case "CountingSort":
                            sorter.countingSort();
                            break;
                        case "MergeSort":
                            sorter.mergeSort();
                            break;
                        case "QuickSort":
                            sorter.quickSort();
                            break;
                        case "RadixSort":
                            sorter.radixSort();
                            break;
                        case "SelectionSort":
                            sorter.selectionSort();
                            break;
                        case "ShellSort":
                            sorter.shellSort();
                            break;
                    }
                }
            }
        });

        sortPanel = new JPanel();
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.Y_AXIS));
        sortPanel.setBackground(colorConcept.BACKGROUND);
        sortPanel.add(sortLabel);
        sortPanel.add(comboBox);
        sortPanel.setBounds(680, 628, 140, 60);
        mainPanel.add(sortPanel);

        JButton chatBoxButton = new JButton("Chatbox");
        chatBoxButton.setBounds(20, 580, 100, 30);
        chatBoxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chatBox == null || !chatBox.isDisplayable()) {
                    chatBox = new ChatBox();
                    chatBox.setLocation(menuSortingBasic.this.getX() + menuSortingBasic.this.getWidth(), menuSortingBasic.this.getY());
                    chatBox.setVisible(true);
                }
            }
        });
        mainPanel.add(chatBoxButton);
    }

    public void ButtonClicked(int id) {
        switch (id) {
            case 0:
                sorter.createRandomArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 1:
                sorter.createFewUniqueArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 2:
                sorter.createReverseArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 3:
                sorter.createNearlySortArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 4:
                sorter.pause();
                break;
            case 5:
                sorter.resume();
                break;
            case 6:
                new mainMenu();
                dispose();
        }
    }

    public void onDrawArray() {
        if (sorter != null)
            sorter.drawArray();
    }

    public void onArraySorted(long elapsedTime, int comp, int swapping) {
        timeLabel.setText("Elapsed Time: " + (int) (elapsedTime / 1000.0) + " µs");
        compLabel.setText("Comparisons: " + comp);
        swapLabel.setText("Swaps: " + swapping);
    }

    public BufferStrategy getBufferStrategy() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(2);
            bs = canvas.getBufferStrategy();
        }
        return bs;
    }

    @Override
    public myCanvas getCanvas() {
        return canvas;
    }
}
