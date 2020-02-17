package rpsPackage;

import java.io.IOException;

public class WhoIsTheWinner {
	
	// Method for winner in Player vs Player Game
	public static String theWinnerIsPvP(String player1Choice, String player2Choice) throws IOException {
	    String winner = "The other player is not ready yet. Refresh the page in a while.";
		
	    if (player1Choice.equals(player2Choice) || player2Choice.equals(player1Choice)) {
			winner = "Player 1 and Player 2 - score draw.";
			IncreaseScores.increaseTies();
		}	    
		else if (player1Choice.equals(ScoreBean.ROCK) && player2Choice.equals(ScoreBean.PAPER)) {
			winner = "Player 2 winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (player1Choice.equals(ScoreBean.ROCK) && player2Choice.equals(ScoreBean.SCISSORS)) {
			winner = "Player 1 winns.";
			IncreaseScores.increaseScoresPlayer1();
		}
		else if (player1Choice.equals(ScoreBean.PAPER) && player2Choice.equals(ScoreBean.ROCK)) {
			winner = "Player 1 winns.";
			IncreaseScores.increaseScoresPlayer1();
		}
		else if (player1Choice.equals(ScoreBean.PAPER) && player2Choice.equals(ScoreBean.SCISSORS)) {
			winner = "Player 2 winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (player1Choice.equals(ScoreBean.SCISSORS) && player2Choice.equals(ScoreBean.ROCK)) {
			winner = "Player 2 winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (player1Choice.equals(ScoreBean.SCISSORS) && player2Choice.equals(ScoreBean.PAPER)) {
			winner = "Player 1 winns.";
			IncreaseScores.increaseScoresPlayer1();
		}	
		return winner;
	}
	
	// Method for winner in Player vs Computer Game
	public static String theWinnerIsPvC(String playerChoice, String compChoice) throws IOException {
	    String winner = "";
	    
	    if (playerChoice.equals(compChoice) || compChoice.equals(playerChoice)) {
			winner = "Player and Computer - score draw.";
			IncreaseScores.increaseTies();
		}	    
		else if (playerChoice.equals(ScoreBean.ROCK) && compChoice.equals(ScoreBean.PAPER)) {
			winner = "Computer winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (playerChoice.equals(ScoreBean.ROCK) && compChoice.equals(ScoreBean.SCISSORS)) {
			winner = "Player winns.";
			IncreaseScores.increaseScoresPlayer1();
		}
		else if (playerChoice.equals(ScoreBean.PAPER) && compChoice.equals(ScoreBean.ROCK)) {
			winner = "Player winns.";
			IncreaseScores.increaseScoresPlayer1();
		}
		else if (playerChoice.equals(ScoreBean.PAPER) && compChoice.equals(ScoreBean.SCISSORS)) {
			winner = "Computer winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (playerChoice.equals(ScoreBean.SCISSORS) && compChoice.equals(ScoreBean.ROCK)) {
			winner = "Computer winns.";
			IncreaseScores.increaseScoresPlayer2();
		}
		else if (playerChoice.equals(ScoreBean.SCISSORS) && compChoice.equals(ScoreBean.PAPER)) {
			winner = "Player winns.";
			IncreaseScores.increaseScoresPlayer1();
		}
		return winner;
	}
}
