import java.net.*;
import java.io.*;
public class ServeurMT extends Thread {
    public int numClient = 0;
    @Override 
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(123);
            while (true) {
                System.out.println("attends une connexion");
                Socket s = ss.accept();
                new Service(s, numClient).start();
                numClient++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    new ServeurMT().start();
}
}