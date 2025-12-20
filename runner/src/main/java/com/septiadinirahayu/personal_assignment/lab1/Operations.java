package com.septiadinirahayu.personal_assignment.lab1;

abstract class
Operations {
    public int size = 1000;
    /**
     * Menelusuri elemen-elemen dalam array.
     */
    public abstract void traversal();

    /**
     * Mencari elemen dalam array secara linear.
     * @param target ---> elemen yang ingin dicari
     */
    public abstract void linearSearch(int target);

    /**
     * Mencari elemen dalam array secara biner.
     * @param target ---> elemen yang ingin dicari
     */
    public abstract void binarySearch(int target);

    /**
     * Menyisipkan elemen baru ke dalam array.
     * @param newElement ---> elemen baru yang ingin disisipkan
     */
    public abstract void insertion(int newElement);

    /**
     * Menghapus elemen dari array.
     */
    public abstract void deletion(int target);

    public void calculateExecutionTime(Runnable function, String functionName) {
        long startTime = System.nanoTime(); //waktu mulai
        function.run(); //menjalankan fungsi yang diberikan
        long endTime = System.nanoTime(); //waktu selesai
        long durationInNanos = endTime - startTime; //menghitung durasi dalam nanodetik
        double durationInMs = durationInNanos / 1_000_000.0; //mengonversi durasi ke milliseconds
        System.out.println("Waktu eksekusi " + functionName +  ": " + durationInMs + " ms");
    }
}
