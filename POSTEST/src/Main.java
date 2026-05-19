public class Main {
    public static void main(String[] args) {
        Ban[] setBanBaru = new Ban[4];
        setBanBaru[0] = new Ban("tubles", 15);
        setBanBaru[1] = new Ban("tubles", 15);
        setBanBaru[2] = new Ban("tubles", 15);
        setBanBaru[3] = new Ban("tubles", 15);

        Mobil mobilPrototipe = new Mobil("Mustang", "Abu-abu", "Speed v8", 6000);

        mobilPrototipe.pasangSetBan(setBanBaru);

        mobilPrototipe.tampilkanSpesifikasi();

        Montir montirSenior = new Montir("Montir 001", "Zaidan");
        montirSenior.lakukanQualityControl(mobilPrototipe);

        mobilPrototipe = null;

    }
}