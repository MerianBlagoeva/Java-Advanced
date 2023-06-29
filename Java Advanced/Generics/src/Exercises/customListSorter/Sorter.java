package Exercises.customListSorter;

import java.util.Collections;

public class Sorter {
    //Bubble Sort
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        int n = customList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (customList.get(j).compareTo(customList.get(j + 1)) > 0) {
                    customList.swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
