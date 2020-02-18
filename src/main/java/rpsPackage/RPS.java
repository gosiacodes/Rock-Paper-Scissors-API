package rpsPackage;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller 
@RestController
public class RPS {
	
	public static String player1Choice = "empty";
	public static String player2Choice = "empty";
	public static String gameId = "noId";
	public static String winner = "Not ready. Refresh page in a while.";
	
	// Player 1 GET method
	@RequestMapping(value = "/scores/player1", method = RequestMethod.GET)
	public String getPlayer1(String getPlayer1Choice) throws IOException {
		if (gameId != "PVC") {
		player1Choice = getPlayer1Choice;
		if (player2Choice != "empty") {
			gameId = "PVP";
			winner = WhoIsTheWinner.theWinnerIs(player1Choice, player2Choice, gameId); 
			ScoreBean.resetChoice();
		}
		}
		else {
			return "Game is taken by PVC. Reset game.";
		}
		return winner + "<br><br>" + getScoreBean();
	}
	
	// Player 2 GET method
	@RequestMapping(value = "/scores/player2", method = RequestMethod.GET)
	public String getPlayer2(String getPlayer2Choice) throws IOException {
		if (gameId != "PVC") {
		player2Choice = getPlayer2Choice;
		if (player1Choice != "empty") {
			gameId = "PVP";
			winner = WhoIsTheWinner.theWinnerIs(player1Choice, player2Choice, gameId);
			ScoreBean.resetChoice();
		}
		}
		else {
			return "Game is taken by PVC. Reset game.";
		}
		return winner + "<br><br>" + getScoreBean();
		
	}
	
	// Player vs computer GET method
	@RequestMapping(value = "/scores/playerVsComp", method = RequestMethod.GET)
	public String getPlayer(String getPlayer1Choice) throws IOException {
		if (gameId != "PVP") {
		player1Choice = getPlayer1Choice;
		player2Choice = CompChoice.setCompChoice();
		if (player2Choice != "empty") {
			gameId = "PVC";
			winner = WhoIsTheWinner.theWinnerIs(player1Choice, player2Choice, gameId);
			ScoreBean.resetChoice();
		}
		}
		else {
			return "Game is taken by PVP. Reset game.";
		}
		return winner + "<br><br>" + getScoreBean();
	}
	
	// Scores player 1 POST method 
	@RequestMapping(value = "/scores/scoresPlayer1", method = RequestMethod.POST)
	public static int increaseScoresPlayer1() {
		ScoreBean.SCORESPLAYER1++;
		return ScoreBean.SCORESPLAYER1;
	}
	
	// Scores player 2 POST method 
	@RequestMapping(value = "/scores/scoresPlayer2", method = RequestMethod.POST)
	public static int increaseScoresPlayer2() {
		ScoreBean.SCORESPLAYER2++;
		return ScoreBean.SCORESPLAYER2;
	}
	
	// Ties POST method 
	@RequestMapping(value = "/scores/ties", method = RequestMethod.POST)
	public static int increaseTies() {
		ScoreBean.TIES++;
		return ScoreBean.TIES;
	}
	
	// Reset game POST method 
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resetGame(int resetValue) throws IOException {
		ScoreBean.resetGame(resetValue);
		return getScoreBean();
	} 
	
	@RequestMapping(value = "/scores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() {
		String pattern ="{\"scoresPlayer1\":\"%s\", \"scoresPlayer2\":\"%s\", \"ties\":\"%s\"}";
		return String.format(pattern, ScoreBean.SCORESPLAYER1, ScoreBean.SCORESPLAYER2, ScoreBean.TIES);
	}
	
	@RequestMapping(value = "/scores", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int scoresPlayer1, int scoresPlayer2, int ties) {
		ScoreBean.SCORESPLAYER1 = scoresPlayer1;
		ScoreBean.SCORESPLAYER2 = scoresPlayer2;
		ScoreBean.TIES = ties;
		String pattern ="{\"scoresPlayer1\":\"%s\", \"scoresPlayer2\":\"%s\", \"ties\":\"%s\"}";
		return String.format(pattern, ScoreBean.SCORESPLAYER1, ScoreBean.SCORESPLAYER2, ScoreBean.TIES);
	}

}
