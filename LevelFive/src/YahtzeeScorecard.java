public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;
	int upperTotal;
	int lowerTotal;
	int grandTotal;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{

		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;
	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		if(die1!='a'&&ones != -1){
			return false;
		}else{
			int helperInt=0;
			if(die1 == 1){
                helperInt++;
			}
			if(die2 == 1){
                helperInt++;
			}
			if(die3 == 1){
                helperInt++;
			}
			if(die4 == 1){
                helperInt++;
			}
			if(die5 == 1){
                helperInt++;
			}
			ones=helperInt;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5) {
		if (twos != -1) {
			return false;
		} else {
			int helperInt=0;
			if (die1 == 2) {
                helperInt++;
			}
			if (die2 == 2) {
                helperInt++;
			}
			if (die3 == 2) {
                helperInt++;
			}
			if (die4 == 2) {
                helperInt++;
			}
			if (die5 == 2) {
                helperInt++;
			}
			twos=helperInt * 2;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		if (threes != -1) {
			return false;
		} else {
			int helperInt=0;
			if (die1 == 3) {
                helperInt++;
			}
			if (die2 == 3) {
                helperInt++;
			}
			if (die3 == 3) {
                helperInt++;
			}
			if (die4 == 3) {
                helperInt++;
			}
			if (die5 == 3) {
                helperInt++;
			}
			threes=helperInt * 3;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		if (fours != -1) {
			return false;
		} else {
			int helperInt=0;
			if (die1 == 4) {
                helperInt++;
			}
			if (die2 == 4) {
                helperInt++;
			}
			if (die3 == 4) {
                helperInt++;
			}
			if (die4 == 4) {
                helperInt++;
			}
			if (die5 == 4) {
                helperInt++;
			}
			fours=helperInt*4;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		if (fives != -1) {
			return false;
		} else {
			int helperInt=0;
			if (die1 == 5) {
                helperInt++;
			}
			if (die2 == 5) {
                helperInt++;
			}
			if (die3 == 5) {
                helperInt++;
			}
			if (die4 == 5) {
                helperInt++;
			}
			if (die5 == 5) {
                helperInt++;
			}
			fives=helperInt * 5;
			updateBonus();
			return true;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		if (sixes != -1) {
			return false;
		} else {
			int helperInt=0;
			if (die1 == 6) {
                helperInt++;
			}
			if (die2 == 6) {
                helperInt++;
			}
			if (die3 == 6) {
                helperInt++;
			}
			if (die4 == 6) {
                helperInt++;
			}
			if (die5 == 6) {
                helperInt++;
			}
			sixes=helperInt * 6;
			updateBonus();
			return true;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren�t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(threeKind!=-1) {
			return false;
		}else{
			if((first==second&&first==third)||(second==fourth&&second==third)||(third==fourth&&third==fifth)){
				threeKind = die1+die2+die3+die4+die5;
				return true;
			}else{
				threeKind = 0;
				return false;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(fourKind != -1){
			return false;
		}else{
			if((first==second&&first==third&&first==fourth)||(second==third&&second==fourth&&second==fifth)){
				fourKind = die1+die2+die3+die4+die5;
				return true;
			}else{
				fourKind = 0;
				return false;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren�t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(fullHouse!=-1){
			return false;
		}else{
			if((first==second&&first==third&&fourth==fifth)||(first==second&&third==fourth&&fourth==fifth)){
				fullHouse = 25;
				return true;
			}else{
				fullHouse = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren�t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(smStraight!=-1){
			return false;
		}else{
			if(first+1==second&&first+2==third&&first+3==fourth){
				smStraight = 30;
				return true;
			}else{
				smStraight = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(lgStraight!=-1){
			return false;
		}else{
			if(first+1==second&&first+2==third&&first+3==fourth&&first+4==fifth){
				lgStraight = 40;
				return true;
			}else{
				lgStraight = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren�t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5) {
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if (fiveKind != -1) {
			return false;
		} else {
			if (first == second && first == third && first == fourth && first == fifth) {
				fiveKind = 50;
				return true;
			} else {
				fiveKind = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice s = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		int first = s.getFirst();
		int second = s.getSecond();
		int third = s.getThird();
		int fourth = s.getFourth();
		int fifth = s.getFifth();

		if(chance != -1){
			return false;
		}else{
			chance = die1+die2+die3+die4+die5;
			return true;
		}

	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section�s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if(bonus==false) {
			if (ones + twos + threes + fours + fives + sixes >= 63) {
				bonus = true;
			} else {
				bonus = false;
			}
		}
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
        int finalUpperTotal = 0;

        if(this.ones>-1){
            finalUpperTotal+=this.ones;
        }
        if(this.twos>-1){
            finalUpperTotal+=this.twos;
        }
        if(this.threes>-1){
            finalUpperTotal+=this.threes;
        }
        if(this.fours>-1){
            finalUpperTotal+=this.fours;
        }
        if(this.fives>-1){
            finalUpperTotal+=this.fives;
        }
        if(this.sixes>-1){
            finalUpperTotal+=this.sixes;
        }
        return finalUpperTotal;
	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
        int finalLowerTotal = 0;

        if(this.threeKind>-1){
            finalLowerTotal+=this.threeKind;
        }
        if(this.fourKind>-1){
            finalLowerTotal+=this.fourKind;
        }
        if(this.fullHouse>-1){
            finalLowerTotal+=this.fullHouse;
        }
        if(this.smStraight>-1){
            finalLowerTotal+=this.smStraight;
        }
        if(this.lgStraight>-1){
            finalLowerTotal+=this.lgStraight;
        }
        if(this.fiveKind>-1){
            finalLowerTotal+=this.fiveKind;
        }
        return finalLowerTotal;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		int grandTotal = upperTotal+lowerTotal;
		return grandTotal;
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t*");
		System.out.print("*  Twos:\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t*");
		System.out.print("*  Threes:\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t*");
		System.out.print("*  Fours:\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t*");
		System.out.print("*  Fives:\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t*");
		System.out.print("*  Sixes:\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t*");
		System.out.println("*\t\t\t\t*");
		System.out.print("*  Upper Bonus:\t\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t*");
		System.out.print("*  Upper Total:\t\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t*");
		System.out.print("*  Yahtzee:\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t*");
		System.out.print("*  Chance:\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t*");
		System.out.println("**********************************");
		System.out.println();
	}


}