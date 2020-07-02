package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTests {

	@Test
	public void testTicTacToe1() {
		boolean[][] game = {
			{ true, false, false },
			{ false, true, true },
			{ false, false, true}
		};
		assertTrue(new TicTacToe(game).isWon());
	}

	@Test
	public void testTicTacToe2() {
		boolean[][] game = {
			{ true, false, false },
			{ false, true, true },
			{ false, false, false}
		};
		assertTrue(new TicTacToe(game).isWon());
	}

	@Test
	public void testTicTacToe3() {
		boolean[][] game = {
			{ true, false, false },
			{ false, true, true },
			{ false, true, false}
		};
		assertFalse(new TicTacToe(game).isWon());
	}

}
