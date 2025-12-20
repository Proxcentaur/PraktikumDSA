package com.septiadinirahayu.personal_assignment.lab1;

public class MainArray {
    public static void main(String[] args) {
        runWithOutput();
        System.out.println("\n\n------------------- Benchmark Results -------------------\n");
        benchMark();
    }

    /**
     * method untuk menjalankan operasi array dan arraylist dengan output hasil operasi.
     */
    private static void runWithOutput() {
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations arrayListOps = new ArrayListOperations();

        int elementToModify = 10; // elemen yang akan dihapus dan ditambahkan kembali
        int searchTarget = 40; // elemen yang akan dicari

        // Initialize
        arrayOps.initArray();
        arrayOps.setPrintingEnabled(true); // untuk mengaktifkan output print
        arrayListOps.initArrayList();
        arrayListOps.setPrintingEnabled(true); //untuk mengaktifkan output print

        // --- Array Benchmarks ---
        System.out.println("--- Array Benchmarks ---");
        arrayOps.calculateExecutionTime(arrayOps::traversal, "Array Traversal");
        arrayOps.calculateExecutionTime(() -> arrayOps.linearSearch(searchTarget), "Array Linear Search");
        arrayOps.calculateExecutionTime(() -> arrayOps.binarySearch(searchTarget), "Array Binary Search");
        arrayOps.calculateExecutionTime(() -> arrayOps.deletion(elementToModify), "Array Deletion");
        arrayOps.calculateExecutionTime(() -> arrayOps.insertion(elementToModify), "Array Insertion");

        // --- ArrayList Benchmarks ---
        System.out.println("\n--- ArrayList Benchmarks ---");
        arrayListOps.calculateExecutionTime(arrayListOps::traversal, "ArrayList Traversal");
        arrayListOps.calculateExecutionTime(() -> arrayListOps.linearSearch(searchTarget), "ArrayList Linear Search");
        arrayListOps.calculateExecutionTime(() -> arrayListOps.binarySearch(searchTarget), "ArrayList Binary Search");
        arrayListOps.calculateExecutionTime(() -> arrayListOps.deletion(elementToModify), "ArrayList Deletion");
        arrayListOps.calculateExecutionTime(() -> arrayListOps.insertion(elementToModify), "ArrayList Insertion");
    }


    /**
     * Method untuk melakukan benchmark pada operasi array dan arraylist.
     */
    private static void benchMark() {
        ArrayOperations arrayBenchmark = new ArrayOperations();
        ArrayListOperations arrayListBenchmark = new ArrayListOperations();

        int searchTarget = 40;
        int elementToModify = 10;

        // Initialize
        arrayBenchmark.initArray();
        arrayBenchmark.setPrintingEnabled(false); // untuk menonaktifkan ouput print supaya menghindari noise pada hasil benchmark
        arrayListBenchmark.initArrayList();
        arrayListBenchmark.setPrintingEnabled(false); //untuk menonaktifkan ouput print supaya menghindari noise pada hasil benchmark

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
