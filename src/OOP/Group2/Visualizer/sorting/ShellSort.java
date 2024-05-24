package OOP.Group2.Visualizer.sorting;
public class ShellSort extends Sort {

    /* SHELL SORT */
    public static <T extends Comparable<T>> void shellSort(T[] data) {
        int n = data.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save data[i] in temp and make a hole at position i
                T temp = data[i];

                // Shift earlier gap-sorted elements up until the correct location for data[i] is found
                int j;
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap) {
                    data[j] = data[j - gap];
                }

                // Put temp (the original data[i]) in its correct location
                data[j] = temp;
            }
        }
    }
}
