public abstract class Rekening implements Otorisasi { // Mendefinisikan kelas abstract bernama Rekening yang mengimplementasikan aturan dari interface Otorisasi
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;
    private String pin;
    protected BukuMutasi mutasi; 

    // Constructor untuk membentuk objek Rekening dasar
    public Rekening(String nomorRekening, String namaPemilik, double saldo, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.pin = pin;
        this.mutasi = new BukuMutasi(); 
        this.mutasi.catatLog("Pembukaan Rekening Baru", saldo);
    }

    // Metode getter untuk mengambil atau membaca data nomor rekening
    public String getNomorRekening(){ 
        return nomorRekening; 
    }
    public String getNamaPemilik(){ 
        return namaPemilik; 
    }
    public double getSaldo(){ 
        return saldo; 
    }
    protected void setSaldo(double saldo){ 
        this.saldo = saldo; 
    }
    public BukuMutasi getMutasi(){ 
        return mutasi; 
    }

    // Mengimplementasikan metode dari interface Otorisasi untuk mencocokkan PIN
    public boolean verifikasiPIN(String pin){
        return this.pin.equals(pin);
    }

    // Metode umum agar dapat melakukan aktivitas setoran/menabung
    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            mutasi.catatLog("Setoran Masuk", jumlah);
        } else {
            System.out.println("Jumlah setoran tidak valid!");
        }
    }

    // Membuat metode abstract untuk tarik tunai
    public abstract void tarik(double jumlah);
}

