import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClientBanque {
	public static void main(String[] args) {
			Scanner clavier = new Scanner(System.in);
			float temp;
			int choix;
    		try {
			Registry reg = LocateRegistry.getRegistry();
		    BanqueInterface stub = (BanqueInterface)reg.lookup("remote");
			while (true) {
    			System.out.println("1 pour afficher le solde, 2 pour retirer, 3 pour verser, 4 pour quitter");
    			choix = clavier.nextInt();
	    			switch (choix) {
	    				case 1:
	    					System.out.println(stub.AfficherSolde());
	    					break;
						case 2:
							System.out.println("Combien voulez vous retirer");
							temp = clavier.nextFloat();
	    					stub.retirer(temp);
	    					break;
						case 3:
							System.out.println("Combien voulez vous verser");
							temp = clavier.nextFloat();
	    					stub.verser(temp);
	    					break;
	    				case 4:
	    					return;

	    				default: 
	    					System.out.println("Choix invalide"); 
	    		}
	    	}
		}
	   	catch (Exception e) {
	   		e.printStackTrace();
	   	}

	}
}