package OOP.Group2.Visualizer.screen.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import OOP.Group2.Visualizer.graphicsElements.myFormatter.myFormatter;

public class menuSortingBasic extends JFrame implements PropertyChangeListener,
        ChangeListener, sorter.SortedListener,
        buttonPanel.SortButtonListener, myCanvas.VisualizerProvider {
    public static final long serialVersionUID = 10L;
    private static final int WIDTH = 1920, HEIGHT = 1090;
    private static final int CAPACITY = 50, FPS = 100;
    private JPanel mainPanel, inputPanel, sliderPanel, inforPanel;
    private buttonPanel buttonPanel;
    private JLabel capacityLabel, fpsLabel, timeLabel, compLabel, swapLabel;

    private JButton backButton;
    private JFormattedTextField capacityField;
    private JFormattedTextField fpsField;
    private myCanvas canvas;
    private sorter sorter;

    public menuSortingBasic() {
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

    private void initialize() {
      //code Basic sorting 
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
        // Not used as we switched to fpsField
    }

    // button clicked
    public void sortButtonClicked(int id) {
        switch (id) {
            case 0:  // create button
                sorter.createRandomArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 1:  // radix button
                sorter.radixSort();
                break;
            case 2:  // counting button
                sorter.countingSort();
                break;
            case 3:  // merge button
                sorter.mergeSort();
                break;
            case 4: //quick sort
                sorter.quickSort();
                break;
            case 5: //buble sort
                sorter.bubbleSort();
                break;
            case 6: //selection sort
                sorter.selectionSort();
                break;
            case 7: //shell sort
                sorter.shellSort();
                break;
            case 8:  //back button
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
