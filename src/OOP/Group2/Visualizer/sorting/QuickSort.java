package OOP.Group2.Visualizer.sorting;
public class QuickSort extends Sort {

    /* QUICK SORT */
    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data, int low, int high) {
        T pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j].compareTo(pivot) < 0) {
                i++;

                // Swap data[i] and data[j]
                T temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // Swap data[i + 1] and data[high] (or pivot)
        T temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
    }
}
