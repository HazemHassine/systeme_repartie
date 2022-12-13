import java.net.*;
import java.io.*;
public class ServeurTCP extends Thread {
	private int numClient = -1;
	@Override
	public void run()  {
		try{
			ServerSocket serverSocket = new ServerSocket(1234);
			while (true) {
				System.out.println("J'attend une connection");
				Socket socket = serverSocket.accept();
				numClient = numClient + 1;
				new Service(socket, numClient).start();
			}
		} catch (Exception e ){
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		new ServeurTCP().start();
	}
}
			