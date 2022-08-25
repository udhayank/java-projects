package com.projects;

public class TicTacToeBot {
	
	public static int bestMove(char[] position) {
		
		int bestMove = 0;
		int score = 0;
		int bestScore = Integer.MIN_VALUE;
		
		for (int i=0; i<position.length; i++) {
			if (position[i] == ' ') {
				position[i] = 'O';
				score = minimax(position, false);
				position[i] = ' ';
//				System.out.println(i + " - " + score);
				if (score > bestScore) {
					bestScore = score;
					bestMove = i;
				}
			}
		}
		return bestMove;
		
	}
	
	public static int minimax(char[] position, boolean isMaximizing) {
		
		if (TicTacToeEvaluation.isOWin(position)) {
			return 1;
		} else if (TicTacToeEvaluation.isXWin(position)) {
			return -1;
		} else if (TicTacToeEvaluation.isGameOver(position)){
			return 0;
		} else {
			
			if(isMaximizing) {
				
				int bestScore = Integer.MIN_VALUE;
				for (int i=0; i<position.length; i++) {
					if (position[i] == ' ') {
						position[i] = 'O';
						int score = minimax(position, false);
						position[i] = ' ';
						bestScore = score > bestScore ? score : bestScore;
					}
				}
				return bestScore;
				
			} else {
				
				int bestScore = Integer.MAX_VALUE;
				for (int i=0; i<position.length; i++) {
					if (position[i] == ' ') {
						position[i] = 'X';
						int score = minimax(position, true);
						position[i] = ' ';
						bestScore = score < bestScore ? score : bestScore;
					}
				}
				return bestScore;
				
			}
			
		}
				
	}
	
	
	
}
