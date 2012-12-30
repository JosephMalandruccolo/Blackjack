

/**
 * Model representing a blackjack game consisting of one player verses the house
 * @author Joseph Malandruccolo
 *
 */
public class BlackJackModel {
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================

	private Shoe tableShoe;
	private Hand playerHand;
	private Hand dealerHand;
	private Player humanPlayer;
	
	
	
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
	
	//value of a blackjack in first two cards, with ace high
	private final int BLACKJACK_VALUE = 21;
	
	
	//dealer must hit until a soft 17
	private final int DEALER_HIT_VALUE = 17;
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	/**
	 * two parameter constructor, takes a pre-constructed shoe Object and a player
	 * @param plrHuman - the player
	 * @param shoHouse - the shoe, constructed outside the model
	 */
	BlackJackModel(Player plrHuman, Shoe shoHouse){
		
		this.humanPlayer = plrHuman;
		this.tableShoe = shoHouse;
		this.playerHand = new Hand();
		this.dealerHand = new Hand();
		
	}//end constructor
	
	/**
	 * default constructor, creates a default player and default shoes
	 */
	BlackJackModel(){
		
		this(new Player(), new Shoe());
		
	}//end constructor
	
	
	
	
	//===============================================================================================
	//											GAME METHODS
	//===============================================================================================
	
	//-------------------------automatic methods---------------------------------
	
	/**
	 * pass out cards to the player and dealer
	 * @return true if the dealer was dealt a blackjack, false otherwise
	 */
	public boolean dealHand(){
		
		this.playerHand.addCard(this.tableShoe.dealCard());
		this.dealerHand.addCard(this.tableShoe.dealCard());
		this.playerHand.addCard(this.tableShoe.dealCard());
		this.dealerHand.addCard(this.tableShoe.dealCard());
		
		return isDealerBlackJack();
		
	}//end dealHand
	
	
	/**
	 * finishes playing out a dealer hand after the player's turn
	 * @return the dealer's final hand
	 */
	public Hand playDealerHand(){
		
		//always hit when the high value is less than 17, hit when the low value is less than 17 ONLY when the high value is a bust
		while(this.dealerHand.getValue()[1] <= DEALER_HIT_VALUE || (this.dealerHand.getValue()[0] < DEALER_HIT_VALUE && this.dealerHand.getValue()[1] > BLACKJACK_VALUE)){
			
			this.dealerHand.addCard(this.tableShoe.dealCard());
			
		}//end while
		
		return this.getDealerHand();
		
	}//end playDealerHand
	
	
	/**
	 * determines whether or not a given hand is a bust
	 * logic is that the lowest possible value of the hand must be greater than 21
	 * @param hand - a given hand of blackjack
	 * @return true if the hand is a bust, false otherwise
	 */
	public boolean isBust(Hand hand) {return hand.getValue()[0] > 21;}
	
	
	/**
	 * checks if the dealer has been dealt a BlackJack
	 * a dealer has a blackjack if it's high ace score is 21
	 * @return true if the dealer has a BlackJack, false otherwise
	 */
	public boolean isPlayerBlackJack() {return this.playerHand.getValue()[1] == BLACKJACK_VALUE;}
	
	
	/**
	 * determines the highest non-busting blackjack score in the players hand and the dealers hand
	 * returns an int, using logic similar to the compareTo method
	 * @return a negative number if the dealer wins, zero on push, and a positive number if the player wins
	 */
	public int winner(){
		
		int nPlayerHandVal = getHighestNonBustScore(this.playerHand);
		int nDealerHandVal = getHighestNonBustScore(this.dealerHand);
		
		return nPlayerHandVal - nDealerHandVal;
		
	}//end winner
	
	
	/**
	 * clears hands in prep for next round
	 */
	public void clearHands(){
		this.playerHand = new Hand();
		this.dealerHand = new Hand();
	}//end clearHands
	
	
	//-----------------------------sentinel methods-------------------------------------------
	
	/**
	 * add a card to the player's hand from the shoe
	 */
	public void playerHits() {this.playerHand.addCard(this.tableShoe.dealCard());}
	
	
	/**
	 * 
	 * @return the player's final hand
	 */
	public Hand playerStays() {return this.getPlayerHand();}
	
	
	/**
	 * player takes one card and then the hand is finished
	 * @return the player's final hand
	 */
	public Hand doubleDown(){
		
		this.playerHand.addCard(this.tableShoe.dealCard());
		return this.playerHand;
		
	}//end doubleDown
	
	
	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================
	
	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public Player getHumanPlayer() {
		return humanPlayer;
	}

	public void setHumanPlayer(Player humanPlayer) {
		this.humanPlayer = humanPlayer;
	}
	
	/**
	 * @return - the number of cards left in the shoe
	 */
	public int getNumCardsRemaining(){return this.tableShoe.getCardsRemaining();}
	
	/**
	 * instantiate a new shoe for the tableShoe property
	 */
	public void setNewShoe(){
		
		this.tableShoe = new Shoe();
		
	}//end setNewShoe
	
	
	
	
	//===============================================================================================
	//											HELPERS
	//===============================================================================================
	
	/**
	 * checks if the dealer has been dealt a BlackJack
	 * a dealer has a blackjack if it's high ace score is 21
	 * @return true if the dealer has a BlackJack, false otherwise
	 */
	private boolean isDealerBlackJack() {return this.dealerHand.getValue()[1] == BLACKJACK_VALUE;}
	
	
	/**
	 * @param hnd - a given hand of blackjack
	 * @return the highest possible score in a hand that is less than or equal to 21
	 */
	private int getHighestNonBustScore(Hand hnd){
		
		if(hnd.getValue()[1] <= 21) return hnd.getValue()[1];
		else return hnd.getValue()[0];
		
	}//end highestNon
	

}//end BlackJack model






