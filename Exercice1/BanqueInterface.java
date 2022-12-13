import java.rmi.Remote;
import java.rmi.RemoteException;
public interface BanqueInterface extends Remote{
	float AfficherSolde() throws RemoteException; 
	void verser(float mt) throws RemoteException; 
	void retirer(float mt) throws RemoteException; 
}