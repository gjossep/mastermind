package nl.gjosse.game;
import java.util.ArrayList;
import java.util.Random;


public class Game {
	private int numPeg, numColours;
	private ArrayList<Integer> values = new ArrayList<Integer>();
	private ArrayList<Integer> answer = new ArrayList<Integer>();
	private ArrayList<Integer> bannedNum = new ArrayList<Integer>();
	
	Random ran = new Random();
	
	/*
	 * Constructor
	 * Pre: Needs a amount of pegs and colours for each peg
	 * Post: Makes a random answer and sets vairbles
	 */
	public Game(int numPeg, int numColours) {
		this.numPeg = numPeg;
		this.numColours = numColours;
		
		for(int i=1; i<=numPeg; i++) {
			int random = ran.nextInt(numColours)+1;
			System.out.println(random);
			answer.add(new Integer(random));
		}
	}

	/*
	 * Adds a value to the arrayList value.
	 * Pre: Needs a integer
	 * Post: Adds a value to the list
	 */
	public void addToPegs(int peg) {
		values.add(new Integer(peg));
	}

	/*
	 * Makes a string of the answer in the form of "You have ~ peg<s> correct and ~ colour<s> correct.
	 * Pre: None
	 * Post: A string with the amount of pegs with the right colour and location.
	 */
	public String getAnswerString() {
		int correctPlace = 0;
		int correctColour = 0;
		
		for(int i = 1; i<=numPeg; i++) {
			int firstNumPeg = values.get(i-1).intValue();
			int firstNumAnswer = answer.get(i-1).intValue();
			if(firstNumPeg == firstNumAnswer) {
				correctPlace++;
				bannedNum.add(firstNumPeg);
			}
		}
		
		for(Integer i : values) {
			if(answer.contains(i) && !(bannedNum.contains(i))) {
				correctColour++;
				bannedNum.add(i);
			}
		}
		return "You have "+correctPlace+" peg<s> correct and "+correctColour+" colour<s> correct.";
	}

	/*
	 * Gives a boolean answer to see if the values the user gave is the same as the answer.
	 * Pre: None
	 * Post: A boolean to see it its the right answer.
	 */
	public boolean checkAnswer() {
		int correctPlace = 0;
		
		for(int i = 1; i<=numPeg; i++) {
			int firstNumPeg = values.get(i-1).intValue();
			int firstNumAnswer = answer.get(i-1).intValue();
			if(firstNumPeg == firstNumAnswer) {
				correctPlace++;
			}
		}
		
		
		if(correctPlace==numPeg) {
			return true;
		}
		
		return false;
	}

	/*
	 * Clears the values and bannedNums arrayList
	 * pre: None
	 * Post: Clear the values and bannedNum arrayList
	 */
	public void clear() {
		values.clear();
		bannedNum.clear();
	}


}
