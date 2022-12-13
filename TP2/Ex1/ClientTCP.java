import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.net.InetAddress;
class ClientTCP {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 1234);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Scanner clavier = new Scanner(System.in);
            System.out.println("Donne un nombre");
            int nb;
            nb = clavier.nextInt();
            outputStream.write(nb);
            int res = inputStream.read();
            System.out.println("Res= "+ res);
            outputStream.write(res);
            socket.close(); //closing the connection
        } catch (Exception e) {
            // Raised in case, connection is refused or some other technical issue
            e.printStackTrace();
        }
    }
}