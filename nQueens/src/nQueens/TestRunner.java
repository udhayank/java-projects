package nQueens;

public class TestRunner {

	public static void main(String[] args) {
		
		ChessBoard board = new ChessBoard(8);
		
		int[] pos = {1,1};
		board.setQueenPosition(pos);
//		pos[0] = 0; pos[1] = 7;
//		board.setQueenPosition(pos);
		
		board.printBoard();

	}

}
