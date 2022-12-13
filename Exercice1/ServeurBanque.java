import java.rmi.RemoteException;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 
import java.util.Scanner;
public class ServeurBanque extends BanqueImpl {
    public ServeurBanque() throws RemoteException {};
    public static void main(String[] args) {
    	 try {
    	    BanqueImpl obj = new BanqueImpl();
            BanqueInterface stub = (BanqueInterface) UnicastRemoteObject.exportObject(obj, 500);
            Registry reg = LocateRegistry.getRegistry();
			reg.bind("remote", stub);
		} catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}