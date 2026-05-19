public class Dokter {
    private String nama;
    private String spesialis;
    private Pasien pasien;

public Dokter(String nama, String spesialis){
    this.nama = nama;
    this.spesialis = spesialis;
}

public void setPasien(Pasien pasien){
    this.pasien = pasien;
}

public Pasien getPasien(){
    return this.pasien;
}

public String getNama(){
    return this.nama;
}

public String getspesialis(){
    return this.spesialis;
}

public void periksaPasien(Pasien pasien){
    System.out.println("Dokter " + this.nama + "spesialis " + this.spesialis + "sedang periksa pasien " + pasien.getnama() + " umur" + pasien.getUmur());
}

}
