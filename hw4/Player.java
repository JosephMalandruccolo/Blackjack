package hw4;

/**
 * Represents a blackjack player
 * @author Joseph Malandruccolo
 *
 */
public class Player {
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================

	private String strName;
	private int nDollars;
	private int nWins;
	private int nLosses;
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
	
	public static final int DEFAULT_STARTING_MONEY = 1000;
	public static final String DEFAULT_PLAYER_NAME = "Richard M. Nixon";
	
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	/**
	 * constructor that takes a name
	 * @param strName
	 */
	Player(String strName){
		
		this.strName = strName;
		this.nDollars = DEFAULT_STARTING_MONEY;
		this.nWins = 0;
		this.nLosses = 0;
		
	}//end Player
	
	
	/**
	 * constructor that takes a name and allows for a variable amount of money in the hand
	 * @param strName
	 * @param nMoney
	 */
	Player(String strName, int nMoney){
		
		this.strName = strName;
		this.nDollars = nMoney;
		this.nWins = 0;
		this.nLosses = 0;
		
	}//end Player
	
	
	/**
	 * 
	 */
	Player(){
		
		this(DEFAULT_PLAYER_NAME);
		
	}//end Player


	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================
	
	
	public String getName() {return strName;}


	public void setName(String name) {strName = name;}


	public int getDollars() {return nDollars;}


	public void setDollars(int dollars) {nDollars = dollars;}


	public int getWins() {return nWins;}


	public void incrementWins() {nWins++;}


	public int getLosses() {return nLosses;}


	public void incrementLosses() {nLosses++;}
	
	public void incrementDollars(int nBet){this.nDollars += nBet;}
	
	public void decrementDollars(int nBet){this.nDollars -= nBet;}
	
	
	
}//end player
