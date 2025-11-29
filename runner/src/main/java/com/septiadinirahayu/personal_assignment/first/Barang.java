package com.septiadinirahayu.personal_assignment.first;

public class Barang {
    String nama;
    double harga;
    int jumlahStok;

    public Barang(String namaBarang, double hargaBarang, int jumlahBarang) {
        this.nama = namaBarang;
        this.harga = hargaBarang;
        this.jumlahStok = jumlahBarang;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }
}
