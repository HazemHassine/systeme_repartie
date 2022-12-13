import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
public interface ConvertisseurInterface extends Remote {
    Date AfficherDate() throws RemoteException;
    float euroToDinar(float mt) throws RemoteException;
    float dinarToEuro(float mt) throws RemoteException;
    float dollarToDinar(float mt) throws RemoteException;
    float dinarToDollar(float mt) throws RemoteException;
}


