import java.util.Properties;
import javax.naming.*;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.*;

public class HelloServeur {
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			Properties env = System.getProperties();
			env.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
			env.put("java.naming.provider.url", "iiop://localhost:900");
			Context ctx = new InitialContext(env);
			POA poa =  POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			poa.the_POAManager().activate();
			HelloImpl od = new HelloImpl();
			ctx.rebind("Hello", poa.servant_to_reference(od));
			System.out.println("Le serveur est pret ....");
			orb.run();

		} catch (Exception e ) {
			e.printStackTrace();
		}
	}
}