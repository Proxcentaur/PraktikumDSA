package com.septiadinirahayu.personal_assignment.lab2;

public class Node {
    //deklarasi data yang disimpan pada node
    StudentData data;
    //referensi ke node selanjutnya
    Node next;

    //constructor untuk membuat node baru dengan data mahasiswa
    public Node(StudentData data) {
        //mengatur data mahasiswa pada node
        this.data = data;
        //mengatur referensi node selanjutnya ke null karena node baru belum terhubung ke node lain
        this.next = null;
    }

    /**
     * implementasi merge sort untuk linked list berdasarkan NIM
     * @param headNode
     * @return
     */
    public Node mergeSort(Node headNode) {
        //kalau ada list kosong atau hanya ada satu elemen, return headNode
        if (headNode == null || headNode.next == null) {
            //mengembalikan headNode karena sudah terurut
            return headNode;
        }

        //cari node tengah untuk membagi list menjadi dua bagian
        Node middle = getMiddle(headNode);
        //ambil node setelah tengah sebagai awal list kedua
        Node nextOfMiddle = middle.next;
        //putuskan list menjadi dua bagian
        middle.next = null;

        //urutkan bagian kiri list secara rekursif
        Node leftHalf = mergeSort(headNode);
        //urutkan bagian kanan list secara rekursif
        Node rightHalf = mergeSort(nextOfMiddle);

        //menggabungkan dua bagian yang sudah diurutkan
        return sortedMerge(leftHalf, rightHalf);
    }

    /**
     * method untuk mendapatkan node tengah dari linked list
     */
    private Node getMiddle(Node headNode) {
        //jika list kosong, return null
        if (headNode == null) {
            return headNode;
        }

        Node slowPointer = headNode; //deklarasi slowPointer untuk melacak node tengah
        Node fastPointer = headNode.next; //deklarasi fastPointer untuk melacak akhir list

        //gerakkan fastPointer dua langkah dan slowPointer satu langkah
        while (fastPointer != null) {
            fastPointer = fastPointer.next; //gerakkan fastPointer dua langkah
            if (fastPointer != null) {
                slowPointer = slowPointer.next; //gerakkan slowPointer satu langkah
                fastPointer = fastPointer.next; //gerakkan fastPointer satu langkah lagi
            }
        }

        return slowPointer; //mengembalikan node tengah
    }

    private Node sortedMerge(Node firstList, Node secondList) {
        if (firstList == null) return secondList;
        if (secondList == null) return firstList;

        //deklarasi node untuk head dari linked list yang sudah digabung dan diurutkan
        Node mergedHead;

        // membandingkan NIM pada kedua list untuk menentukan urutan
        if (firstList.data.getStudentId().compareTo(secondList.data.getStudentId()) <= 0) {
            //jika NIM pada firstList lebih kecil atau sama, maka firstList menjadi head dari merged list
            mergedHead = firstList;
            //menggabungkan sisa dari firstList dengan secondList
            mergedHead.next = sortedMerge(firstList.next, secondList);
        } else {
            //jika NIM pada secondList lebih kecil, maka secondList menjadi head dari merged list
            mergedHead = secondList;
            //menggabungkan firstList dengan sisa dari secondList
            mergedHead.next = sortedMerge(firstList, secondList.next);
        }

        //mengembalikan head dari linked list yang sudah digabung dan diurutkan
        return mergedHead;
    }
}
