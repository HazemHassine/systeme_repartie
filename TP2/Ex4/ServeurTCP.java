import java.net.*;
import java.io.*;

public class ServeurTCP {
	public static void main(String[] args) {

		try{
			ServerSocket socketServeur = new ServerSocket(1234);
			while (true) {
				System.out.println("J'attend une connexion");
				Socket socket = socketServeur.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				PrintWriter writer = new PrintWriter(outputStream, true);
				System.out.println("J'attend un nom");
				String nom = reader.readLine();
				System.out.println("J'attend un genre");
				String gender = reader.readLine();
				System.out.println("J'envoi la reponse");
				String reponse;
				String genderThing ="";
				if (gender.equals("homme")){
					genderThing = "MR";
				}
				else if (gender.equals("femme")) {
					genderThing ="MME";
				}
				else {
					writer.println("Gender not understood");
					socket.close();
					socketServeur.close();
					return;
				}
				reponse = "Bonjour " +genderThing + " " +nom;
				writer.println(reponse);
			}	
		} 
		catch (Exception e ) { 
			e.printStackTrace();
		}
	}
}