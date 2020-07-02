package net.shcherbakovs.code.examples;

public class TicTacToe {

	private boolean[] horizontalWins;
	private boolean[] verticalWins;
	private boolean diagonalWin1;
	private boolean diagonalWin2;
	private int size;

	public TicTacToe(boolean[][] game) {
		if(game.length == 0 || game.length != game[0].length) {
			throw new IllegalArgumentException();
		}
		this.size = game.length;
		horizontalWins = new boolean[size];
		verticalWins = new boolean[size];
		diagonalWin1 = diagonalWin2 = true;
		for(int i=0; i<size; i++) {
			horizontalWins[i] = true;
			verticalWins[i] = true;
		}
		for(int i=0; i<size; i++) {
			boolean f = game[i][0];
			for(int j=1; j<size; j++) {
				if(game[i][j] != f) {
					horizontalWins[i] = false;
					break;
				}
			}
		}
		for(int j=0; j<size; j++) {
			boolean f = game[0][j];
			for(int i=1; i<size; i++) {
				if(game[i][j] != f) {
					verticalWins[j] = false;
					break;
				}
			}
		}
		boolean f = game[0][0];
		for(int i=1; i<size; i++) {
			if(game[i][i] != f) {
				diagonalWin1 = false;
				break;
			}
		}
		f = game[0][size-1];
		for(int i=1; i<size; i++) {
			if(game[i][size-1-i] != f) {
				diagonalWin2 = false;
				break;
			}
		}
	}

	public boolean isWon() {
		for(int i=0; i<size; i++) {
			if(horizontalWins[i] || verticalWins[i]) {
				return true;
			}
		}
		return diagonalWin1 || diagonalWin2;
	}

}
