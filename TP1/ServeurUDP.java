import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class ServeurUDP {
    public static void main(String[] args) {
        int SenderPort = 2341, RecieverPort = 5123;
        String msg1;
            try {
                System.out.println("Serveur en attent:");
                DatagramPacket packetRecu;
                DatagramSocket socket = new DatagramSocket(SenderPort);

                byte[] data = new byte[1024];

                packetRecu = new DatagramPacket(data, data.length);

                socket.receive(packetRecu);

                msg1 = new String(packetRecu.getData(), 0 , packetRecu.getLength());
                System.out.println(" le message recu est: "+ msg1);
                System.out.println(" ca viene d l'adresse: " + packetRecu.getAddress()+ " et du port"+packetRecu.getPort());
            
                InetAddress adresse = null;
                DatagramSocket socketRecu = new DatagramSocket();
                byte[] response  = (new String("bien recu")).getBytes();
                DatagramPacket dgp = new DatagramPacket(response,response.length, adresse, RecieverPort);
                socketRecu.send(dgp);
            } 
            catch (Exception e )
            {
                System.err.println("Erreur" + e);
                e.printStackTrace();
            }

    }

}