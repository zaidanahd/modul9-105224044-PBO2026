import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService csPusat = new CustomerService("Budi");
        
        // Objek di luar nasabah biar terbukti tetap ada saat nasabah di null
        Rekening[] bankDataPusat = new Rekening[5]; 
        int totalRekeningGlobal = 0;

        Nasabah nasabahAktif = null;

        System.out.println("=== SELAMAT DATANG DI NEOBANK ===");
        boolean berjalan = true;

        while (berjalan) { // Melakukan perulangan menu selama variabel 'berjalan' bernilai true
            System.out.println("\nMENU UTAMA:");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru (Dimasukkan ke Profil)");
            System.out.println("3. Lihat Profil & Saldo");
            System.out.println("4. Simulasi Transaksi (Setor / Tarik)");
            System.out.println("5. Hubungi Customer Service");
            System.out.println("6. Keluar & Simulasi Penghancuran Akun (Set Null)");
            System.out.print("Pilih opsi: ");
           
            int pilihan = scanner.nextInt(); // Membersihkan sisa karakter enter (\n) di memori setelah menginput angka
            
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: // Blok menu 1 Registrasi nasabah baru
                    System.out.print("Masukkan ID Nasabah: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = scanner.nextLine();
                    nasabahAktif = new Nasabah(id, nama);
                    System.out.println("Profil Nasabah Berhasil Dibuat!");
                    break;

                case 2: // Blok menu 2 Buka rekening baru
                    if (nasabahAktif == null) { // Validasi kalau nasabahAktif masih null
                        System.out.println("Silakan registrasi nasabah terlebih dahulu!");
                        break;
                    }
                    System.out.print("Masukkan No Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Setoran Awal: ");
                    double saldoAwal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Buat PIN (6 Digit): ");
                    String pin = scanner.nextLine();
                    
                    System.out.println("Pilih Jenis Rekening: \n1. Reguler \n2. Prioritas");
                    int jenis = scanner.nextInt();
                    
                    Rekening rekBaru;
                    if (jenis == 1) {
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else {
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    nasabahAktif.tambahRekening(rekBaru);
                    bankDataPusat[totalRekeningGlobal++] = rekBaru; // Simpan di backup pusat
                    break;

                case 3: // Blok menu 3 lihat Profil Nasabah
                    if (nasabahAktif == null) { // Memeriksa jika belum ada nasabah terdaftar di sistem
                        System.out.println("Belum ada nasabah terdaftar.");
                    } else {
                        nasabahAktif.tampilkanProfil();
                    }
                    break;

                case 4: // Blok menu 4 simulasi Transaksi Keuangan
                    if (nasabahAktif == null) { // Validasi kalau nasabahAktif masih null
                        System.out.println("Belum ada nasabah terdaftar.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Anda: ");
                    String cariNo = scanner.nextLine();
                    Rekening rekTarget = null;
                    
                    // Melakukan perulangan untuk mencari kecocokan nomor rekening di dalam profil nasabah
                    for (Rekening r : nasabahAktif.getDaftarRekening()) {
                        if (r != null && r.getNomorRekening().equals(cariNo)) {
                            rekTarget = r;
                            break;
                        }
                    }

                    // Jika setelah dicari variabel rekTarget masih bernilai null
                    if (rekTarget == null) {
                        System.out.println("Rekening tidak ditemukan di profil Anda!");
                        break;
                    }

                    System.out.print("Masukkan PIN: ");
                    String inputPin = scanner.nextLine();
                    if (!rekTarget.verifikasiPIN(inputPin)) {
                        System.out.println("PIN Salah! Transaksi ditolak.");
                        break;
                    }

                    // Menampilkan pilihan jenis aksi transaksi keuangan
                    System.out.println("1. Setor Tunai \n2. Tarik Tunai");
                    int aksi = scanner.nextInt();
                    System.out.print("Masukkan Jumlah Uang: ");
                    double nominal = scanner.nextDouble();

                    if (aksi == 1) {
                        rekTarget.setor(nominal);
                    } else if (aksi == 2) {
                        rekTarget.tarik(nominal);
                    }
                    break;

                case 5: // Blok menu 5 Hubungi Customer Service
                    if (nasabahAktif == null) {
                        System.out.println("Belum ada nasabah terdaftar.");
                        break;
                    }
                    System.out.print("Masukkan Keluhan Anda: ");
                    String keluhan = scanner.nextLine();
                    nasabahAktif.hubungiCS(csPusat, keluhan);
                    break;

                case 6: // Blok menu 6 buat Penghancuran Akun & Keluar program
                    berjalan = false;
                    System.out.println("\nExiting program...");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("SIMULASI PENUTUPAN AKUN PAKSA & ANALISIS SIKLUS HIDUP");
        
        if (nasabahAktif != null) {
            System.out.println("Menghapus objek nasabahAktif dari memori sistem (set null)...");
            nasabahAktif = null; // Penutupan akun secara paksa
            
            // 1. BUKTI LOGIKA AGREGASI (Loose-Coupling):
            // Walaupun objek 'nasabahAktif' telah dihancurkan dari memori (di-set null),
            // objek 'Rekening' yang pernah dibuat di dalam kelas tersebut terbukti TIDAK ikut musnah.
            // Karena objek Rekening juga dipegang oleh 'bankDataPusat' (Dibuat di luar objek Nasabah).
            System.out.println("\n[BUKTI AGREGASI]: Memeriksa data rekening di Bank Data Pusat...");
            if (bankDataPusat[0] != null) {
                System.out.println("-> Rekening " + bankDataPusat[0].getNomorRekening() + " milik " 
                        + bankDataPusat[0].getNamaPemilik() + " terbukti MASIH EKSIS di data pusat bank!");
            }

             // 2. BUKTI LOGIKA KOMPOSISI (Strong-Coupling):
            // Apabila objek 'Rekening' itu sendiri kita putus atau hapus permanen dari sistem pusat,
            // maka objek 'BukuMutasi' internal yang dibuat di dalam constructor Rekening otomatis ikut hancur.
            // Objek 'BukuMutasi' tidak bisa hidup sendirian jika objek wadahnya ('Rekening') sudah tidak ada.
            System.out.println("\n[BUKTI KOMPOSISI]: Menghapus Rekening secara permanen dari sistem pusat...");
            bankDataPusat[0] = null; 
            System.out.println("-> Rekening dihapus. Objek BukuMutasi internal otomatis ikut lenyap dari memori.");
            System.out.println("=======================================================");
        } else {
            System.out.println("Simulasi dilewati karena tidak ada data nasabah yang diregistrasi.");
        }
        
        scanner.close();
    }
}
