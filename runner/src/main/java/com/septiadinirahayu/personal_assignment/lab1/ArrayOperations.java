package com.septiadinirahayu.personal_assignment.lab1;

import java.util.Arrays;

public class ArrayOperations extends Operations {
    int [] numbers;

    /**
     * Initializes the array with numbers from 1 to 99.
     */
    public void initArray() {
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
        }
    }

    @Override
    public void traversal() {
        System.out.print("Array Traversal: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]); // Mengakses elemen array
            if (i < numbers.length - 1) {
                System.out.print(", "); // Menambahkan koma kecuali untuk elemen terakhir
            }
        }
        System.out.print("]"); // Menutup tanda kurung siku
        System.out.println(" "); // Pindah ke baris baru setelah print out selesai
    }

    @Override
    public void linearSearch(int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("[LINEAR SEARCH | Array] Pencarian " + target + " dalam Array: ditemukan di indeks " + i);
                return;
            }
        }
    }

    @Override
    public void binarySearch(int target) {
        int low = 0; // indeks awal
        int high = numbers.length - 1; // indeks akhir

        while (low <= high) {
            int mid = (low + high) / 2; // indeks tengah
            if (numbers[mid] == target) {
                // elemen ditemukan
                System.out.println("[BINARY SEARCH | Array] Pencarian " + target + " dalam Array: ditemukan di indeks " + mid);
                return;
            } else if (numbers[mid] < target) {
                // cari di bagian kanan
                low = mid + 1;
            } else {
                // cari di bagian kiri
                high = mid - 1;
            }
        }
        System.out.println("[BINARY SEARCH | Array] Pencarian " + target + " dalam Array: tidak ditemukan");
    }

    @Override
    public void insertion(int newElement) {
        int [] newNumbers = new int[numbers.length + 1]; // membuat array baru dengan ukuran lebih besar
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length); // menyalin elemen lama ke array baru
        newNumbers[newNumbers.length - 1] = newElement; // menyisipkan elemen baru di akhir

        Arrays.sort(newNumbers); // mengurutkan array setelah penyisipan elemen baru
        this.numbers = newNumbers; // memperbarui referensi array lama ke array baru

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

    @Override
    public void deletion(int target) {
        int indexToRemove = -1;
        for (int i = 0; i < numbers.length ; i++) {
            if (target == numbers[i]) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array.");
        } else {
            int[] newNumbers = new int[numbers.length - 1]; // membuat array baru dengan ukuran lebih kecil

            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != indexToRemove) {
                    newNumbers[j++] = numbers[i]; // menyalin elemen kecuali elemen yang dihapus
                }
            }
            this.numbers = newNumbers; // memperbarui referensi array lama ke array baru

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
