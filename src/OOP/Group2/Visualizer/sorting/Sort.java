package OOP.Group2.Visualizer.sorting;

public abstract class Sort {
    // swap element and target in the array
    protected static <T extends Comparable<T>> void swap(T[] data, int element1, int element2)
    {
        T temp = data[element2];
        data[element2] = data[element1];
        data[element1] = temp;
    }
}

