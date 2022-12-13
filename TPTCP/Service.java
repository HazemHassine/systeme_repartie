import java.net.*;
import java.io.*;
public class Service extends Thread {
    private Socket s;
    private int numClient;
    public Service(Socket socket, int numClient) {
    super();
    this.s = socket;
    this.numClient = numClient;
}
    public void run() {
        try {
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("Voues etes client numero" + numClient);
            System.out.println("Connexion du client Num" + numClient);
            System.out.println("IP = "+ s.getRemoteSocketAddress());
            while (true) {
                String req = br.readLine();
                pw.println(req.length());
            	}
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }