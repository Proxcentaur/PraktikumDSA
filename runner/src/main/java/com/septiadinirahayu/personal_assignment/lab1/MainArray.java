package com.septiadinirahayu.personal_assignment.lab1;

public class MainArray {
    public static void main(String[] args) {
//        ArrayOperations arrayOperations = new ArrayOperations();
//        ArrayListOperations arrayListOperations = new ArrayListOperations();
//
//        int searchTarget = 40; // element yang akan dicari
//        int elementToModify = 10; // element yang akan dihapus dan ditambahkan
//
//        // inisialisasi Array
//        arrayOperations.initArray();
//        // inisialisasi ArrayList
//        arrayListOperations.initArrayList();
//
//        // Traversal
//        arrayOperations.calculateExecutionTime(arrayOperations::traversal, "Array Traversal");
//        System.out.println("-----------------------------------");
//        arrayListOperations.calculateExecutionTime(arrayListOperations::traversal, "ArrayList Traversal");
//        System.out.println("-----------------------------------");
//
//        // Linear Search
//        arrayOperations.calculateExecutionTime(() -> arrayOperations.linearSearch(searchTarget), "Array Linear Search");
//        System.out.println("-----------------------------------");
//        arrayListOperations.calculateExecutionTime(() -> arrayListOperations.linearSearch(searchTarget), "ArrayList Linear Search");
//        System.out.println("-----------------------------------");
//
//        // Binary Search
//        arrayOperations.calculateExecutionTime(() -> arrayOperations.binarySearch(searchTarget), "Array Binary Search");
//        System.out.println("-----------------------------------");
//        arrayListOperations.calculateExecutionTime(() -> arrayListOperations.binarySearch(searchTarget), "ArrayList Binary Search");
//        System.out.println("-----------------------------------");
//
//        // Deletion
//        arrayOperations.calculateExecutionTime(() -> arrayOperations.deletion(elementToModify), "Array Deletion");
//        System.out.println("-----------------------------------");
//        arrayListOperations.calculateExecutionTime(() -> arrayListOperations.deletion(elementToModify), "ArrayList Deletion");
//        System.out.println("-----------------------------------");
//
//        // Insertion
//        arrayOperations.calculateExecutionTime(() -> arrayOperations.insertion(elementToModify), "Array Insertion");
//        System.out.println("-----------------------------------");
//        arrayListOperations.calculateExecutionTime(() -> arrayListOperations.insertion(elementToModify), "ArrayList Insertion");
//        System.out.println("-----------------------------------");

        benchMark();
    }

    /**
     * Method untuk melakukan benchmark pada operasi array dan arraylist.
     */
    private static void benchMark() {
        ArrayOperationBenchmark arrayBenchmark = new ArrayOperationBenchmark();
        ArrayListOperationBenchmark arrayListBenchmark = new ArrayListOperationBenchmark();

        int searchTarget = 40;
        int elementToModify = 10;

        arrayBenchmark.initArray();
        arrayListBenchmark.initArrayList();

        // --- Array Benchmarks ---
        System.out.println("--- Array Benchmarks ---");
        arrayBenchmark.calculateExecutionTime(arrayBenchmark::traversal, "Array Traversal");
        arrayBenchmark.calculateExecutionTime(() -> arrayBenchmark.linearSearch(searchTarget), "Array Linear Search");
        arrayBenchmark.calculateExecutionTime(() -> arrayBenchmark.binarySearch(searchTarget), "Array Binary Search");
        arrayBenchmark.calculateExecutionTime(() -> arrayBenchmark.deletion(elementToModify), "Array Deletion");
        arrayBenchmark.calculateExecutionTime(() -> arrayBenchmark.insertion(elementToModify), "Array Insertion");

        // --- ArrayList Benchmarks ---
        System.out.println("\n--- ArrayList Benchmarks ---");
        arrayListBenchmark.calculateExecutionTime(arrayListBenchmark::traversal, "ArrayList Traversal");
        arrayListBenchmark.calculateExecutionTime(() -> arrayListBenchmark.linearSearch(searchTarget), "ArrayList Linear Search");
        arrayListBenchmark.calculateExecutionTime(() -> arrayListBenchmark.binarySearch(searchTarget), "ArrayList Binary Search");
        arrayListBenchmark.calculateExecutionTime(() -> arrayListBenchmark.deletion(elementToModify), "ArrayList Deletion");
        arrayListBenchmark.calculateExecutionTime(() -> arrayListBenchmark.insertion(elementToModify), "ArrayList Insertion");
    }
}
