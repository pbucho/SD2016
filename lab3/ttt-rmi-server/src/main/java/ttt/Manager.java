package ttt;
//import TTT;

import java.rmi.RemoteException;

class Manager {
	

  public static void main(String args[]) {
	  try {
		  Game _game = new Game();
		  _game.playGame();
		  _game.congratulate();
	  }
	  catch (RemoteException e){
		  
		  e.printStackTrace();
		  System.out.println("Something nasty happened on the server, game is not there!");
	  }
  }
}
