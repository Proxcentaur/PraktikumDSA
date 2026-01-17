package com.septiadinirahayu.personal_assignment.lab2;

import java.util.Scanner;

public class MainStudentManagementSystem {
    private StudentLinkedList studentList;
    private static final Integer MAX_DATA = 5;

    private MainStudentManagementSystem() {
        studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in); // scanner untuk input user
        boolean running = true;

        System.out.println("Selamat datang di program pengelolaan data mahasiswa menggunakan Single Linked List.");

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Push data mahasiswa");
            System.out.println("2. Menampilkan semua daftar mahasiswa");
            System.out.println("3. Pop semua data mahasiswa");
            System.out.println("4. Keluar dari program");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Masukkan jumlah data mahasiswa yang akan ditambahkan: ");
                    int dataCount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 0; i < dataCount; i++) {
                        if (studentList.getSize() >= MAX_DATA) {
                            System.out.println("Data sudah mencapai maksimum (" + MAX_DATA + " data). Tidak dapat menambah data lagi.");
                            break;
                        } else {
                            System.out.println("Menambahkan data mahasiswa ke-" + (i + 1) + ":");
                            studentList.insertDataFromInput(scanner);
                        }
                    }
                    break;
                case 2:
                    studentList.sortAndDisplay();
                    break;
                case 3:
                    studentList.popAll();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new MainStudentManagementSystem();
    }
}
