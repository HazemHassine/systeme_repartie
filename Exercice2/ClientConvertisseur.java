import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClientConvertisseur {
	public static void main(String[] args) {
			Scanner clavier = new Scanner(System.in);
			float temp, temp1;
			int choix;
    		try {
			Registry reg = LocateRegistry.getRegistry();
		    ConvertisseurInterface stub = (ConvertisseurInterface)reg.lookup("away");
   			System.out.println("1 pour afficher la date\n2 pour convertir euro to dinar\n3 pour convertir du dinar a l'euro\n4 pour convertir du l'euro a dinar\n5 pour convertir du dinar to dollar\n6 pour quitter");
			while (true) {
    			choix = clavier.nextInt();
	    			switch (choix) {
	    				case 1:
	    					System.out.println(stub.AfficherDate());
	    					break;
						case 2:
							System.out.println("Entrer le montant a convertir");
							temp = clavier.nextFloat();
	    					temp1 = stub.euroToDinar(temp);
	    					System.out.println(temp1);
	    					break;
						case 3:
							System.out.println("Entrer le montant a convertir");
							temp = clavier.nextFloat();
	    					temp1 = stub.dinarToEuro(temp);
	    					System.out.println(temp1);
	    					break;
	    				case 4:
							System.out.println("Entrer le montant a convertir");
							temp = clavier.nextFloat();
	    					temp1 = stub.dollarToDinar(temp);
	    					System.out.println(temp1);
	    					break;
	    				case 5:
							System.out.println("Entrer le montant a convertir");
							temp = clavier.nextFloat();
	    					temp1 = stub.dinarToDollar(temp);
	    					System.out.println(temp1);
	    					break;
	    				case 6:
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