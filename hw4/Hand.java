package hw4;

import java.util.ArrayList;

/**
 * represents a hand of cards
 * @author Joseph Malandruccolo
 * @author Adam Gerber
 *
 */
public class Hand {

	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================
	
	private ArrayList<Card> crdsHand;	//holds the value of cards
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	/**
	 * initializes the crdsHand property
	 */
	public Hand() {this.crdsHand = new ArrayList<Card>();}

	
	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================

	/**
	 * get a hand
	 * @return a list of cards
	 */
	public ArrayList<Card> getCards() {return this.crdsHand;}


	/**
	 * set a hand
	 * @param an ArrayList<Card>
	 */
	public void setCards(ArrayList<Card> crdsHand) {this.crdsHand = crdsHand;}
	
	
	
	//===============================================================================================
	//											GAME METHODS
	//===============================================================================================
	
	/**
	 * Calculates the value in the hand, implement ambiguous aces
	 * @return nVal
	 */
	public int[] getValue(){
		
		int nAces = 0;			//number of aces encountered thus far
		int nHighAce = 0;		//score if there exists a high ace
		int nLowAce = 0;		//score if all aces are low aces
		
		//------------------compute the high ace score
		//iterate through all except ace
		for(Card crd : this.crdsHand) {
			
			//if we are not dealing with an Ace, add the value
			if(crd.getcFace() != 'A'){
				nLowAce += crd.getcFaceValue();
				nHighAce += crd.getcFaceValue();
			}
			//if the card is an ace
			else{ 
				nLowAce += 1;
				
				//high aces
				if(nAces < 1){
					nHighAce += 11;
					nAces++;
				}
				else nHighAce += 1;
			}//end if-else
		}//end for-each
		
		return new int[]{nLowAce, nHighAce};
		
	}//end getValue
	
	
	/**
	 * adds a card to the hand
	 * @param crd - the card Object to add
	 */
	public void addCard(Card crd) {this.crdsHand.add(crd);}
	
	
	//===============================================================================================
	//											OVERRIDE [from Object]
	//===============================================================================================
	
	@Override
	public String toString(){
		
		String strReturned = "";
		
		for(int n = 0; n < this.crdsHand.size(); n++){
			strReturned += this.crdsHand.get(n).toString();
			
			if(n < this.crdsHand.size() - 1) strReturned += " | ";
		}//end for
		
		return strReturned;
		
	}//end toString
	
}//end Hand
