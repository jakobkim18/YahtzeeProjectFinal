import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		Scanner s;
		int score;
		String userChoice;
		int min=651;
		int max=0;
		double avScore;
		int totalGames = 0;
		int finalScore = 0;
		do{
			s = new Scanner(System.in);
			YahtzeeGame myGame=new YahtzeeGame();
			System.out.println("Welcome to Jakob's APCSA Yahtzee Game!:)");
			score=myGame.playGame();
			System.out.println("Would you like to play again?(y/n): ");
			userChoice = s.nextLine();
			finalScore+=score;
			++totalGames;
			if(score<min){
				min = score;
			}
			if(score>max){
				max = score;
			}
		}while(userChoice.equals("y"));

		System.out.println("Total Amount of Games: "+totalGames);
		System.out.println("The Minimum Score: "+min);
		System.out.println("The Maximum Score: "+max);
		avScore = finalScore/(double)totalGames;
		System.out.println("The Average Score: "+avScore);


	}
}
