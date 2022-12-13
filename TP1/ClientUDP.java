import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class ClientUDP {
    public static void main(String[] args) {
        int RecieverPort = 5123, SenderPort = 2341;
        String host = "";
        String msg1;
        Scanner clavier = new Scanner(System.in);
        try {
            System.out.println("Adress du serveur:");
            host = clavier.next();
            InetAddress adress;
            adress = InetAddress.getByName(host);
            System.out.println("sending to : " + adress + " to " +host);
            DatagramPacket packet;
            DatagramSocket socket;


            byte[] data = (new String("Hello World!")).getBytes();
            packet = new DatagramPacket(data, data.length, adress, SenderPort);
            socket = new DatagramSocket();
            socket.send(packet);
            
            DatagramSocket socketRecu = new DatagramSocket(RecieverPort);
            byte[] reponse = new byte[15];
            DatagramPacket paquetRecu= new DatagramPacket(reponse, reponse.length);
            socketRecu.receive(paquetRecu);
            msg1 = new String(paquetRecu.getData(), 0, paquetRecu.getLength());
            System.out.println(" recu de serveur: "+ msg1);
        }
        catch (Exception e) {
            System.out.println("Erreur:");
            e.printStackTrace();
        }
    }

}
