import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	YahtzeeDie d1;
	YahtzeeDie d2;
	YahtzeeDie d3;
	YahtzeeDie d4;
	YahtzeeDie d5;
	YahtzeeScorecard ysc1;
	private static final int NUM_SIDES = 6;
	String userSatis;
	String whichDie;
	String whereToMark;
	char whichDieNum;
	Scanner s;
	String cont=new String();

	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		d1=new YahtzeeDie(NUM_SIDES);

		d2=new YahtzeeDie(NUM_SIDES);

		d3=new YahtzeeDie(NUM_SIDES);

		d4=new YahtzeeDie(NUM_SIDES);

		d5=new YahtzeeDie(NUM_SIDES);

		ysc1 = new YahtzeeScorecard();
		/* your code here */
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for (int i = 0; i <13 ; i++) {
			this.takeTurn();

		}

		this.ysc1.printScoreCard();
		return this.ysc1.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		rollDice();
		printDice();
		System.out.println("Are you (s)atisfied or do you want to (r)isk and try your luck again? (s/r): ");
		s = new Scanner(System.in);
		userSatis = s.nextLine();
		if(userSatis.equals("r")){
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("Are you (s)atisfied or do you want to (r)eroll? (s/r): ");
			s = new Scanner(System.in);
			userSatis = s.nextLine();
			if(userSatis.equals("r")){
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}
		}
		markScore();
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(d1.isFrozen()!=true){
			d1.rollDie();
		}else{
			d1.unfreezeDie();
		}
		if(d2.isFrozen()!=true){
			d2.rollDie();
		}else {
			d1.unfreezeDie();
		}
		if(d3.isFrozen()!=true) {
			d3.rollDie();
		}else {
			d1.unfreezeDie();
		}
		if(d4.isFrozen()!=true){
			d4.rollDie();
		}else {
			d1.unfreezeDie();
		}
		if(d5.isFrozen()!=true) {
			d5.rollDie();
		}else {
			d1.unfreezeDie();
		}
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.println("Which dice would you like to freeze?(separate by spaces): ");
		whichDie = s.nextLine();
		if(whichDie.indexOf("1")>-1){
			d1.freezeDie();
		}
		if(whichDie.indexOf("2")>-1){
			d2.freezeDie();
		}
		if(whichDie.indexOf("3")>-1){
			d3.freezeDie();
		}
		if(whichDie.indexOf("4")>-1){
			d4.freezeDie();
		}
		if(whichDie.indexOf("5")>-1){
			d5.freezeDie();
		}

	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println("Dice 1: "+d1.getValue()+"\t Dice 2: "+ d2.getValue()+"\t Dice 3: "+ d3.getValue()
				+"\t Dice 4: "+ d4.getValue()+"\t Dice 5: "+ d5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		System.out.println("Where would you like to mark your score?: \n1: Ones\n2: Twos\n3: Threes\n4: Fours\n5: Fives\n6: Sixes" +
				"\n7: Three of a Kind" +
				"\n8: Four of a Kind\n9: Full House\n10: Small Straight\n11: Large Straight" +
				"\n12: Yahtzee");
		whereToMark = s.nextLine();
		boolean wasSuccessful = false;
        if (cont.indexOf(whereToMark)==-1){
		while(!wasSuccessful){
			switch(whereToMark) {
				case "1":
					wasSuccessful = ysc1.markOnes(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "2":
					wasSuccessful = ysc1.markTwos(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "3":
					wasSuccessful = ysc1.markThrees(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "4":
					wasSuccessful = ysc1.markFours(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "5":
					wasSuccessful = ysc1.markFives(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "6":
					wasSuccessful = ysc1.markSixes(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "7":
					wasSuccessful = ysc1.markThreeOfAKind(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "8":
					wasSuccessful = ysc1.markFourOfAKind(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "9":
					wasSuccessful = ysc1.markFullHouse(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "10":
					wasSuccessful = ysc1.markSmallStraight(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "11":
					wasSuccessful = ysc1.markLargeStraight(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
				case "12":
					wasSuccessful = ysc1.markYahtzee(d1.getValue(), d2.getValue(), d3.getValue(), d4.getValue(), d5.getValue());
					break;
			}
			}
		}
        else{
			markScore();
		}
		cont+=whereToMark;
		ysc1.printScoreCard();
	}
}