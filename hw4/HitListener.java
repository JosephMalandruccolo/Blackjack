package hw4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * class that listens for the player to hit and passes this information to the Controller
 * @author Joseph Malandruccolo
 *
 */
public class HitListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {BlackJackController.playerHits();}

}//end HitListener
