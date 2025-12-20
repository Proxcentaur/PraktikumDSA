package com.septiadinirahayu.personal_assignment.lab1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations extends Operations {
    ArrayList<Integer> numbers = new ArrayList<>(size);
    /**
     * Inisialisasi ArrayList dengan beberapa elemen.
     */
    public void initArrayList() {
        numbers.clear();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
    }

    @Override
    public void traversal() {
        System.out.print("ArrayList Traversal: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i)); // Menggunakan get() untuk mengakses elemen arraylist
            if (i < numbers.size() - 1) {
                System.out.print(", "); // Menambahkan koma kecuali untuk elemen terakhir
            }
        }
        System.out.print("]"); // Menutup tanda kurung siku
        System.out.println(""); // Pindah ke baris baru setelah print out selesai
    }

    @Override
    public void linearSearch(int target) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == target) {
                System.out.println("[LINEAR SEARCH | ArrayList] Pencarian " + target + " dalam ArrayList: ditemukan di indeks " + i);
                return;
            }
        }
    }

    @Override
    public void binarySearch(int target) {
        int low = 0; // indeks awal
        int high = numbers.size() - 1; // indeks akhir

        while (low <= high) {
            int mid = (low + high) / 2; // indeks tengah
            if (numbers.get(mid) == target) {
                // elemen ditemukan
                System.out.println("[BINARY SEARCH | ArrayList] Pencarian " + target + " dalam ArrayList: ditemukan di indeks " + mid);
                return;
            } else if (numbers.get(mid) < target) {
                // cari di bagian kanan
                low = mid + 1;
            } else {
                // cari di bagian kiri
                high = mid - 1;
            }
        }
        System.out.println("[BINARY SEARCH | ArrayList] Pencarian " + target + " dalam ArrayList: tidak ditemukan");

    }

    @Override
    public void insertion(int newElement) {
        numbers.add(newElement); // menambah element baru ke arraylist
        Collections.sort(numbers); // mengurutkan arraylist setelah penambahan elemen

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

    @Override
    public void deletion(int target) {
        boolean isRemoved = numbers.remove(Integer.valueOf(target)); // isRemoved akan true jika elemen ditemukan dan dihapus

        if (isRemoved) {
            System.out.println("ArrayList setelah penghapusan elemen " + target + ": " + numbers);
        } else {
            System.out.println("Elemen " + target + " tidak ditemukan dalam ArrayList.");
        }
    }

}
