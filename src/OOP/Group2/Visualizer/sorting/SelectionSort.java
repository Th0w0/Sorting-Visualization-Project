package OOP.Group2.Visualizer.sorting;

public class SelectionSort extends Sort {

    /* SELECTION SORT */
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            T temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }
}
