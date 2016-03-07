package ttt;
//import TTT;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

class Manager {
	

  public static void main(String args[]) {
	  int registryPort = 58866;
	  System.out.println("Port chosen: " + registryPort);
	  try {
		  TTT _game = new TTT();
          System.out.println("Created TTT object");
          
          Registry reg = LocateRegistry.createRegistry(registryPort);
          reg.rebind("TTT", _game);
          System.out.println("TTT online");

          
	  }
	  catch (RemoteException e){
		  
		  System.out.println(e.getMessage());
		  System.out.println("Something nasty happened on the server, game is not there!");
	  }
  }
}
