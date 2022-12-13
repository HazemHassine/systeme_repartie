import java.rmi.RemoteException;
public class HelloImpl implements Hello {
    public String ShowMsg() throws RemoteException {
        return "Cette message n'est pas la resulat du program client, elle vient du Serveur";
    }
}