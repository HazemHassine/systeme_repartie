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
            	InputStream inputStream = this.s.getInputStream();
				OutputStream outputStream = this.s.getOutputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				PrintWriter writer = new PrintWriter(outputStream, true);
				System.out.printf("\nJ'attend un nom du client %d\n", this.numClient);
				String nom = reader.readLine();
				System.out.printf("J'attend un genre du client %d", this.numClient);
				String gender = reader.readLine();
				System.out.printf("J'envoi la reponse à %d\n", this.numClient);
				String reponse;
				String genderThing ="";
				if (gender.equals("homme")){
					genderThing = "MR";
				}
				else if (gender.equals("femme")) {
					genderThing ="MME";
				}
				
				reponse = "Bonjour client"+ this.numClient+" ," +genderThing + " " +nom;
				writer.println(reponse);
				this.s.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}