package com.septiadinirahayu.personal_assignment.lab2;

import java.util.Scanner;

/**
 * implementasi single linked list untuk menyimpan data mahasiswa
 * class ini memiliki method untuk menambahkan data, menghapus semua data,
 */
public class StudentLinkedList {
    //node inner class untuk merepresentasikan node pada linked list
    private Node head;
    //counter untuk melacak ukuran linked list
    private int size;

    //constructor untuk inisialisasi linked list kosong
    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //method untuk mendapatkan ukuran linked list
    public int getSize() {
        return size;
    }

    /**
     * Implementasi push untuk menambahkan data mahasiswa ke linked list
     * @param scanner
     */
    public void insertDataFromInput(Scanner scanner) {
        System.out.println("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();

        //validasi panjang nama tidak lebih dari 30 karakter
        if (name.length() > 30) {
            System.out.println("Nama tidak boleh lebih dari 30 karakter. Silakan masukkan ulang.");
            name = scanner.nextLine();
        }

        System.out.println("Masukkan NIM mahasiswa: ");
        String studentId = scanner.nextLine();

        //validasi panjang NIM tidak lebih dari 10 karakter
        if (studentId.length() > 10) {
            System.out.println("NIM tidak boleh lebih dari 10 karakter. Silakan masukkan ulang.");
            studentId = scanner.nextLine();
        }

        System.out.println("Masukkan jurusan mahasiswa: ");
        String major = scanner.nextLine();

        //validasi panjang jurusan tidak lebih dari 50 karakter
        if (major.length() > 50) {
            System.out.println("Jurusan tidak boleh lebih dari 50 karakter. Silakan masukkan ulang.");
            major = scanner.nextLine();
        }

        // ===== VISUALISASI MEMORI =====
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   PROSES INSERT KE LINKED LIST        ║");
        System.out.println("╚════════════════════════════════════════╝");

        // Tampilkan kondisi SEBELUM insert
        System.out.println("\n[SEBELUM INSERT]");
        displayMemoryVisualization();

        //membuat node baru dan menambahkannya ke linked list
        StudentData data = new StudentData(name, studentId, major);
        System.out.println("\n[LANGKAH 1] Buat StudentData");
        System.out.println("┌─────────────────────┐");
        System.out.println("│ Nama    : " + name);
        System.out.println("│ NIM     : " + studentId);
        System.out.println("│ Jurusan : " + major);
        System.out.println("└─────────────────────┘");

        //menambahkan node baru di awal linked list
        Node newNode = new Node(data);
        System.out.println("\n[LANGKAH 2] Buat Node Baru");
        System.out.println("┌──────────────────────┐");
        System.out.println("│ Data : " + name + ", " + studentId);
        System.out.println("│ Next : null          │");
        System.out.println("└──────────────────────┘");

        // menghubungkan node baru ke head saat ini
        newNode.next = head;
        System.out.println("\n[LANGKAH 3] Hubungkan Node Baru ke Head Lama");
        if (head != null) {
            System.out.println("Node baru sekarang menunjuk ke: " + head.data.getName());
        } else {
            System.out.println("Node baru menunjuk ke: null (list masih kosong)");
        }

        // memperbarui head untuk menunjuk ke node baru
        head = newNode;
        System.out.println("\n[LANGKAH 4] Update Head");
        System.out.println("Head sekarang menunjuk ke: " + head.data.getName());

        //counter ukuran linked list
        size++;

        // Tampilkan kondisi SETELAH insert
        System.out.println("\n[SETELAH INSERT]");
        displayMemoryVisualization();
        System.out.println("Total data: " + size);
        System.out.println("═══════════════════════════════════════\n");

        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    /**
     * Method helper untuk menampilkan visualisasi memori linked list secara sederhana
     */
    private void displayMemoryVisualization() {
        if (head == null) {
            System.out.println("head → [KOSONG]");
            return;
        }

        System.out.print("head → ");
        Node current = head;

        while (current != null) {
            System.out.print("[" + current.data.getName() + ", " + current.data.getStudentId() + "]");

            if (current.next != null) {
                System.out.print(" → ");
            } else {
                System.out.print(" → null");
            }

            current = current.next;
        }
        System.out.println();
    }

    /**
     * implementasi pop all untuk menghapus semua data mahasiswa dari linked list
     */
    public void popAll() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        head = null;
        size = 0;
        System.out.println("Semua data mahasiswa telah dihapus.");
    }

    /**
     * mengurutkan data mahasiswa berdasarkan NIM dan menampilkannya
     */
    public void sortAndDisplay() {
        if (head == null) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }

        //sort linked list menggunakan merge sort
        head = head.mergeSort(head);

        //menampilkan data yang sudah di-sort
        Node current = head;
        int index = 1;

        while (current != null) {
            System.out.println("Data Mahasiswa ke-" + index + ":");
            System.out.println("Nama: " + current.data.getName());
            System.out.println("NIM: " + current.data.getStudentId());
            System.out.println("Jurusan: " + current.data.getMajor());
            System.out.println("-------------------------");
            current = current.next;
            index++;
        }
    }
}
