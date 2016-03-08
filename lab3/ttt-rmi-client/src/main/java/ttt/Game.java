package ttt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Game {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	TTTService ttt;
	Scanner keyboardSc;
	int winner = 0;
	int player = 1;

	/**
	 * 
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public Game() throws RemoteException, MalformedURLException, NotBoundException {
		this("localhost",58866);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 */
	public Game(String host, int port) throws RemoteException, MalformedURLException, NotBoundException {
    	keyboardSc = new Scanner(System.in);
    	ttt = null;
		ttt = (TTTService) Naming.lookup("//" + host + ":" + port + "/_game");
		System.out.println("Found server");
	}
	
	/**
	 * 
	 * @return int play
	 */
	public int readPlay() {
		int play;
		do {
			System.out.printf("\nPlayer %d, please enter the number of the square "
							+ "where you want to place your %c (or 0 to refresh the board): \n",
							player, (player == 1) ? 'X' : 'O');
			play = keyboardSc.nextInt();
		} while (play > 10 || play < 0);
		System.out.println("play: " + play);
		return play;
	}

	/**
	 * 
	 * @throws RemoteException
	 */
	public void playGame() throws RemoteException {
		int play;
		boolean playAccepted;

		do {
			player = ++player % 2;
			do {
				System.out.println(ttt.currentBoard());
				play = readPlay();
				if (play != 0) {
					if (play == 10)
					{
						if (ttt.minhaUltima() == 0) System.out.println(ANSI_RED + "This player has not played yet!" + ANSI_RESET);
						else System.out.println("Last play of " + player +" was: " + ttt.minhaUltima());
						playAccepted = false;
					}else{
						playAccepted = ttt.play( --play / 3, play % 3, player);
						if (!playAccepted)
							System.out.println(ANSI_YELLOW + "Invalid play! Try again." + ANSI_RESET);
					}
				} else 
					playAccepted = false;
			} while (!playAccepted);
			winner = ttt.checkWinner();
		} while (winner == -1);
	}

	/**
	 * Prints winner message
	 */
	public void congratulate() {
		if (winner == 2)
			System.out.printf("\nHow boring, it is a draw\n");
		else
			System.out.printf(
					"\nCongratulations, player %d, YOU ARE THE WINNER!\n",
					winner);
	}
}
