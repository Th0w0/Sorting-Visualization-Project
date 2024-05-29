package OOP.Group2.Visualizer.screen.menu;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import OOP.Group2.Visualizer.graphicsElements.animation.sorter.sorter;
import OOP.Group2.Visualizer.graphicsElements.canvas.myCanvas;
import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import OOP.Group2.Visualizer.screen.mainMenu;
import OOP.Group2.Visualizer.graphicsElements.button.buttonFrame.buttonPanel;

public class menuSortingMulti extends JFrame implements PropertyChangeListener,
    ChangeListener, sorter.SortedListener,
    buttonPanel.ButtonListener, myCanvas.VisualizerProvider{
    public static final long serialVersionUID = 10L;
    private static final int WIDTH = 1920, HEIGHT = 1090;
    private static final int CAPACITY = 50, FPS = 100;
    private JPanel mainPanel, inputPanel, sliderPanel, inforPanel;
    private buttonPanel buttonPanel;
    private JLabel capacityLabel, fpsLabel, timeLabel, compLabel, swapLabel;

    private JButton backButton;
    private JFormattedTextField capacityField;
    private JSlider fpsSlider;
    private myCanvas canvas;
    private sorter sorter;


    public menuSortingMulti(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(WIDTH, HEIGHT + 200));
        setMinimumSize(new Dimension(WIDTH, HEIGHT + 20));
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 20));
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(colorConcept.BACKGROUND);
        setTitle("TEAM 2's Sorting");
        initialize();
    }
    public void initialize(){
        //layout of the multi frame











        
    }


    /* IMPLEMENTED METHODS */

    // the capacity is changed
    public void propertyChange(PropertyChangeEvent e) {
    // update capacity
    int value = ((Number) capacityField.getValue()).intValue();
    sorter.setCapacity(value);
    }


    // the speed (fps) is changed
    public void stateChanged(ChangeEvent e) {
    if (!fpsSlider.getValueIsAdjusting()) {
        int value = (int) fpsSlider.getValue();
        sorter.setFPS(value);
    }
    }


    // button clicked
    public void ButtonClicked(int id) {
        switch (id) {
            case 0:  // create button
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
            case 4: //back
                new mainMenu();
                dispose();
        }
    }


    // draw the array
    public void onDrawArray() {
        if (sorter != null)
            sorter.drawArray();
    }


    // showing statistics when sorting is completed
    public void onArraySorted(long elapsedTime, int comp, int swapping) {
        timeLabel.setText("Elapsed Time: " + (int) (elapsedTime / 1000.0) + " µs");
        compLabel.setText("Comparisons: " + comp);
        swapLabel.setText("Swaps: " + swapping);
    }


    // return the graphics for drawing
    public BufferStrategy getBufferStrategy() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(2);
            bs = canvas.getBufferStrategy();
        }

        return bs;
    }

    }

