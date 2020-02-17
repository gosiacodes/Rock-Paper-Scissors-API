package rpsPackage;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller 
@RestController
public class RPS {
	
	public String player1Choice = "no choice";
	public String player2Choice = "no choice";
	public String playerChoice = "no choice";
	public String compChoice = "no choice";
	public String printPlayer1Choice = "";
	public String printPlayer2Choice = ""; 
	public String winner = "The other player is not ready yet. Refresh the page in a while.";
	// Testing boolean - not ready
	public boolean player1ready = false;
	public boolean player2ready = false;
	
	// Player 1 GET method
	@RequestMapping(value = "/scores/player1", method = RequestMethod.GET)
	public String getPlayer1(String getPlayer1Choice) throws IOException {
		player1Choice = getPlayer1Choice;
		if (player2Choice != "no choice") {
			player1ready = true;
			winner = WhoIsTheWinner.theWinnerIsPvP(player1Choice, player2Choice);
			printPlayer1Choice = player1Choice;
			printPlayer2Choice = player2Choice; 
			player1Choice = "no choice";
			player2Choice = "no choice";
		}
		//player1ready = false;
		return winner + "<br><br>" + "Player 1: " + printPlayer1Choice + "<br><br>" + "Player 2: " + printPlayer2Choice + "<br><br>" + getScoreBean();
	}
	
	// Player 2 GET method
	@RequestMapping(value = "/scores/player2", method = RequestMethod.GET)
	public String getPlayer2(String getPlayer2Choice) throws IOException {
		player2Choice = getPlayer2Choice;
		if (player1Choice != "no choice") {
			player2ready = true;
			winner = WhoIsTheWinner.theWinnerIsPvP(player1Choice, player2Choice);
			printPlayer1Choice = player1Choice;
			printPlayer2Choice = player2Choice; 
			player1Choice = "no choice";
			player2Choice = "no choice";
		}
		//player1ready = false;
		return winner + "<br><br>" + "Player 1: " + printPlayer1Choice + "<br><br>" + "Player 2: " + printPlayer2Choice + "<br><br>" + getScoreBean();
	}
	
	// Player vs computer GET method
	@RequestMapping(value = "/scores/playerVsComp", method = RequestMethod.GET)
	public String getPlayer(String getPlayerChoice) throws IOException {
		playerChoice = getPlayerChoice;
		compChoice = CompChoice.setCompChoice();
		if (compChoice != "no choice") {
			winner = WhoIsTheWinner.theWinnerIsPvC(playerChoice, compChoice);
			printPlayer1Choice = playerChoice;
			printPlayer2Choice = compChoice; 
			playerChoice = "no choice";
			compChoice = "no choice";
		}
		return winner + "<br><br>" + "You: " + printPlayer1Choice + "<br><br>" + "Computer: " + printPlayer2Choice + "<br><br>" + getScoreBean();
	}
	
//	// Player 1 POST method
//	@RequestMapping(value = "/scores/player1", method = RequestMethod.POST)
//	public String postPlayer1(String theWinnerIsPvP) throws IOException {
//		winner = WhoIsTheWinner.theWinnerIsPvP(player1Choice, player2Choice);
//		return winner + "<br><br>" + getScoreBean();
//	}	
//	
//	// Player 2 POST method
//	@RequestMapping(value = "/scores/player2", method = RequestMethod.POST)
//	public String postPlayer2(String theWinnerIsPvP) throws IOException {
//		winner = WhoIsTheWinner.theWinnerIsPvP(player1Choice, player2Choice);
//		return winner + "<br><br>" + getScoreBean();
//	}
//	
//	// Player vs computer POST method
//	@RequestMapping(value = "/scores/playerVsComp", method = RequestMethod.POST)
//	public String postPlayerVsComp(String theWinnerIsPvC) throws IOException {
//		winner = WhoIsTheWinner.theWinnerIsPvC(playerChoice, compChoice);
//		return winner + "<br><br>" + getScoreBean();
//	}
	
	// Reset game POST method 
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resetGame(int resetValue) throws IOException {
		ScoreBean.resetGame(resetValue);
		return getScoreBean();
	} 
	
	@RequestMapping(value = "/scores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() {
		String pattern ="{\"Scores Player 1\":\"%s\", \"Scores Player 2\":\"%s\", \"ties\":\"%s\"}";
		return String.format(pattern, ScoreBean.SCORESPLAYER1, ScoreBean.SCORESPLAYER2, ScoreBean.TIES);
	}
	
	@RequestMapping(value = "/scores", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int scoresPlayer1, int scoresPlayer2, int ties) {
		ScoreBean.SCORESPLAYER1 = scoresPlayer1;
		ScoreBean.SCORESPLAYER2 = scoresPlayer2;
		ScoreBean.TIES = ties;
		String pattern ="{\"Scores Player 1\":\"%s\", \"Scores Player 2\":\"%s\", \"ties\":\"%s\"}";
		return String.format(pattern, ScoreBean.SCORESPLAYER1, ScoreBean.SCORESPLAYER2, ScoreBean.TIES);
	}

}
