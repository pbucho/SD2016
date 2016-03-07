package ttt;
//import TTT;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.MalformedURLException;
//import java.rmi.*;

class Manager {
	

  public static void main(String args[]) throws MalformedURLException {
	  int registryPort = 58866;
	  System.out.println("Port chosen: " + registryPort);
	  try {
		  TTTService _game = new TTT();
          System.out.println("Created TTT object");
          
          Registry reg = LocateRegistry.createRegistry(registryPort);
          //Naming.rebind("_game", _game);
          reg.rebind("_game", _game);
          System.out.println("TTT online");

          
	  }
	  catch (RemoteException e){
		  
		  System.out.println(e.getMessage());
		  System.out.println("Something nasty happened while launching the server");
	  }
  }
}
