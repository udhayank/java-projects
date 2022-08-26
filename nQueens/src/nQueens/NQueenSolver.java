package nQueens;

public class NQueenSolver {

	public static void main(String[] args) {
		
		ChessBoard board = new ChessBoard(8);
		solve(board);

	}
	
	static boolean solve(ChessBoard board) {
		
		if(solveCol(board, 0)) {
			board.printBoard();
			return true;
		}
		
		System.out.println("Can't solve!");
		return false;
	}
	
	static boolean solveCol(ChessBoard board, int row) {
		
		int n = board.getPosition().length;
		
		if (row == n) {
			return true;
		}
		
		for (int j=0; j<n; j++) {
			
			int[] pos = {row, j};
			if (board.setQueenPosition(pos)) {
				if(solveCol(board, row+1)) {
					return true;
				}
				
				board.removeQueenPosition(pos);
			}
			
		}
		
		return false;
	}

}
