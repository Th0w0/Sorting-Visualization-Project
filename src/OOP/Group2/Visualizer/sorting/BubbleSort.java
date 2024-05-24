package OOP.Group2.Visualizer.sorting;
public class BubbleSort extends Sort {

    /* BUBBLE SORT */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    // Swap data[j] and data[j + 1]
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
