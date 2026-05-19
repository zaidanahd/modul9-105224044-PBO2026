public class Ruangan {
    private String noRegis;
    private int kapasitasMaks;

    public Ruangan(String noRegis, int kapasitasMaks){
        this.noRegis = noRegis;
        this.kapasitasMaks = kapasitasMaks;
    }

    public int getkapasitasMaks(){
        return kapasitasMaks;
    }

    public String getnoRegis(){
        return noRegis;
    }
}
