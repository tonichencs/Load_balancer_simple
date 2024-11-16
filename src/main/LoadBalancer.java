package main;

import java.util.Comparator;
import java.util.PriorityQueue;

class LoadBalancer {
    PriorityQueue<Server> servers;

    public LoadBalancer() {
        this.servers = new PriorityQueue<Server>(new Comparator<Server>() {
            public int compare(Server a, Server b) {
                return a.getCurrentLoad() - b.getCurrentLoad();
            }
        });
    }

    public void regiesterServer(String ip, int maxLoad) {
        servers.offer(new Server(ip, maxLoad));
    }

    public String forwardRequest(String request) {
        Server freeServer = servers.poll();

        if (freeServer.free()) {
            freeServer.process(request);
            servers.offer(freeServer);
            return "Request forwarded to " + freeServer;
        } else return "All servers occupied";
    }
}