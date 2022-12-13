import java.rmi.Remote;
import java.rmi.RemoteException;
// on peut aussi ecrire
// import java.rmi.*;

public interface Hello extends Remote {
    String ShowMsg() throws RemoteException;
}