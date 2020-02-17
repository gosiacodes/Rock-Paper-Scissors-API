package rpsPackage;

public class CompChoice {

	public static String setCompChoice() {
		String randomCompChoice = "No computer choice.";
		int randomChoice = (int)(1 + Math.random()*3);
		if (randomChoice == 1) {
			randomCompChoice = "rock";
		}
		else if (randomChoice == 2) {
			randomCompChoice = "paper";
		}
		else if (randomChoice == 3) {
			randomCompChoice = "scissors";
		}
		return randomCompChoice;
	}
	
}
