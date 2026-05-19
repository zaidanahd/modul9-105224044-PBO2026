import java.util.ArrayList;

public class RumahSakit {
    private String nama;
    private final Ruangan[] daftarRuangan;
    private ArrayList<Dokter> daftarDokter = new ArrayList<>();

    public RumahSakit(String nama) {
        this.nama = nama;
        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = new Ruangan("A", 10);
        this.daftarRuangan[1] = new Ruangan("B", 20);
    }

    public String getName() {
        return nama;
    }

    public void addDokter(Dokter dokter) {
        this.daftarDokter.add(dokter);
    }

    public void daftarDokter() {
        for (Dokter dokter : daftarDokter) {
            System.out.println("Nama Dokter: " + dokter.getNama() + " Spesialisasi: " + dokter.getspesialis());
        }
    }

    public void tampilkanRuangan() {
        for (Ruangan ruangan : daftarRuangan) {
            System.out.println("No. Registrasi: " + ruangan.getnoRegis() + " Kapasitas Maksimal: " + ruangan.getkapasitasMaks());
        }
    }
}