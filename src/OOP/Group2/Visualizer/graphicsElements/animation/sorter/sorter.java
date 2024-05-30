package OOP.Group2.Visualizer.graphicsElements.animation.sorter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.security.DrbgParameters.Capability;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import OOP.Group2.Visualizer.graphicsElements.bars.bars;
import OOP.Group2.Visualizer.graphicsElements.canvas.myCanvas;
import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
import OOP.Group2.Visualizer.sorting.BubbleSort;
import OOP.Group2.Visualizer.sorting.CountingSort;
import OOP.Group2.Visualizer.sorting.MergeSort;
import OOP.Group2.Visualizer.sorting.QuickSort;
import OOP.Group2.Visualizer.sorting.RadixSort;
import OOP.Group2.Visualizer.sorting.SelectionSort;
import OOP.Group2.Visualizer.sorting.ShellSort;

public class sorter {
    private static final int PADDING = 20;
    private static final int MAX_BAR_HEIGHT = 350 , MIN_BAR_HEIGHT = 30;
    private Integer[] array;
    private int capacity, speed, colo;
    private bars[] bars;
    private static boolean hasArray;
    // statistic
    private long startTime, time;
    private int comp, swapping;
    private Color originalColor, swappingColor, comparingColor;
    private BufferStrategy bs;
    private Graphics g;
    private SortedListener listener;
    private boolean isPaused = false; 
    private final Object pauseLock = new Object();
    private SwingWorker<Void, Void> sortWorker;
    

    public sorter(int capacity, int fps, SortedListener listener){
        this.capacity = capacity;
        this.speed = (int) (5000.0/fps);
        this.listener = listener;
        startTime = time = comp = swapping = 0;

        originalColor = colorConcept.BAR_WHITE;
        comparingColor = colorConcept.BAR_GREEN;
        swappingColor = colorConcept.BAR_RED;
        
        bs = listener.getBufferStrategy();
        hasArray = false;
    }
    /*CREATE ARRAY WITH MANY TYPE*/
    public void createRandomArray(int canvasWidth, int canvasHeight){
        array = new Integer[capacity];
        bars = new bars[capacity];
        hasArray = true;
        
        double x = PADDING; // toa do ben tren, trai
        int y = canvasHeight - PADDING; // toa do ben tren, trai

        double width = (double) (canvasWidth - PADDING*2) / capacity;
        
        g = bs.getDrawGraphics();
        g.setColor(colorConcept.CANVAS_BACKGROUND);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        
        Random rand = new Random();
        int value;
        bars bar;
        for(int i = 0 ;i < array.length ; i++){
            value = rand.nextInt(MAX_BAR_HEIGHT) + MIN_BAR_HEIGHT;
            array[i] = value;
            bar = new bars((int)x,y,(int)width,value,originalColor);
            bar.draw(g);
            bars[i] = bar;

            x+=width;
        }
        bs.show();
        g.dispose();
    }
    public void createNearlySortArray(int canvasWidth, int canvasHeight) {
        array = new Integer[capacity];
        bars = new bars[capacity];
        hasArray = true;
    
        double x = PADDING; // tọa độ bên trái trên
        int y = canvasHeight - PADDING; // tọa độ bên trái dưới
    
        double width = (double) (canvasWidth - PADDING * 2) / capacity;
    
        g = bs.getDrawGraphics();
        g.setColor(colorConcept.CANVAS_BACKGROUND);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
    
        int baseValue = MIN_BAR_HEIGHT;
        bars bar;
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int coef = i + random.nextInt(11) - 5;
            int value = baseValue + coef *((MAX_BAR_HEIGHT - MIN_BAR_HEIGHT) / capacity);
    
            // Thêm biến đổi nhỏ ngẫu nhiên trong khoảng từ -20 đến 20
            value += random.nextInt(41) - 20; // biến đổi ngẫu nhiên từ -20 đến 20
    
            array[i] = value;
            bar = new bars((int)x, y, (int)width, value, originalColor);
            bar.draw(g);
            bars[i] = bar;
    
            x += width;
        }
        bs.show();
        g.dispose();
    }
    
    
    
    public void createReverseArray(int canvasWidth, int canvasHeight){
        array = new Integer[capacity];
        bars = new bars[capacity];
        hasArray = true;
        
        double x = PADDING; // toa do ben tren, trai
        int y = canvasHeight - PADDING; // toa do ben tren, trai
    
        double width = (double) (canvasWidth - PADDING*2) / capacity;
        
        g = bs.getDrawGraphics();
        g.setColor(colorConcept.CANVAS_BACKGROUND);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        
        int baseValue = MAX_BAR_HEIGHT;
        bars bar;
        for(int i = 0; i < array.length; i++){
            int value = baseValue - i * ((MAX_BAR_HEIGHT - MIN_BAR_HEIGHT) / capacity);
            array[i] = value;
            bar = new bars((int)x, y, (int)width, value, originalColor);
            bar.draw(g);
            bars[i] = bar;
    
            x += width;
        }
        bs.show();
        g.dispose();
    }
    
    public void createFewUniqueArray(int canvasWidth, int canvasHeight){
        array = new Integer[capacity];
        bars = new bars[capacity];
        hasArray = true;
        
        double x = PADDING; // toa do ben tren, trai
        int y = canvasHeight - PADDING; // toa do ben tren, trai
    
        double width = (double) (canvasWidth - PADDING*2) / capacity;
        
        g = bs.getDrawGraphics();
        g.setColor(colorConcept.CANVAS_BACKGROUND);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        
        Random rand = new Random();
        int[] uniqueValues = new int[5];
        for(int i = 0; i < uniqueValues.length; i++){
            uniqueValues[i] = rand.nextInt(MAX_BAR_HEIGHT) + MIN_BAR_HEIGHT;
        }
        
        bars bar;
        for(int i = 0; i < array.length; i++){
            int value = uniqueValues[rand.nextInt(uniqueValues.length)];
            array[i] = value;
            bar = new bars((int)x, y, (int)width, value, originalColor);
            bar.draw(g);
            bars[i] = bar;
    
            x += width;
        }
        bs.show();
        g.dispose();
    }
    
    /*PAUSE, CONTINUE*/
    public void pause() {
        isPaused = true;
    }
    
    public void resume() {
        synchronized (pauseLock) {
            isPaused = false;
            pauseLock.notifyAll();
        }
    }
    private void checkPause() {
    synchronized (pauseLock) {
            while (isPaused) {
                try {
                    pauseLock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    

    /*SORT */
    private void colorBar(int index, Color color)
    {   
        //đặt màu cột = color truyền vào sau đấy trả về màu gốc
        bars bar = bars[index];
        Color oldColor = bar.getColor();

        bar.setColor(color);
        bar.draw(g);
        bs.show();

        try {
            TimeUnit.MILLISECONDS.sleep(speed);
        } catch (Exception ex) {}

        bar.setColor(oldColor);
        bar.draw(g);

        bs.show();
    }
    /*SORTING WITH ANIMATION */

    /* RADIX SORT */
    private static int getMax(Integer arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    void countSort(Integer arr[], int n, int exp, int comp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
    
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            checkPause(); // Check for pause
            count[(arr[i] / exp) % 10]++;
        }
    
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            checkPause(); // Check for pause
            count[i] += count[i - 1];
        }
    
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            checkPause(); // Check for pause
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            swapping++;
            count[(arr[i] / exp) % 10]--;
        }
    
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {
            checkPause(); // Check for pause
            arr[i] = output[i];
            bars[i].clear(g);
            bars[i].setValue(arr[i]);
            if (colo % 2 == 0) {
                bars[i].setColor(swappingColor);
            } else {
                bars[i].setColor(comparingColor);
            }
            bars[i].draw(g);
            bs.show();
            try {
                TimeUnit.MILLISECONDS.sleep(speed);
            } catch (Exception ex) {}
        }
    }
    
    public void radixSort() {
        if (!isCreated())
            return;
    
        // get graphics
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        RadixSort.radixSort(array.clone(), array.length);
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
        int m = getMax(array,array.length);
        colo = 0;
        for (int exp = 1; m/exp > 0; exp *= 10){
            checkPause(); // Check for pause
    
            countSort(array, array.length, exp, comp);
            colo++;
        }
    
        finishAnimation();
    
        g.dispose();
    }
    
    /*COUNTING SORT*/
    public void countingSort() {
        if (!isCreated())
            return;
    
        // get graphics
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        CountingSort.countingSort(array.clone());
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
        int N = array.length;
        int M = 0;
    
        for (int i = 0; i < N; i++) {
            M = Math.max(M, array[i]);
        }
    
        int[] countArray = new int[M + 1];
    
        for (int i = 0; i < N; i++) {
            checkPause(); // Check for pause
    
            countArray[array[i]]++;
            swapping++;
        }
    
        for (int i = 1; i <= M; i++) {
            checkPause(); // Check for pause
    
            countArray[i] += countArray[i - 1];
            swapping++;
        }
    
        int[] outputArray = new int[N];
    
        for (int i = N - 1; i >= 0; i--) {
            checkPause(); // Check for pause
    
            outputArray[countArray[array[i]] - 1] = array[i];
            swapping++;
            countArray[array[i]]--;
        }
    
        for (int i = 0; i < N; i++) {
            checkPause(); // Check for pause
    
            array[i] = outputArray[i];
            swapping++;
            bars[i].clear(g);
            bars[i].setValue(array[i]);
            if (colo % 2 == 0) {
                bars[i].setColor(swappingColor);
            } else {
                bars[i].setColor(comparingColor);
            }
            bars[i].draw(g);
            bs.show();
            try {
                TimeUnit.MILLISECONDS.sleep(speed);
            } catch (Exception ex) {}
        }
    
        finishAnimation();
    
        g.dispose();
    }
    
    /* MERGE SORT */
    public void mergeSort() {
        if (!isCreated())
            return;
    
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        MergeSort.mergeSort(array.clone());
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
    
        mergeSort(0, array.length-1);
    
        finishAnimation();
        g.dispose();
    }
    
    // recursive mergeSort
// recursive mergeSort
private void mergeSort(int left, int right) {
    if (left >= right)
        return;

    // find the middle
    int middle = (right + left) / 2;

    checkPause(); // Check for pause

    // sort the left half
    mergeSort(left, middle);

    checkPause(); // Check for pause

    // sort the second half
    mergeSort(middle+1, right);

    checkPause(); // Check for pause

    // merge them
    merge(left, middle, right);
}

// merge for mergeSort
private void merge(int left, int middle, int right) {
    Color mergeColor = getBarColor(middle);

    // number of items in the first half
    int n1 = middle - left + 1;
    int n2 = right - middle;  // second half

    // create array for those parts
    int[] leftArr = new int[n1];
    for (int i = 0; i < n1; i++)
        leftArr[i] = array[left+i];

    int[] rightArr = new int[n2];
    for (int i = 0; i < n2; i++)
        rightArr[i] = array[middle+i+1];

    // starting index
    int l = 0, r = 0, k = left;  // k: for the original array

    // merge
    while (l < n1 && r < n2) {
        checkPause(); // Check for pause

        bars bar = bars[k];
        bar.clear(g);
        if (leftArr[l] < rightArr[r]) {
            array[k] = leftArr[l];
            bar.setValue(leftArr[l]);
            l++;
        } else {
            array[k] = rightArr[r];
            bar.setValue(rightArr[r]);
            r++;
        }

        bar.setColor(mergeColor);
        colorBar(k, swappingColor);
        k++;
        comp++;
        swapping++;
    }

    // add the remaining in the two arrays if there are any
    while (l < n1) {
        checkPause(); // Check for pause

        bars bar = bars[k];
        bar.clear(g);

        array[k] = leftArr[l];
        bar.setValue(leftArr[l]);
        bar.setColor(mergeColor);
        colorBar(k, swappingColor);
        l++;
        k++;
        swapping++;
    }

    while (r < n2) {
        checkPause(); // Check for pause

        bars bar = bars[k];
        bar.clear(g);

        array[k] = rightArr[r];
        bar.setValue(rightArr[r]);
        bar.setColor(mergeColor);
        colorBar(k, swappingColor);
        r++;
        k++;
        swapping++;
    }
}

    //New sort
    // BUBBLE SORT
public void bubbleSort() {
    if (!isCreated())
        return;

    initializeBufferStrategy(); // Đảm bảo BufferStrategy được thiết lập

    sortWorker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            g = bs.getDrawGraphics();

            // calculate elapsed time
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(array.clone());
            comp = swapping = 0;
            time = System.nanoTime() - startTime;

            int n = array.length;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    checkPause(); // Check for pause

                    if (array[j] > array[j+1]) {
                        swap(j, j+1);
                        swapping++;
                        publish(); // Request UI update
                    }
                    comp++;
                }
            }
            g.dispose();
            return null;
        }

        @Override
        protected void process(List<Void> chunks) {
            // Update the UI here
            repaintArray(); // Assuming you have a method to repaint the array on the screen
        }

        @Override
        protected void done() {
            // Ensure the finish animation runs on the EDT
            SwingUtilities.invokeLater(() -> {
                System.out.print("Da vao done");
                finishAnimation();
                listener.onArraySorted(time, comp, swapping);
            });
        }
    };

    sortWorker.execute();
}

private void repaintArray() {
    if (bs == null) {
        initializeBufferStrategy(); // Đảm bảo BufferStrategy được thiết lập
    }

    do {
        do {
            g = bs.getDrawGraphics();
            g.setColor(colorConcept.CANVAS_BACKGROUND);
            g.fillRect(0, 0, 1920, 1090); // Xóa màn hình

            for (bars bar : bars) {
                bar.draw(g);
            }
        } while (bs.contentsRestored());
        bs.show();
    } while (bs.contentsLost());

    g.dispose();
}

public void initializeBufferStrategy() {
    if (bs == null) {
        myCanvas canvas = listener.getCanvas(); // Giả sử bạn có phương thức này trong listener để lấy myCanvas
        canvas.createBufferStrategy(4); // Sử dụng triple buffering
        bs = canvas.getBufferStrategy();
    }
}






    // QUICK SORT
    public void quickSort() {
        if (!isCreated())
            return;
    
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        QuickSort.quickSort(array.clone());
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
    
        quickSort(array, 0, array.length - 1);
    
        finishAnimation();
        g.dispose();
    }
    
    private void quickSort(Integer arr[], int low, int high) {
        if (low < high) {
            checkPause(); // Check for pause
            int pi = partition(arr, low, high);
    
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int partition(Integer arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            checkPause(); // Check for pause
    
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
                swapping++;
            }
            comp++;
        }
    
        swap(i + 1, high);
        swapping++;
    
        return i + 1;
    }
    
    // SELECTION SORT
    public void selectionSort() {
        if (!isCreated())
            return;
    
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        SelectionSort.selectionSort(array.clone());
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
    
        int n = array.length;
    
        for (int i = 0; i < n-1; i++) {
            checkPause(); // Check for pause
    
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                checkPause(); // Check for pause
    
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
                comp++;
            }
    
            swap(min_idx, i);
            swapping++;
        }
    
        finishAnimation();
        g.dispose();
    }
    
    // SHELL SORT
    public void shellSort() {
        if (!isCreated())
            return;
    
        g = bs.getDrawGraphics();
    
        // calculate elapsed time
        startTime = System.nanoTime();
        ShellSort.shellSort(array.clone());
        time = System.nanoTime() - startTime;
    
        comp = swapping = 0;
    
        int n = array.length;
    
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                checkPause(); // Check for pause
    
                int temp = array[i];
    
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    checkPause(); // Check for pause
    
                    swap(j, j-gap);
                    swapping++;
                    comp++;
                }
    
                array[j] = temp;
                swapping++;
            }
        }
    
        finishAnimation();
        g.dispose();
    }
    





    /*Animation*/
    public Color getBarColor(int value){
        int n = (int) (array.length / 7.0);
        if(value < n)
            return colorConcept.BAR_RED;
        else if(value < n * 2)
            return colorConcept.BAR_ORANGE;
        else if(value < n * 3)
            return colorConcept.BAR_YELLOW;
        else if(value < n * 4)
            return colorConcept.BAR_GREEN;
        else if(value < n * 5)
            return colorConcept.BAR_BLUE;
        else if(value < n * 6)
            return colorConcept.BAR_INDIGO;
        return colorConcept.BAR_PURPLE;
    }
    private void swap(int i, int j)
    {
        // swap the elements
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

        // clear the bar
        bars[i].clear(g);
        bars[j].clear(g);
        
        // swap the drawings
        bars[j].setValue(bars[i].getValue());
        // try {
        //     TimeUnit.MILLISECONDS.sleep(speed);
        // } catch (Exception ex) {
        //     System.out.println("Exception ex!");
        // }
        bars[i].setValue(temp);

        colorPair(i, j, swappingColor);
    }
    private void colorPair(int i, int j, Color color)
    {
        Color color1 = bars[i].getColor(), color2 = bars[j].getColor();
        // drawing
        bars[i].setColor(color);
        bars[i].draw(g);

        bars[j].setColor(color);
        bars[j].draw(g);

        bs.show();
      
        // delay
        try {
            TimeUnit.MILLISECONDS.sleep(speed);
        } catch (Exception ex) {
            System.out.println("Exception ex!");
        }
        checkPause();
        // put back to original color
        bars[i].setColor(color1);
        bars[i].draw(g);

        bars[j].setColor(color2);
        bars[j].draw(g);

        bs.show();
    }
    private void finishAnimation()
    {
        // swiping to green
        for (int i = 0; i < bars.length; i++)
        {
            colorBar(i, comparingColor);
            bars[i].setColor(getBarColor(i));
            bars[i].draw(g);
            bs.show();
        }

        // show elapsed time and comparisons
        listener.onArraySorted(time, comp, swapping);
    }
 
    
    
    public void drawArray()
    {
        if (!hasArray)
            return;

        g = bs.getDrawGraphics();

        for (int i = 0; i < bars.length; i++)
        {
            bars[i].draw(g);
        }

        bs.show();
        g.dispose();
    }
    private boolean isCreated()
    {
        if (!hasArray)
            JOptionPane.showMessageDialog(null, "You need to create an array!", "No Array Created Error", JOptionPane.ERROR_MESSAGE);
        return hasArray;
    }
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    public void setFPS(int fps)
    {
        this.speed = (int) (10000.0/fps);
    }
    public int getFPS()
    {
        return this.speed;
    }
    public interface SortedListener {
        void onArraySorted(long elapsedTime, int comparison, int swapping);
        BufferStrategy getBufferStrategy();
        myCanvas getCanvas();
    }
}
