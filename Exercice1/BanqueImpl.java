
import java.rmi.RemoteException;
public class BanqueImpl implements BanqueInterface {
	private float solde;
	public BanqueImpl() throws RemoteException{
		this.solde = 0;
	}
	public float AfficherSolde() throws RemoteException{
		return this.solde;
	}
	public void verser(float mt) throws RemoteException{
		this.solde += mt;
	} 
	public void retirer(float mt) throws RemoteException{
		this.solde -= mt;
	} 

}