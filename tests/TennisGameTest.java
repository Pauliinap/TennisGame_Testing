import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_1_1() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();

		game.player2Scored();
		
		String score = game.getScore() ;
		
		assertEquals("Score incorrect", "15 - 15", score);		
	}
	
	@Test
	public void testTennisGame_2_2() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		
		assertEquals("Score incorrect", "30 - 30", score);		
	}
	
	@Test
	public void testTennisGame_1_0() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		
		assertEquals("Score incorrect", "15 - love", score);		
	}
	
	@Test
	public void testTennisGame_0_1() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_2_0() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "30 - love", score);
	}
	
	@Test
	public void testTennisGame_0_2() throws TennisGameException {
		
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
	
		assertEquals("Score incorrect", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}

	@Test
	public void testTennisGame__Palyer1HasAdventage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame__Palyer2HasAdventage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins_4_0() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins_0_4() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins_4_1() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins_1_4() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins_4_2() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();

		game.player1Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins_2_4() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();

		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		assertEquals("Score incorrect", "player2 wins", score);
	}
}
