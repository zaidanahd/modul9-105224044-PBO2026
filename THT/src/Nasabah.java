public class Nasabah { // Mendefinisikan kelas public bernama Nasabah
    private String idNasabah;
    private String nama;
    private Rekening[] daftarRekening; // Agregasi
    private int jumlahRekening;

    public Nasabah(String idNasabah, String nama) { // Constructor untuk membuat objek Nasabah baru berdasarkan ID dan Nama
        this.idNasabah = idNasabah;
        this.nama = nama;
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;
    }

    public String getNama() { 
        return nama; 
    } // Metode getter untuk mengambil atau membaca nama nasabah dari luar kelas
    public Rekening[] getDaftarRekening() { 
        return daftarRekening; 
    }

    public void tambahRekening(Rekening rekening) { // Metode untuk menambahkan objek Rekening baru ke dalam array milik nasabah
        if (jumlahRekening < 3) {
            daftarRekening[jumlahRekening] = rekening;
            jumlahRekening++;
            System.out.println("Rekening " + rekening.getNomorRekening() + " berhasil ditambahkan ke profil.");
        } else {
            System.out.println("Gagal! Maksimal hanya boleh memiliki 3 rekening.");
        }
    }

    public void tampilkanProfil() { // Metode untuk menampilkan seluruh data profil nasabah dan semua rekeningnya
        System.out.println(" PROFIL NASABAH ");
        System.out.println("ID: " + idNasabah + " | Nama: " + nama);
        System.out.println("Daftar Rekening:");
        for (int i = 0; i < jumlahRekening; i++) {
            String jenis = (daftarRekening[i] instanceof RekeningReguler) ? "Reguler" : "Prioritas";
            System.out.println("- [" + jenis + "] No: " + daftarRekening[i].getNomorRekening() + " | Saldo: Rp " + daftarRekening[i].getSaldo());
        }
    }

    // Asosiasi Umum dengan CustomerService
    public void hubungiCS(CustomerService cs, String keluhan) { // Metode Asosiasi Umum untuk menghubungkan tindakan Nasabah ke objek CustomerService
        cs.layaniKeluhan(this.nama, keluhan);
    }
}
