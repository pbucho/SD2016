package ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		try {
			System.out.println("Em que morada está o servidor? ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String host;
			host = br.readLine();

			System.out.println("Em que porta está o servidor? ");
			Scanner keyboardSc = new Scanner(System.in);
			int port = keyboardSc.nextInt();
			System.out.println("HOST: " + host + " PORT: " + port);
			
			Game g = new Game(host, port);
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}