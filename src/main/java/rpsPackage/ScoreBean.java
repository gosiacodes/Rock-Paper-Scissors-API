package rpsPackage;

import java.io.IOException;

public class ScoreBean {
	
	public static String ROCK = "rock";
	public static String PAPER = "paper";
	public static String SCISSORS = "scissors";
	
	public static int SCORESPLAYER1, SCORESPLAYER2, TIES;
	
		
	// Method for reset game / value of scores
	public static void resetGame(int resetValue) throws IOException {
		ScoreBean.SCORESPLAYER1 = resetValue;
		ScoreBean.SCORESPLAYER2 = resetValue;
		ScoreBean.TIES = resetValue;
	}

}
