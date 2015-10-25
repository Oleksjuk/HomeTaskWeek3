package com.geekhub.hw3.comparable;

import java.lang.Comparable;
import java.util.Arrays;

public class ArraySorter {

    public static void main(String[] args) {
        Comparable[] sortedIntegers = sort(new Integer[]{2343, 2, 6, 1, 0, -1});
        Comparable[] sortedStrings = sort(new String[]{ "abc", "54", "op" });

        System.out.println("Sorted integers: " + Arrays.toString(sortedIntegers));
        System.out.println("Sorted strings: " + Arrays.toString(sortedStrings));
    }

    /**
     * Sorts array of the comparable elements
     * @return sorted array
     */
    public static Comparable[] sort(Comparable[] elements) {
        Comparable[] sortedElements = new Comparable[elements.length];
        System.arraycopy(elements,0,sortedElements,0,elements.length);

        Comparable tmpElement;
        for (int i = 0; i < sortedElements.length; i++)
            for (int j = 0; j < sortedElements.length - i - 1; j++) {
                if (sortedElements[j].compareTo(sortedElements[j+1]) > 0){
                    tmpElement = sortedElements[j];
                    sortedElements[j] = sortedElements[j+1];
                    sortedElements[j+1] = tmpElement;
                }
            }

        return sortedElements;
    }
}
