package ttt;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Manager {
	public static void main(String[] args) {
			try {
				Game g = new Game();
				g.playGame();
				g.congratulate();
			} catch (RemoteException e) {
				System.out.println("ClientGame: " + e.getMessage());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("ClientGame: " + e.getMessage());
			} catch (NotBoundException e) {
				e.printStackTrace();
				System.out.println("ClientGame: " + e.getMessage());
			}
	}
}