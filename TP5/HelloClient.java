import java.util.Properties;
import javax.naming.*;
import HelloApp.*;

public class HelloClient {
	public static void main(String[] args) {
		try {
			Properties env = System.getProperties();

			env.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
			env.put("java.naming.provider.url", "iiop://localhost:900");
			Context ctx = new InitialContext(env);

			Object ref = ctx.lookup("Hello");
			Hello stub = HelloHelper.narrow((org.omg.CORBA.Object)ref);
			System.out.println(stub.sayHello());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}