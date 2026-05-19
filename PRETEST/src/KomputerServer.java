public class KomputerServer {
    public Harddisk harddisk;
    public Monitor monitor;

    public KomputerServer(Harddisk harddisk){
        this.harddisk = harddisk;
    }

    public void addMonitor(Monitor monitor){
        this.monitor = monitor;
    }
}

// composition saling bergantung (komputer dan harddisk dan monitor), kalau aggregation tidak bergantung