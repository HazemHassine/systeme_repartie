import java.rmi.RemoteException;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject; 

public class Serveur extends HelloImpl {
    public Serveur() throws RemoteException {}
    public static void main(String args[]) {
        try  {
            HelloImpl obj = new HelloImpl();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 500);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("fnRemote", stub);
            System.out.println("Le serveur est pret.... Ouvrir la session du client pour invoker la methode ShowMsg()");
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}