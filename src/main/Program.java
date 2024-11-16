package main;

public class Program {
    private LoadBalancer lb;


    public Program() {
        lb = new LoadBalancer();
    }

    public static void main(String[] args) {
        Program p = new Program();

        p.lb.regiesterServer("1.1.1.1", 10);
        p.lb.regiesterServer("2.2.2.2", 10);
        p.lb.regiesterServer("3.3.3.3", 10);

        for (int i = 0; i < 5; i++) {
            System.out.println(p.lb.forwardRequest("" + i));
        }
    }
}
