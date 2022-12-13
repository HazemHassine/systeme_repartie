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
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Scanner clavier = new Scanner(System.in);
            System.out.println("Donner votre nom:");
            String nom;
            nom = clavier.nextLine();
            writer.println(nom);
            System.out.println("Donner votre genre:");
            String gender;
            gender = clavier.nextLine();
            writer.println(gender);
            String res = reader.readLine();
            System.out.println("Response= "+ res);
            socket.close(); //closing the connection
        } catch (Exception e) {
            // Raised in case, connection is refused or some other technical issue
            e.printStackTrace();
        }
    }
}