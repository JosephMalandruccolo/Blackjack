

public class BlackJackMVC {

	/**
	 * a main method for a blackjack game
	 * @param args
	 */
	public static void main(String[] args) {
		
		BlackJackModel model = new BlackJackModel();
		BlackJackView view = new BlackJackView();
		BlackJackController controller = new BlackJackController(model, view);
		
	}//end main
	
	
	

}//end BlackJackMVC
