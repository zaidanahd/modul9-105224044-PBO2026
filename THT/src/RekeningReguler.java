public class RekeningReguler extends Rekening {
    private static final double BIAYA_ADMIN = 5000; // Membuat variabel konstanta private untuk menyimpan besaran biaya administrasi bank sebesar 5.000 ribu

    // Constructor untuk membuat objek Rekening Reguler
    public RekeningReguler(String nomorRekening, String namaPemilik, double saldo, String pin) {
        super(nomorRekening, namaPemilik, saldo, pin);
    }

    @Override
    public void tarik(double jumlah) {
        double totalTagihan = jumlah + BIAYA_ADMIN; // Menghitung total tagihan nyata, yaitu nominal penarikan ditambah beban biaya admin 5.000 ribu
        if (getSaldo() >= totalTagihan) {  // Memeriksa apakah saldo akun saat ini mencukupi untuk membayar total tagihan
            setSaldo(getSaldo() - totalTagihan);
            getMutasi().catatLog("Penarikan Reguler (Termasuk Admin)", jumlah);
        } else { 
            // Blok jika saldo ternyata tidak cukup untuk menutupi uang penarikan + admin
            // Mencetak pesan gagal beserta rincian total saldo minimal yang harusnya tersedia
            System.out.println("Saldo tidak mencukupi (Butuh Rp " + totalTagihan + " termasuk admin).");
        }
    }
}
