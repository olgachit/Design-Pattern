package strategy.Assignement;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] smallData = generateRandomArray(30);
        int[] largeData = generateRandomArray(100000);

        Sorter sorter = new Sorter(new BubbleSort());

        testSort("Bubble Sort", sorter, smallData);
        testSort("Bubble Sort", sorter, largeData);

        sorter.setStrategy(new QuickSort());
        testSort("Quick Sort", sorter, smallData);
        testSort("Quick Sort", sorter, largeData);

        sorter.setStrategy(new MergeSort());
        testSort("Merge Sort", sorter, smallData);
        testSort("Merge Sort", sorter, largeData);
    }

    public static int[] generateRandomArray(int size) {

        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);
        }

        return array;
    }

    public static void testSort(String name, Sorter sorter, int[] data) {

        int[] copy = data.clone();

        long start = System.nanoTime();

        sorter.sort(copy);

        long end = System.nanoTime();

        System.out.println(name + " | Size: " + data.length +
                " | Time: " + (end - start) + " ns");
    }
}