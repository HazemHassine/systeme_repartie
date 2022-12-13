import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {};
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry();

            Hello stub = (Hello)reg.lookup("fnRemote");
            String msg = stub.ShowMsg();

            System.out.println(msg);
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}