package ttt;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public interface TTT {
	String currentBoard();

	boolean play(int row, int column, int player);

	int checkWinner();

	List<Integer> posicoesLivres();

}
