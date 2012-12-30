

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class that listens for a player to press 'double'
 * @author Joseph Malandruccolo
 *
 */
public class DoubleListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {BlackJackController.playerDoubles();}

}//end DoubleListener
