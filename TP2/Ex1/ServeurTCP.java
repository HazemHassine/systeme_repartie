import java.net.*;
import java.io.*;

public class ServeurTCP {
	public static void main(String[] args) {
		try{
			ServerSocket socketServeur = new ServerSocket(1234);
			System.out.println("J'attend une connexion");
			Socket socket = socketServeur.accept();
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			System.out.println("J'attend une nombre");
			int nb = inputStream.read();
			int res = nb * 3;
			System.out.println("J'envoi la reponse");
			outputStream.write(res);
			socket.close();
			socketServeur.close();
		} 
		catch (Exception e ) { 
			e.printStackTrace();
		}
	}
}