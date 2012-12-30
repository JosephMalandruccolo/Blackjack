

import java.util.HashMap;
import java.util.Map;



/**
 * represents a card from a standard playing card deck
 * @author Joseph Malandruccolo
 * @author Adam Gerber
 *
 */
public class Card {
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================

	
	private Suit mySuit;	//this card's suit
	private char cFace;		//this card's face (i.e. a number 2-10, J,Q,K,A)
	
	
	
	//---------------------------------------	PROPERTY DEFINITIONS
	//variable to represent the card's suit
	enum Suit{
		
		SPADES("S"), HEARTS("H"), CLUBS("C"), DIAMONDS("D");
		
		private String abbreviation;
		
		private Suit(String abbreviation) {this.abbreviation = abbreviation;}
		public String getAbbreviation() {return this.abbreviation;}
		
		
	}//end Suit

	
	
	//face map to int values
	private static Map<Character, Integer> faceMap = new HashMap<Character, Integer>();
	static{
		
		//numbers and royalty
		faceMap.put('2', 2);
		faceMap.put('3', 3);
		faceMap.put('4', 4);
		faceMap.put('5', 5);
		faceMap.put('6', 6);
		faceMap.put('7', 7);
		faceMap.put('8', 8);
		faceMap.put('9', 9);
		faceMap.put('T', 10);
		faceMap.put('J', 10);
		faceMap.put('Q', 10);
		faceMap.put('K', 10);
		//aces, H is the high value ace (11), L is the low value ace (1), each instance of an Ace is calculated as either 11 or 1
		faceMap.put('A', 0);
		faceMap.put('H', 11);
		faceMap.put('L', 1);
			
	}//end static
	
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	/**
	 * Takes a character representing the face (see faceMap property) and a Suit
	 * @param s - this card's Suit
	 * @param c - this card's Face
	 */
	public Card(Suit s, char c){
		
		this.mySuit = s;
		this.cFace = c;
		
	}//end const


	
	
	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================
	
	//mySuit----------------
	public Suit getSuit() {return mySuit;}
	public void setSuit(Suit mySuit) {this.mySuit = mySuit;}
	
	//cFace-----------------
	public char getcFace() {return cFace;}
	public void setcFace(char cFace) {this.cFace = cFace;}
	
	//faceMap--------------- [static access]
	public int getcFaceValue() {return Card.faceMap.get(this.cFace);}
	
	
	
	//===============================================================================================
	//											OVERRIDE [from Object]
	//===============================================================================================
	
	@Override
	//e.g. "K : 10"
	public String toString(){return this.getSuit()+" | "+this.getcFace()+" | "+this.getcFaceValue();}
	
	
}//end Card



