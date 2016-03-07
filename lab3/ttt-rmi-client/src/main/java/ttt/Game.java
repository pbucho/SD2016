package ttt;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.*;

public class Game {
  TTTService ttt;
  Scanner keyboardSc;
  int winner = 0;
  int player = 1;

  public Game() throws RemoteException, Exception{
      keyboardSc = new Scanner(System.in);
      ttt = null;
    ttt = (TTTService) Naming.lookup("//localhost:58866/_game");
    System.out.println("Found server");
  }
    
  public int readPlay() {
    int play;
    do {
      System.out.printf("\nPlayer %d, please enter the number of the square "
              + "where you want to place your %c (or 0 to refresh the board): \n",
              player, (player == 1) ? 'X' : 'O');
      play = keyboardSc.nextInt();
    } while (play > 10 || play < 0);
    return play;
  }

  public void playGame() throws RemoteException {
    int play;
    boolean playAccepted;

    do {
      player = ++player % 2;
      do {
        System.out.println(ttt.currentBoard());
        play = readPlay();
        if (play != 0) {
          if(play == 10){
            if(!ttt.randomPlay(player)) System.out.println("Invalid play! Try again.");
          }else{
            playAccepted = ttt.play( --play / 3, play % 3, player);
            if (!playAccepted) System.out.println("Invalid play! Try again.");
          }
        } else
          playAccepted = false;
      } while (!playAccepted);
      winner = ttt.checkWinner();
    } while (winner == -1);
  }

  public void congratulate() {
    if (winner == 2)
      System.out.printf("\nHow boring, it is a draw\n");
    else
      System.out.printf(
          "\nCongratulations, player %d, YOU ARE THE WINNER!\n",
          winner);
  }
}
