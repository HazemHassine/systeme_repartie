import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramPacket;
import java.util.Scanner;


public class rev {
    public static void main(String[] args) {
        int senderPort = 1234;
        int recieverPort = 4321;
        Scanner clavier = new Scanner(System.in);
        String host = clavier.next();
        try {
            InetAddress address = new InetAddress.getByName(host);
            DatagramPacket packetToSend;
            DatagramSocket SendingSocket;
            String msg1 = "Sending This msg";
            packetToSend = new DatagramPacket(msg1.getBytes(),  msg1.length,address, senderPort);
            SendingSocket = new
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
    }

}