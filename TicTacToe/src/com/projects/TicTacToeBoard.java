package com.projects;

public class TicTacToeBoard {

	private char[] position = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
	
	public void printBoard() {
		int index = 0;
		for (int i=1; i<3; i++) {
			for (int j=1; j<3; j++) {
				System.out.print(position[index] + " | ");
				index++;
			}
			System.out.println(position[index]);
			index++;
			System.out.println("--+---+--");
		}
		for (int j=1; j<3; j++) {
			System.out.print(position[index] + " | ");
			index++;
		}
		System.out.println(position[index]);		
	}
	
	public boolean setXPosition(int pos) {
		if (position[pos] == ' ') {
			position[pos] = 'X';
			return true;
		} else {
			System.out.println("Invalid position");
			return false;
		}
	}
	
	public boolean setOPosition(int pos) {
		if (position[pos] == ' ') {
			position[pos] = 'O';
			return true;
		} else {
			System.out.println("Invalid position");
			return false;
		}
	}
	
	public char[] getPosition() {
		return position;
	}
	
}
