package com.septiadinirahayu.personal_assignment.lab1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations extends Operations {
    ArrayList<Integer> numbers = new ArrayList<>(size);
    /**
     * Inisialisasi ArrayList dengan beberapa elemen sesuai size
     */
    public void initArrayList() {
        numbers.clear();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
    }

    @Override
    public void traversal() {
        if (printingEnabled) System.out.print("ArrayList Traversal: ");

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i); // menggunakan get() untuk mengakses elemen arraylist
            if (printingEnabled) {
                System.out.print(number);
                if (i < numbers.size() - 1) {
                    System.out.print(", "); // menambahkan koma kecuali untuk elemen terakhir
                }
            }
        }

        if (printingEnabled) {
            System.out.print("]"); // menutup tanda kurung siku
            System.out.println(""); // pindah ke baris baru setelah print out selesai
        }
    }

    @Override
    public void linearSearch(int target) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == target) {
                if (printingEnabled) {
                    System.out.println("[LINEAR SEARCH] Pencarian " + target + " dalam ArrayList: ditemukan di indeks " + i);
                }
                return;
            }
        }
    }

    @Override
    public void binarySearch(int target) {
        int low = 0; // indeks awal
        int high = numbers.size() - 1; // indeks akhir
        int mid = -1; // init indeks tengah
        boolean isFound = false;

        while (low <= high) {
            mid = low + (high - low) / 2; // menghitung indeks tengah
            if (numbers.get(mid) == target) {
                isFound = true; // elemen ditemukan
                break;
            } else if (numbers.get(mid) < target) {
                low = mid + 1; // cari di bagian kanan
            } else {
                high = mid - 1; // cari di bagian kiri
            }
        }

        if (printingEnabled) {
            if (isFound) {
                System.out.println("[BINARY SEARCH] Pencarian " + target + " dalam ArrayList: ditemukan di indeks " + mid);
            } else {
                System.out.println("[BINARY SEARCH] Pencarian " + target + " dalam ArrayList: tidak ditemukan");
            }
        }
    }

    @Override
    public void insertion(int newElement) {
        numbers.add(newElement); // menambah element baru ke arraylist
        Collections.sort(numbers); // mengurutkan arraylist setelah penambahan elemen

        if (printingEnabled) {
            System.out.print("Array setelah penyisipan elemen " + newElement + ": [");

            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i)); // mengakses elemen array
                if (i < numbers.size() - 1) {
                    System.out.print(", "); // menambahkan koma kecuali untuk elemen terakhir
                }
            }
            System.out.print("]"); // menutup tanda kurung siku
            System.out.println(" "); // pindah ke baris baru setelah print out selesai
        }
    }

    @Override
    public void deletion(int target) {
        boolean isRemoved = numbers.remove(Integer.valueOf(target)); // isRemoved akan true jika elemen ditemukan dan dihapus

        if (printingEnabled) {
            if (isRemoved) {
                System.out.println("ArrayList setelah penghapusan elemen " + target + ": " + numbers);
            } else {
                System.out.println("Elemen " + target + " tidak ditemukan dalam ArrayList.");
            }
        }
    }
}