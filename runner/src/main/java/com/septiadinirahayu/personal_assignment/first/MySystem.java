package com.septiadinirahayu.personal_assignment.first;


public class MySystem {
    private Barang[] inventaris = new Barang[10];

    public static void main(String[] args) {
        MySystem runner = new MySystem();

        runner.initInventaris();
        runner.tampilkanBarang();

        runner.cariBarang("Kalkulator");
        runner.updateStok("Spidol", 20);

        String[] itemList = {"Pensil", "Buku", "Penggaris"};
        int[] stokBaru = {15, 25, 10};
        runner.updateStokBeberapaBarang(itemList, stokBaru);
    }

    /**
     * Inisialisasi inventaris toko dengan daftar barang awal
     */
    private void initInventaris() {
        inventaris[0] = new Barang("Pensil", 2000, 10);
        inventaris[1] = new Barang("Buku", 5000, 20);
        inventaris[2] = new Barang("Penghapus", 1500, 15);
        inventaris[3] = new Barang("Spidol", 4000, 8);
        inventaris[4] = new Barang("Penggaris", 3000, 5);
        inventaris[5] = new Barang("Kalkulator", 125000, 12);
    }

    /**
     * Menampilkan daftar barang yang tersedia di inventaris toko
     */
    private void tampilkanBarang() {
        boolean hasBarang = false;
        System.out.println("Inventaris Toko:");

        for (Barang barang : inventaris) {
            if (barang == null) continue;

            hasBarang = true;
            System.out.println("Nama: " + barang.getNama() + ", Harga: " + barang.getHarga() + ", Jumlah Stok: " + barang.getJumlahStok());
        }

        if (!hasBarang) {
            System.out.println("Maaf, tidak ada inventaris yang tersedia.");
        }
    }

    /**
     * Mencari barang berdasarkan nama yang diinput
     *
     * @param nama
     */
    private void cariBarang(String nama) {
        for (Barang barang : inventaris) {
            if (barang != null && barang.getNama().equals(nama)) {
                System.out.println("Barang ditemukan: Nama: " + barang.getNama() + ", Harga: " + barang.getHarga() + ", Jumlah Stok: " + barang.getJumlahStok());
                return;
            }
        }
        System.out.println("Item " + nama + " tidak ditemukan.");
    }

    /**
     * Memperbarui stok beberapa barang sekaligus berdasarkan array nama barang dan jumlah baru
     *
     * @param namaBarang
     * @param jumlahBaru
     */
    private void updateStokBeberapaBarang(String[] namaBarang, int[] jumlahBaru) {
        if (namaBarang.length != jumlahBaru.length) {
            System.out.println("System error");
            return;
        }

        for (int i = 0; i < namaBarang.length; i++) {
            String nama = namaBarang[i];
            int jumlah = jumlahBaru[i];
            int nomer = i + 1;

            boolean isFound = false;
            for (Barang barang : inventaris) {
                if (barang != null && barang.getNama().equals(nama)) {
                    barang.jumlahStok = jumlah;
                    System.out.println(nomer + ". Nama " + nama + " , Jumlah Stok: " + jumlah + ", Harga: " + barang.getHarga());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Item " + nama + " tidak ditemukan.");
            }
        }
    }

    /**
     * Memperbarui stok barang berdasarkan nama barang yang diinputkan
     *
     * @param nama
     * @param jumlahBaru
     */
    private void updateStok(String nama, int jumlahBaru) {
        System.out.println("Masukkan nama barang yang ingin diupdate: " + nama);
        System.out.println("Masukkan jumlah stok baru: " + jumlahBaru);
        System.out.println("Inventaris setelah diupdate: ");

        for (Barang barang : inventaris) {
            if (barang != null && barang.getNama().equals(nama)) {
                barang.jumlahStok = jumlahBaru;
                System.out.println("Nama " + nama + " , Jumlah Stok: " + jumlahBaru + ", Harga: " + barang.getHarga());
                return;
            }
        }
        System.out.println("Item " + nama + " tidak ditemukan.");
    }
}
