public class RekeningPrioritas extends Rekening {
    private static final double MIN_PENARIKAN = 500000; // Membuat variabel konstanta private untuk membatasi batas minimal penarikan yaitu 500.000 ribu

    // Constructor untuk membuat objek Rekening Prioritas
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldo, String pin) {
        super(nomorRekening, namaPemilik, saldo, pin); // Memanggil constructor milik kelas induk (Rekening) pakai 'super'
    }

    @Override
    public void tarik(double jumlah) {
        if (jumlah < MIN_PENARIKAN) { // Memeriksa apakah jumlah penarikan ternyata lebih kecil dari batas minimal (500 ribu)
            System.out.println("Gagal! Penarikan akun Prioritas minimal Rp " + MIN_PENARIKAN); // Mencetak laporan gagal karena tidak memenuhi syarat
            return;
        }
        
        // Memeriksa apakah saldo akun saat ini mencukupi untuk didebit sebesar jumlah penarikan
        if (getSaldo() >= jumlah) {
            setSaldo(getSaldo() - jumlah); // Mengurangi saldo saat ini dengan nominal penarikan dan menyimpannya kembali lewat setSaldo
            getMutasi().catatLog("Penarikan Prioritas (Bebas Admin)", jumlah);
        } else {
            System.out.println("Saldo Prioritas tidak mencukupi.");
        }
    }
}
