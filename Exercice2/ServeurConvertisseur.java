import java.rmi.RemoteException;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 

public class ServeurConvertisseur extends ConvertisseurImpl {
    public void ServeurConvertisseur() throws RemoteException {};

    public static void main(String[] args) {
        try {
           ConvertisseurImpl obj = new ConvertisseurImpl();
           ConvertisseurInterface stub = (ConvertisseurInterface) UnicastRemoteObject.exportObject(obj, 0);
           Registry reg = LocateRegistry.getRegistry();
           reg.bind("away", stub);
       } catch (Exception e) {
           System.err.println(e.toString());
           e.printStackTrace();
       }
   }
}

