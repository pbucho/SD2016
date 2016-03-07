package ttt;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface TTTService extends Remote {

  /**
   * @throws RemoteException
   * @return String containing the current board
   */
  public String currentBoard() throws RemoteException;

  /**
   * @throws RemoteException
   * @return boolean
   * @param int row number
   * @param int column number
   * @param player number
   */
  public boolean play(int row, int column, int number) throws RemoteException;

  /**
   * Remote method that plays a random play
   * 
   * @param int player id
   * @return boolean
   * @throws RemoteException
   */
  public boolean randomPlay(int number) throws RemoteException;

  /**
   * @throws RemoteException
   * @return int player number that wins or -1 when does not exist a winner
   */
  public int checkWinner() throws RemoteException;
  
}
