package hw4;

import hw4.Card.Suit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Represents the dealer's shoe
 * CHANGE THE ARRAYLIST<CARD> TO A LINKEDLIST<CARD>, PROVIDED WE CAN SHUFFLE A LINKED LIST, ELSE, CONSIDER CONVERTING ARRAYLIST TO LINKED LIST
 * @author Joseph Malandruccolo
 * @author Adam Gerber
 *
 */
public class Shoe {
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================

	public final static int NUM_SUITS = 4;
	public final static int NUM_CARDS_PER_DECK = 52;
	public final static int DEFAULT_NUM_DECKS = 6;
	
	
	
	//===============================================================================================
	//										PROPERTIES
	//===============================================================================================
	
	private int nDecks;				//number of decks in the shoe
	private int nCardsRemaining;	//number of cards remaining in the shoe before we re-shuffle
	private LinkedList<Card> Cards;	//ordered list of cards in the shoe
	
	
	
	//===============================================================================================
	//											CONSTRUCTORS
	//===============================================================================================
	
	/**
	 * constructor
	 * @param nDecks - number of decks to use
	 */
	public Shoe(int nDecks){
		
		//set the number of decks
		this.nDecks = nDecks;
		
		//get a random value in the middle third of the deck
		Random rand = new Random();
		int nOneThird = nDecks * NUM_CARDS_PER_DECK / 3;
		this.nCardsRemaining = rand.nextInt(nOneThird) + (nOneThird);
		
		//generate the cards
		Cards = new LinkedList<Card>();
		
		//list of card values to add
		char[] cCards = {
				
				'2',
				'3',
				'4',
				'5',
				'6',
				'7',
				'8',
				'9',
				'T',
				'J',
				'Q',
				'K',
				'A'
				
		};//end cCards
		
		//load the cards
		Suit[] Suits = Suit.values();
		
		//for each deck
		for(int j = 0; j < this.nDecks; j++){
			//for each Suit
			for(int nS = 0; nS < Suits.length; nS++){
				//for each card in a suit
				for(int nCrds = 0; nCrds < cCards.length; nCrds++){
					this.Cards.addFirst(new Card(Suits[nS], cCards[nCrds]));
				}//end inner-for
			}//end outer-for
		}//end outer-for
		
		
		
		//shuffle the cards
		Collections.shuffle(this.Cards);
		
		//emulate the yellow marker card by removing the last k cards in the deck where k is some value in the middle third of the deck
		//used for development purposes
		//for(int nRem = this.Cards.size(); nRem > nCardsRemaining; nRem--) this.Cards.removeLast();
		
	}//end default constructor
	
	
	/**
	 * overloaded constructor
	 * assumes DEFAULT_NUM_DECKS
	 */
	public Shoe(){
		this(DEFAULT_NUM_DECKS);
	}//end overloaded constructor
	
	
	//===============================================================================================
	//											METHODS
	//===============================================================================================
	
	/**
	 * returns the next card in the shoe and removes that card from the shoe
	 * @return
	 */
	public Card dealCard(){
		
		Card crdDealt = this.Cards.getFirst();
		this.Cards.removeFirst();
		this.nCardsRemaining--;
		
		return crdDealt;
		
	}//end dealCard
	
	//===============================================================================================
	//											GETTERS
	//===============================================================================================


	public int getDecks() {
		return nDecks;
	}


	public int getCardsRemaining() {
		return nCardsRemaining;
	}
	

}//end Shoe
