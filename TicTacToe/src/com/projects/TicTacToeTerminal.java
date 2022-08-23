package com.projects;

import java.util.Scanner;

public class TicTacToeTerminal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
						
		TicTacToeBoard board = new TicTacToeBoard();
		
		boolean isGameOver = false;
		boolean isXTurn = true;
		boolean[] gameStatus = {isXTurn, isGameOver};
		
		while(!gameStatus[1]) {
			
			if (gameStatus[0]) {
				gameStatus = xTurn(board, scanner);
			} else {
				gameStatus = oTurn(board, scanner);
			}
						
		}
		
		System.out.println("Game over!");
		board.printBoard();
		
		scanner.close();
		
		
	}
	
	static boolean[] xTurn(TicTacToeBoard board, Scanner scanner) {
		
//		Scanner scanner = new Scanner(System.in);
		
		boolean isXTurn, isGameOver;
		
		System.out.println("X turn: ");
		board.printBoard();
		System.out.print("Enter position from 1 to 9:");
		int pos = 1;
		if (scanner.hasNextInt()) {
			pos = scanner.nextInt();			
		}
		isXTurn = !(board.setXPosition(pos-1));
		if (TicTacToeEvaluation.isXWin(board.getPosition())){
			System.out.println("X wins");
			board.printBoard();
			isGameOver = true;
//			scanner.close();
			return new boolean[] {isXTurn, isGameOver};
		}
		
		isGameOver = true;
		for (int i=0; i<9; i++) {
			if (board.getPosition()[i] == ' ') {
				isGameOver = false;
			}
		}
		
//		scanner.close();
		
		return new boolean[] {isXTurn, isGameOver}; 
		
	}
	
	static boolean[] oTurn(TicTacToeBoard board, Scanner scanner) {
		
//		Scanner scanner = new Scanner(System.in);
		
		boolean isXTurn, isGameOver;
		
		System.out.println("O turn: ");
		board.printBoard();
		System.out.print("Enter position from 1 to 9:");
		int pos = 10;
		if (scanner.hasNextInt()) {
			pos = scanner.nextInt();			
		}
		isXTurn = board.setOPosition(pos-1);
		if (TicTacToeEvaluation.isOWin(board.getPosition())){
			System.out.println("O wins");
			board.printBoard();
			isGameOver = true;
//			scanner.close();
			return new boolean[] {isXTurn, isGameOver};
		}
		
		isGameOver = true;
		for (int i=0; i<9; i++) {
			if (board.getPosition()[i] == ' ') {
				isGameOver = false;
			}
		}
		
//		scanner.close();
		
		return new boolean[] {isXTurn, isGameOver}; 
		
	}
		

}
