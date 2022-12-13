import java.rmi.RemoteException;
import java.util.Date;

public class ConvertisseurImpl implements ConvertisseurInterface {

    public void ConvertisseurImpl(){}
    public Date AfficherDate() throws RemoteException {
        return new Date();
    }
    public float euroToDinar(float mt) throws RemoteException {
        return mt * (float)3.42;
    }
    public float dinarToEuro(float mt) throws RemoteException{
        return mt * (float)0.29;
    }
    public float dollarToDinar(float mt) throws RemoteException {
        return mt * (float)3.26;
    }
    public float dinarToDollar(float mt) throws RemoteException{
        return mt * (float)0.31;
    }
}
