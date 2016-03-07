package ttt;

import java.rmi.RemoteException;

public class Manager {
	public static void main(String[] args) throws Exception {
			try {
				Game g = new Game();
				g.playGame();
				g.congratulate();
			} catch (RemoteException e) {
				System.out.println("ClientGame: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Lookup: " + e.getMessage());
			}
	}
}