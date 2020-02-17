package rpsPackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class IncreaseScores {

	@RequestMapping(value = "/scores/scoresPlayer1", method = RequestMethod.POST)
	public static int increaseScoresPlayer1() {
		ScoreBean.SCORESPLAYER1++;
		return ScoreBean.SCORESPLAYER1;
	}
	
	@RequestMapping(value = "/scores/scoresPlayer2", method = RequestMethod.POST)
	public static int increaseScoresPlayer2() {
		ScoreBean.SCORESPLAYER2++;
		return ScoreBean.SCORESPLAYER2;
	}
	
	@RequestMapping(value = "/scores/ties", method = RequestMethod.POST)
	public static int increaseTies() {
		ScoreBean.TIES++;
		return ScoreBean.TIES;
	}
	
}
