package com.projects;

public class TicTacToeEvaluation {
	
	static boolean checkRow(char[] position, char ch) {
		for(int i=0; i<9; i+=3) {
			if(position[i]==ch && position[i+1]==ch && position[i+2]==ch) {
				return true;
			} 
		}
		return false;
	}
	
	static boolean checkColumn(char[] position, char ch) {
		for(int i=0; i<3; i++) {
			if(position[i]==ch && position[i+3]==ch && position[i+6]==ch) {
				return true;
			}			
		}
		return false;
	}
	
	static boolean checkDiagonal(char[] position, char ch) {
		if(position[0]==ch && position[4]==ch && position[8]==ch) {
			return true;
		} else if(position[2]==ch && position[4]==ch && position[6]==ch) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isXWin(char[] position) {
		if( checkRow(position, 'X') ||
			checkColumn(position, 'X') ||	
			checkDiagonal(position, 'X')) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isOWin(char[] position) {
		if( checkRow(position, 'O') ||
			checkColumn(position, 'O') ||	
			checkDiagonal(position, 'O')) {
			return true;
		} else {
			return false;
		}
	}
	
}
