package com.septiadinirahayu.personal_assignment.lab1;

import java.util.Arrays;

public class ArrayOperations extends Operations {
    int [] numbers;

    /**
     * inisialisasi array dengan nilai dari 1 hingga size
     */
    public void initArray() {
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
    }

    @Override
    public void traversal() {
        if (printingEnabled) System.out.print("Array Traversal: [");
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i]; // Mengakses elemen array
            if (printingEnabled) {
                System.out.print(number);
                if (i < numbers.length - 1) {
                    System.out.print(", "); // Menambahkan koma kecuali untuk elemen terakhir
                }
            }
        }
        if (printingEnabled) {
            System.out.print("]"); // Menutup tanda kurung siku
            System.out.println(" "); // Pindah ke baris baru setelah print out selesai
        }
    }

    @Override
    public void linearSearch(int target) {
        for (int i = 0; i < numbers.length; i++) {
            // membandingkan elemen array dengan target
            if (numbers[i] == target) {
                // elemen ditemukan
                if (printingEnabled) {
                    System.out.println("[LINEAR SEARCH] Pencarian " + target + " dalam Array: ditemukan di indeks " + i);
                }
                return;
            }
        }
    }

    @Override
    public void binarySearch(int target) {
        int low = 0; // indeks awal
        int high = numbers.length - 1; // indeks akhir
        int mid = -1; // inisialisasi indeks tengah
        boolean isFound = false;

        while (low <= high) {
            mid = low + (high - low) / 2; // menghitung indeks tengah
            if (numbers[mid] == target) {
                isFound = true; // elemen ditemukan
                break;
            } else if (numbers[mid] < target) {
                low = mid + 1; // cari di bagian kanan
            } else {
                high = mid - 1; // cari di bagian kiri
            }
        }

        if (printingEnabled) {
            if (isFound) {
                System.out.println("[BINARY SEARCH] Pencarian " + target + " dalam Array: ditemukan di indeks " + mid);
            } else {
                System.out.println("[BINARY SEARCH] Pencarian " + target + " dalam Array: tidak ditemukan");
            }
        }
    }

    @Override
    public void insertion(int newElement) {
        int [] newNumbers = new int[numbers.length + 1]; // membuat array baru dengan ukuran lebih besar
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length); // menyalin elemen lama ke array baru
        newNumbers[newNumbers.length - 1] = newElement; // menyisipkan elemen baru di akhir

        Arrays.sort(newNumbers); // mengurutkan array setelah penyisipan elemen baru
        this.numbers = newNumbers; // memperbarui referensi array lama ke array baru

        if (printingEnabled) {
            System.out.print("Array setelah penyisipan elemen " + newElement + ": [");

            for (int i = 0; i < newNumbers.length; i++) {
                System.out.print(newNumbers[i]); // mengakses elemen array
                if (i < newNumbers.length - 1) {
                    System.out.print(", "); // menambahkan koma kecuali untuk elemen terakhir
                }
            }
            System.out.print("]"); // menutup tanda kurung siku
            System.out.println(" "); // pindah ke baris baru setelah print out selesai
        }
    }

    @Override
    public void deletion(int target) {
        int indexToRemove = -1;
        // mencari indeks elemen yang akan dihapus
        for (int i = 0; i < numbers.length ; i++) {
            if (target == numbers[i]) {
                indexToRemove = i; // menemukan indeks elemen yang akan dihapus
                break;
            }
        }

        if (indexToRemove == -1) {
            if (printingEnabled) System.out.println("Elemen " + target + " tidak ditemukan dalam array.");
        } else {
            int[] newNumbers = new int[numbers.length - 1]; // membuat array baru dengan ukuran lebih kecil

            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != indexToRemove) {
                    newNumbers[j++] = numbers[i]; // menyalin elemen kecuali elemen yang dihapus
                }
            }
            this.numbers = newNumbers; // memperbarui referensi array lama ke array baru

            if (printingEnabled) {
                System.out.print("Array setelah penghapusan elemen " + target + ": [");

                for (int i = 0; i < newNumbers.length; i++) {
                    System.out.print(newNumbers[i]); // mengakses elemen array
                    if (i < newNumbers.length - 1) {
                        System.out.print(", "); // menambahkan koma kecuali untuk elemen terakhir
                    }
                }

                System.out.print("]"); // menutup tanda kurung siku
                System.out.println(" "); // pindah ke baris baru setelah print out selesai
            }
        }
    }
}