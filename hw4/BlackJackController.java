

public class BlackJackController {
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================

	private static BlackJackModel controlModel;
	private static BlackJackView controlView;
	private static final int DEFAULT_BET = 100;
	private static final int BLACKJACK_BONUS = 50;
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	/**
	 * controller for a BlackJack game
	 * @param model - Blackjack Model
	 * @param view - Blackjack GUI
	 */
	public BlackJackController(BlackJackModel model, BlackJackView view){
		
		//assign static vars
		controlModel = model;
		controlView = view;
		
		//deal a hand, update the view, show the view
		boolean bDealerHasBJ = controlModel.dealHand();
		boolean bPlayerHasBJ = controlModel.isPlayerBlackJack();
		initializeView(controlModel, controlView);
		view.getFrame().setVisible(true);
		
		//check for blackjack outcomes
		if(bDealerHasBJ && bPlayerHasBJ) showPush();
		if(bDealerHasBJ && !bPlayerHasBJ) showDealerBlackjack();
		if(!bDealerHasBJ && bPlayerHasBJ) showPlayerBlackjack();
		
	}//end constructor
	
	
	
	//===============================================================================================
	//											UPDATE VIEW METHODS
	//===============================================================================================
	
	


	/**
	 * method to initialize a given view
	 * set a player
	 * clear the prior results
	 * clear the prior cards
	 * set the dealer's up card
	 * set the player's hand
	 * @param model - a model
	 * @param view - a view
	 */
	private static void initializeView(BlackJackModel model, BlackJackView view){
		
		view.setPlayer();
		view.clearGameResult();
		view.clearCards();
		view.setDealerUpCard(model.getDealerHand().getCards().get(0));
		view.setPlayerHand(model.getPlayerHand());
		
		view.updatePlayerValue(model.getPlayerHand().getValue());
		
	
	}//end updateView
	
	
	/**
	 * update the money to reflect a player loss
	 * status that reflects the player has busted
	 * show a deal button
	 */
	private static void showPlayerBusts(){
		
		controlModel.getHumanPlayer().decrementDollars(DEFAULT_BET);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.setDealerHand(controlModel.getDealerHand());
		controlView.showPlayerBusts();
		controlView.showDealBtn();
		
	}//end showPlayerBusts
	
	
	/**
	 * update the money to reflect a player win
	 * status that reflects the dealer busts
	 * show the deal button
	 */
	private static void showDealerBusts(){
		
		controlModel.getHumanPlayer().incrementDollars(DEFAULT_BET);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.showDealerBusts();
		controlView.showDealBtn();
		
	}//end showDealerBusts
	
	
	/**
	 * update the money to show a player loss
	 * show the result of a dealer blackjack
	 * two possible results
	 * 1) a push if the player has blackjack
	 * 2) a player loss
	 */
	private static void showDealerBlackjack(){
		
		controlModel.getHumanPlayer().decrementDollars(DEFAULT_BET);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.setDealerHand(controlModel.getDealerHand());
		controlView.showDealerBlackjack();
		controlView.showDealBtn();
		
	}//end showDealerBlackJack
	
	
	/**
	 * show the dealer's hand
	 * show the result
	 */
	private static void showPush(){
		
		controlView.setDealerHand(controlModel.getDealerHand());
		
		controlView.showPush();
		controlView.showDealBtn();
		
	}//end showPush
	
	
	/**
	 * pay the player the bet and bonus
	 * display a player blackjack
	 */
	private static void showPlayerBlackjack(){
		
		controlModel.getHumanPlayer().incrementDollars(DEFAULT_BET + BLACKJACK_BONUS);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.setDealerHand(controlModel.getDealerHand());
		controlView.showPlayerBlackjack();
		controlView.showDealBtn();
		
	}//end showPlayerBlackjack
	
	
	/**
	 * pay the player
	 * show the result
	 */
	private static void showPlayerWins(){
		
		controlModel.getHumanPlayer().incrementDollars(DEFAULT_BET);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.showPlayerWins();
		controlView.showDealBtn();
		
	}//end showPlayerWins
	
	
	/**
	 * pay the house
	 * show the result
	 */
	private static void showDealerWins(){
		
		controlModel.getHumanPlayer().decrementDollars(DEFAULT_BET);
		controlView.updateMoney(controlModel.getHumanPlayer().getDollars());
		
		controlView.showDealerWins();
		controlView.showDealBtn();
		
	}//end showDealerWins
	
	
	
	
	
	
	
	
	//===============================================================================================
	//											BLACKJACK METHODS
	//===============================================================================================
	
	
	/**
	 * cascade when playerDoubles()
	 * player hits
	 * view updates
	 * if the hit is not a bust, the player stays
	 * the result needs to be calculated twice
	 */
	public static void playerDoubles(){
		
		playerHits();
		if(!controlModel.isBust(controlModel.getPlayerHand())) playerStays();
		if(!controlModel.isBust(controlModel.getPlayerHand())) playerStays();
		else showPlayerBusts();
		
		
	}//end playerDoubles
	
	
	/**
	 * cascade when player hits
	 * model hits
	 * view updates
	 * if the hit is a bust, show the bust screen
	 */
	public static void playerHits(){
		
		controlModel.playerHits();
		controlView.setPlayerHand(controlModel.getPlayerHand());
		controlView.updatePlayerValue(controlModel.getPlayerHand().getValue());
		controlView.hideDoubleBtn();
		if(controlModel.isBust(controlModel.getPlayerHand())) showPlayerBusts();
		
	}//end playerHits
	

	
	/**
	 * cascade when player stays
	 */
	public static void playerStays() {
		
		boolean bDealerBusts = controlModel.isBust(controlModel.playDealerHand());
		controlView.setDealerHand(controlModel.getDealerHand());
		
		if(bDealerBusts) showDealerBusts();
		else{
			
			int nWinner = controlModel.winner();
			
			if(nWinner == 0) showPush();
			if(nWinner > 0) showPlayerWins();
			if(nWinner < 0) showDealerWins();
			
		}//end else
	}//end playerStays
	
	
	
	
	/**
	 * cascade when a new hand is dealt
	 * muck the cards
	 * deal a new hand
	 * update the view
	 * hide the deal button
	 */
	public static void dealNewHand(){
		
		int nCardsLeft = controlModel.getNumCardsRemaining();
		System.out.println(nCardsLeft);
		if(nCardsLeft <= 0) controlModel.setNewShoe();
		
		System.out.println();
		
		controlModel.clearHands();
		boolean bDealerHasBJ = controlModel.dealHand();
		boolean bPlayerHasBJ = controlModel.isPlayerBlackJack();
		initializeView(controlModel, controlView);
		controlView.hideDealBtn();
		controlView.showDoubleBtn();
		
		//check for blackjack outcomes
		if(bDealerHasBJ && bPlayerHasBJ) showPush();
		if(bDealerHasBJ && !bPlayerHasBJ) showDealerBlackjack();
		if(!bDealerHasBJ && bPlayerHasBJ) showPlayerBlackjack();
		
	}//end dealNewHand
	
}//end BlackJackController
