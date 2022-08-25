package com.projects;

import java.util.Scanner;

public class TicTacToeTerminal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - 1 Player (vs CPU)");		
		System.out.println("2 - 2 Player");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		if (!(choice == 1 || choice == 2)) {
			System.out.println("Invalid choice");
			scanner.close();
			return;
		}
						
		TicTacToeBoard board = new TicTacToeBoard();
		
		boolean isGameOver = false;
		boolean isXTurn = true;
		boolean[] gameStatus = {isXTurn, isGameOver};
		
		while(!gameStatus[1]) {
			
			if (gameStatus[0]) {
				gameStatus = xTurn(board, scanner);
			} else {
				if (choice == 1) {
					gameStatus = cpuTurn(board, scanner);					
				} else {
					gameStatus = oTurn(board, scanner);					
				}
			}
						
		}
						
		scanner.close();
		
		
	}
	
	static boolean[] xTurn(TicTacToeBoard board, Scanner scanner) {
				
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
			return new boolean[] {isXTurn, isGameOver};
		}
		
		isGameOver = TicTacToeEvaluation.isGameOver(board.getPosition());
		if (isGameOver) {
			System.out.println("Game over!");
			board.printBoard();
		}		
		
		return new boolean[] {isXTurn, isGameOver}; 
		
	}
	
	static boolean[] oTurn(TicTacToeBoard board, Scanner scanner) {
				
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
			return new boolean[] {isXTurn, isGameOver};
		}
		
		isGameOver = TicTacToeEvaluation.isGameOver(board.getPosition());
		if (isGameOver) {
			System.out.println("Game over!");
			board.printBoard();
		}
				
		return new boolean[] {isXTurn, isGameOver}; 
		
	}
	
	static boolean[] cpuTurn(TicTacToeBoard board, Scanner scanner) {
				
		boolean isXTurn, isGameOver;
				
		int pos = TicTacToeBot.bestMove(board.getPosition());
		
		isXTurn = board.setOPosition(pos);
		if (TicTacToeEvaluation.isOWin(board.getPosition())){
			System.out.println("CPU wins");
			board.printBoard();
			isGameOver = true;
			return new boolean[] {isXTurn, isGameOver};
		}
		
		isGameOver = TicTacToeEvaluation.isGameOver(board.getPosition());
				
		return new boolean[] {isXTurn, isGameOver}; 
		
	}
		

}
