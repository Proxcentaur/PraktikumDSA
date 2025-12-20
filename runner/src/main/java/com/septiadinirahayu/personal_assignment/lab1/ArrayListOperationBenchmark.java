package com.septiadinirahayu.personal_assignment.lab1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperationBenchmark extends Operations {
    ArrayList<Integer> numbers;

    public void initArrayList() {
        numbers = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
    }

    @Override
    public void traversal() {
        for (int i = 0; i < numbers.size(); i++) {
            int temp = numbers.get(i); // Simulate access
        }
    }

    @Override
    public void linearSearch(int target) {
        // The contains method performs a linear search.
        numbers.contains(target);
    }

    @Override
    public void binarySearch(int target) {
        Collections.binarySearch(numbers, target);
    }

    @Override
    public void insertion(int newElement) {
        // To benchmark fairly, we create a copy first.
        ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.add(newElement);
        Collections.sort(newNumbers);
    }

    @Override
    public void deletion(int target) {
        // To benchmark fairly, we create a copy first.
        ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.remove(Integer.valueOf(target));
    }
}
