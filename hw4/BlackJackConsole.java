

import java.util.Scanner;

public class BlackJackConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//variable to store whether or not to quit
		boolean bQuit = false;
		
		//implement one blackjack hand
		BlackJackModel model = new BlackJackModel();
		
		//if we're playing the hand, play the hand
		//otherwise, show dealer blackjack
		if(!model.dealHand()){
			
			Hand hdFinalPlayerHand = null;
			while(hdFinalPlayerHand == null){
				
				System.out.println("Player :"+model.getPlayerHand().getValue()[0]+"/"+model.getPlayerHand().getValue()[1]);
				System.out.println("'H' to hit, 'S' to stay");
				Scanner scan = new Scanner(System.in);
				String strChoice = scan.next();
				
				if(strChoice.equals("H")) model.playerHits();
				if(strChoice.equals("S")) hdFinalPlayerHand = model.getPlayerHand();
				
				
			}
			
			System.out.println("Final player value: "+hdFinalPlayerHand.getValue()[0]+" / "+hdFinalPlayerHand.getValue()[1]);
			System.out.println(model.getPlayerHand());
			System.out.println();
			model.playDealerHand();
			System.out.println("Final dealer value: "+model.getDealerHand().getValue()[0]+" / "+model.getDealerHand().getValue()[1]);
			System.out.println(model.getDealerHand());
			
			
			
		}
		else{
			System.out.println(model.getDealerHand());
			System.out.println(model.getDealerHand().getValue()[1]);
		}
		
		

	}

}
