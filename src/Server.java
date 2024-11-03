import java.util.concurrent.TimeUnit;

public class Server {
    private String IP;
    private int load;
    private int maxLoad;

    public Server(String ip, int maxLoad) {
        this.IP = ip;
        this.maxLoad = maxLoad;
    }

    public void process(String request) {
        load++;
        // handle(request);
    }

    private void freeUp() {
        load--;
    }

    private void handle(String request) {
        try {
            TimeUnit.SECONDS.sleep(5);
            freeUp();
        } catch (InterruptedException e) {
            freeUp();
        }
    }

    public int getCurrentLoad() {
        return load;
    }

    public boolean free() {
        return load < maxLoad;
    }

    public void updateMaxLoad(int newLoad) {
        maxLoad = newLoad;
    }

    public String toString() {
        return "IP address: " + IP + ", Current Load: " + load;
    }
}
