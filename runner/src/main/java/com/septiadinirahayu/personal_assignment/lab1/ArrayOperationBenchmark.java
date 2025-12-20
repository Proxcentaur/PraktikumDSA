package com.septiadinirahayu.personal_assignment.lab1;

import java.util.Arrays;

public class ArrayOperationBenchmark extends Operations {
    int[] numbers;

    public void initArray() {
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
    }

    @Override
    public void traversal() {
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i]; // Simulate access
        }
    }

    @Override
    public void linearSearch(int target) {
        for (int number : numbers) {
            if (number == target) {
                return; // Element found
            }
        }
    }

    @Override
    public void binarySearch(int target) {
        // Use the optimized built-in binary search for a fair comparison
        Arrays.binarySearch(numbers, target);
    }

    @Override
    public void insertion(int newElement) {
        int[] newNumbers = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        newNumbers[newNumbers.length - 1] = newElement;
        Arrays.sort(newNumbers);
        // The array is modified, but not reassigned to the instance variable
        // to avoid affecting subsequent runs within a more complex scenario.
    }

    @Override
    public void deletion(int target) {
        int indexToRemove = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (target == numbers[i]) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            int[] newNumbers = new int[numbers.length - 1];
            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != indexToRemove) {
                    newNumbers[j++] = numbers[i];
                }
            }
        }
    }
}