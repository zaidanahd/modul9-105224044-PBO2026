public class CustomerService {
    private String namaCs;// Membuat variabel private bertipe String buat nyimpan nama petugas CS

    public CustomerService(String namaCs) { // Constructor untuk menginisialisasi atau memberikan nama pada objek CS saat dibuat
        this.namaCs = namaCs;
    }

    public void layaniKeluhan(String namaNasabah, String keluhan) { // Membuat metode untuk mensimulasikan pelayanan keluhan dari nasabah
        System.out.println("[CS " + namaCs + "] Menerima keluhan dari " + namaNasabah + ": '" + keluhan + "'");
        System.out.println("[CS " + namaCs + "] Keluhan Anda sedang diproses. Terima kasih!");
    }
}
