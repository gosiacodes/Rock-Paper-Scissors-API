package rpsPackage;

import java.io.IOException;

public class ScoreBean {
	
	public static int SCORESPLAYER1, SCORESPLAYER2, TIES;
			
	// Method for reset game / value of scores
	public static void resetGame(int resetValue) throws IOException {
		ScoreBean.SCORESPLAYER1 = resetValue;
		ScoreBean.SCORESPLAYER2 = resetValue;
		ScoreBean.TIES = resetValue;
		RPS.gameId = "noId";
		RPS.winner = "Not ready. Refresh page in a while.";
		resetChoice();
	}
	
	public static void resetChoice() {
		RPS.player1Choice = "empty";
		RPS.player2Choice = "empty";
	}

}
