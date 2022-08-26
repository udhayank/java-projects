package nQueens;

import java.util.Arrays;

public class ChessBoard {
	
	private int n;
	private char[][] position;
	
	ChessBoard(int n){
		this.n = n;
		this.position = new char[n][n];
		for (char[] a:position) {
			Arrays.fill(a, ' ');
		}		
	}
			
	public char[][] getPosition(){
		return position;
	}
	
	public void printBoard() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print("+---");
			}
			System.out.println("+");
			for (int j=0; j<n; j++) {
				System.out.print("| " + position[i][j] + " ");
			}
			System.out.println("|");
		}
		for (int j=0; j<n; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
		
	}
	
	public boolean setQueenPosition(int[] pos) {
		if (isPositionAvailable(position, pos)) {
			position[pos[0]][pos[1]] = 'Q';
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeQueenPosition(int[] pos) {
		if (position[pos[0]][pos[1]] == 'Q') {
			position[pos[0]][pos[1]] = ' ';
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPositionAvailable(char[][] position, int[] pos) {
		if (checkRow(position, pos) && checkCol(position, pos) && checkDiagonal(position, pos)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean checkRow(char[][] position, int[] pos) {
		int i = pos[0], j = pos[1], n = position.length;
		for (int a=j+1; a<n; a++) {
			if (position[i][a] == 'Q') {
				return false;
			}			
		}
		for (int a=0; a<j; a++) {
			if (position[i][a] == 'Q') {
				return false;
			}	
		}
		return true;
	}
	
	private static boolean checkCol(char[][] position, int[] pos) {
		int i = pos[0], j = pos[1], n = position.length;
		for (int a=i+1; a<n; a++) {
			if (position[a][j] == 'Q') {
				return false;
			}			
		}
		for (int a=0; a<i; a++) {
			if (position[a][j] == 'Q') {
				return false;
			}	
		}
		return true;
	}
	
	private static boolean checkDiagonal(char[][] position, int[] pos) {
		int i = pos[0], j = pos[1], n = position.length;
		// primary diagonal
		for (int a=i+1, b=j+1; a<n && b<n; a++, b++) {
			if (position[a][b] == 'Q') {
				return false;
			}		
		}
		for (int a=i-1, b=j-1; a>=0 && b>=0; a--, b--) {
			if (position[a][b] == 'Q') {
				return false;
			}		
		}
		// off diagonal
		for (int a=i+1, b=j-1; a<n && b>=0; a++, b--) {
			if (position[a][b] == 'Q') {
				return false;
			}	
		}
		for (int a=i-1, b=j+1; a>=0 && b<n; a--, b++) {
			if (position[a][b] == 'Q') {
				return false;
			}	
		}
		return true;
	}
	
	
}
