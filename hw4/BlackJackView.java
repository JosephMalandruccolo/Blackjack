

import hw4.Card.Suit;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * a GUI for a blackjack game
 * @author Joseph Malandruccolo
 *
 */
public class BlackJackView {
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
	
	//prefix of the path for the image files
	private final String RELATIVE_PATH_PREFIX = "/hw4/";
	
	//extension of the path for the image files
	private final String FILE_SUFFIX = ".gif";
	
	//text shown on end of game situations
	private final String PLAYER_BUSTS = "Player Busts :-(";
	private final String DEALER_BUSTS = "Dealer Busts!";
	private final String PLAYER_WINS = "Player Wins!";
	private final String DEALER_WINS = "Dealer Wins :-(";
	private final String DEALER_BLACKJACK = "Dealer Blackjack";
	private final String PLAYER_BLACKJACK = "Player Blackjack";
	private final String PUSH = "Push";
	private final String PUSH2 = "No blood!";
	private final String POSITIVE_RESULT = "Nice work!";
	private final String NEGATIVE_RESULT = "You lost...";
	
	
	
	
	
	//===============================================================================================
	//											STATIC PROPERTIES
	//===============================================================================================

	/**
	 * maps a suit to the image file name prefix, used to facilitate changing images
	 */
	private static Map<Suit, String> suitMap = new HashMap<Suit, String>();
	static{
		
		suitMap.put(Suit.SPADES, "s");
		suitMap.put(Suit.HEARTS, "h");
		suitMap.put(Suit.DIAMONDS, "d");
		suitMap.put(Suit.CLUBS, "c");
		
	}//end static
	
	
	/**
	 * maps the value of a card to the image file name suffix, used to facilitate changing images
	 */
	private static Map<Character, String> valueMap = new HashMap<Character, String>();
	static{
		
		valueMap.put('2', "2");
		valueMap.put('3', "3");
		valueMap.put('4', "4");
		valueMap.put('5', "5");
		valueMap.put('6', "6");
		valueMap.put('7', "7");
		valueMap.put('8', "8");
		valueMap.put('9', "9");
		valueMap.put('T', "10");
		valueMap.put('J', "j");
		valueMap.put('Q', "q");
		valueMap.put('K', "k");
		valueMap.put('A', "1");
		
	}//end static
	
	
	
	
	//===============================================================================================
	//											PROPERTIES - VIEW OBJECTS
	//===============================================================================================
	
	private JFrame frmBlackjack;
	private JLayeredPane layeredPane;
	
	//--------Dealer Cards
	private JPanel panDealerCard14;
	private JPanel panDealerCard13;
	private JPanel panDealerCard12;
	private JPanel panDealerCard11;
	private JPanel panDealerCard10;
	private JPanel panDealerCard9;
	private JPanel panDealerCard8;
	private JPanel panDealerCard7;
	private JPanel panDealerCard6;
	private JPanel panDealerCard5;
	private JPanel panDealerCard4;
	private JPanel panDealerCard3;
	private JPanel panDealerDownCard;
	private JPanel panDealerUpCard;
	private JLabel lblDealerCard14;
	private JLabel lblDealerCard13;
	private JLabel lblDealerCard12;
	private JLabel lblDealerCard11;
	private JLabel lblDealerCard10;
	private JLabel lblDealerCard9;
	private JLabel lblDealerCard8;
	private JLabel lblDealerCard7;
	private JLabel lblDealerCard6;
	private JLabel lblDealerCard5;
	private JLabel lblDealerCard4;
	private JLabel lblDealerCard3;
	private JLabel lblDealerDownCard;
	private JLabel lblDealerUpCard;
	
	//------Player Cards
	private JPanel panPlayerCard14;
	private JPanel panPlayerCard13;
	private JPanel panPlayerCard12;
	private JPanel panPlayerCard11;
	private JPanel panPlayerCard10;
	private JPanel panPlayerCard9;
	private JPanel panPlayerCard8;
	private JPanel panPlayerCard7;
	private JPanel panPlayerCard6;
	private JPanel panPlayerCard5;
	private JPanel panPlayerCard4;
	private JPanel panPlayerCard3;
	private JPanel panPlayerCard2;
	private JPanel panPlayerCard1;
	private JLabel lblPlayerCard14;
	private JLabel lblPlayerCard13;
	private JLabel lblPlayerCard12;
	private JLabel lblPlayerCard11;
	private JLabel lblPlayerCard10;
	private JLabel lblPlayerCard9;
	private JLabel lblPlayerCard8;
	private JLabel lblPlayerCard7;
	private JLabel lblPlayerCard6;
	private JLabel lblPlayerCard5;
	private JLabel lblPlayerCard4;
	private JLabel lblPlayerCard3;
	private JLabel lblPlayerCard2;
	private JLabel lblPlayerCard1;
	
	//------game status and player status
	private JLabel lblGameResult;
	private JLabel lblBustResult;
	private JPanel panPlayerStatus;
	private JLabel lblPlayerName;
	private JLabel lblPlayerMoney;
	private JPanel panGameControls;
	private JPanel panDeal;
	private JPanel panGameResult;
	private JPanel panPlayerValue;
	private JLabel lblPlayerValue;
	
	private JButton btnDouble;

	
	
	
	
	//===============================================================================================
	//											DEFAULT LAUNCHER - TO BE DELETED
	//===============================================================================================

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJackView window = new BlackJackView();
					window.frmBlackjack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================

	/**
	 * Create the application.
	 */
	public BlackJackView() {
		initialize();
	}
	
	
	public BlackJackView(BlackJackModel model) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//===============================================================================================
		//											FRAME
		//===============================================================================================
		
		frmBlackjack = new JFrame();
		frmBlackjack.setResizable(false);
		frmBlackjack.setTitle("BlackJack\n");
		frmBlackjack.setBounds(0, 0, 600, 449);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		layeredPane = new JLayeredPane();
		frmBlackjack.getContentPane().add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 0, 600, 449);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(BlackJackView.class.getResource("/hw4/bjTable.jpg")));
		
		
		//===============================================================================================
		//											COLORS
		//===============================================================================================
		
		Color clrTransparent = new Color(0, 0, 0, 0);
		Color clrMaroon = new Color(225, 0, 0);
		
		
		
	
		
		
		
		//===============================================================================================
		//											DEALER'S CARDS
		//===============================================================================================
		
		//-------up card
		panDealerUpCard = new JPanel();
		panDealerUpCard.setBounds(200, 90, 71, 96);
		layeredPane.add(panDealerUpCard, new Integer(1));
		panDealerUpCard.setLayout(new BorderLayout(0, 0));
		
		lblDealerUpCard = new JLabel();
		lblDealerUpCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerUpCard.setVerticalAlignment(SwingConstants.TOP);
		lblDealerUpCard.setIcon(new ImageIcon(BlackJackView.class.getResource("/hw4/s1.gif")));
		panDealerUpCard.add(lblDealerUpCard);
		
		
		//-------down card
		panDealerDownCard = new JPanel();
		panDealerDownCard.setBounds(235, 90, 71, 96);
		layeredPane.add(panDealerDownCard, new Integer(2));
		panDealerDownCard.setLayout(new BorderLayout(0, 0));
		
		lblDealerDownCard = new JLabel("");
		lblDealerDownCard.setIcon(new ImageIcon(BlackJackView.class.getResource("/hw4/b2fv.gif")));
		panDealerDownCard.add(lblDealerDownCard);
		
		//------------Card 3
		panDealerCard3 = new JPanel();
		panDealerCard3.setBounds(270, 90, 71, 96);
		panDealerCard3.setOpaque(false);
		layeredPane.add(panDealerCard3, new Integer(3));
		panDealerCard3.setLayout(new BorderLayout(0, 0));
		
		lblDealerCard3 = new JLabel("");
		panDealerCard3.add(lblDealerCard3);
		
		
		//-----------Card 4
		panDealerCard4 = new JPanel();
		panDealerCard4.setBounds(305, 90, 71, 96);
		panDealerCard4.setOpaque(false);
		layeredPane.add(panDealerCard4, new Integer(4));
		panDealerCard4.setLayout(new BorderLayout(0, 0));
		
		lblDealerCard4 = new JLabel("");
		panDealerCard4.add(lblDealerCard4);
		
		
		
		//-----------Card 5
		panDealerCard5 = new JPanel();
		panDealerCard5.setBounds(340, 90, 71, 96);
		panDealerCard5.setOpaque(false);
		layeredPane.add(panDealerCard5, new Integer(5));
		panDealerCard5.setLayout(new BorderLayout(0, 0));
				
		lblDealerCard5 = new JLabel("");
		panDealerCard5.add(lblDealerCard5);
		
		
		//-----------Card 6
		panDealerCard6 = new JPanel();
		panDealerCard6.setBounds(375, 90, 71, 96);
		panDealerCard6.setOpaque(false);
		layeredPane.add(panDealerCard6, new Integer(6));
		panDealerCard6.setLayout(new BorderLayout(0, 0));
						
		lblDealerCard6 = new JLabel("");
		panDealerCard6.add(lblDealerCard6);
		
		
		//-----------Card 7
		panDealerCard7 = new JPanel();
		panDealerCard7.setBounds(410, 90, 71, 96);
		panDealerCard7.setOpaque(false);
		layeredPane.add(panDealerCard7, new Integer(7));
		panDealerCard7.setLayout(new BorderLayout(0, 0));
								
		lblDealerCard7 = new JLabel("");
		panDealerCard7.add(lblDealerCard7);
		
		
		
		//-----------Card 8
		panDealerCard8 = new JPanel();
		panDealerCard8.setBounds(200, 120, 71, 96);
		panDealerCard8.setOpaque(false);
		layeredPane.add(panDealerCard8, new Integer(8));
		panDealerCard8.setLayout(new BorderLayout(0, 0));
										
		lblDealerCard8 = new JLabel("");
		panDealerCard8.add(lblDealerCard8);
		
		
		//-----------Card 9
		panDealerCard9 = new JPanel();
		panDealerCard9.setBounds(235, 120, 71, 96);
		panDealerCard9.setOpaque(false);
		layeredPane.add(panDealerCard9, new Integer(9));
		panDealerCard9.setLayout(new BorderLayout(0, 0));
												
		lblDealerCard9 = new JLabel("");
		panDealerCard9.add(lblDealerCard9);
		
		
		//-----------Card 10
		panDealerCard10 = new JPanel();
		panDealerCard10.setBounds(270, 120, 71, 96);
		panDealerCard10.setOpaque(false);
		layeredPane.add(panDealerCard10, new Integer(10));
		panDealerCard10.setLayout(new BorderLayout(0, 0));
														
		lblDealerCard10 = new JLabel("");
		panDealerCard10.add(lblDealerCard10);
		
		
		//-----------Card 11
		panDealerCard11 = new JPanel();
		panDealerCard11.setBounds(305, 120, 71, 96);
		panDealerCard11.setOpaque(false);
		layeredPane.add(panDealerCard11, new Integer(11));
		panDealerCard11.setLayout(new BorderLayout(0, 0));
																
		lblDealerCard11 = new JLabel("");
		panDealerCard11.add(lblDealerCard11);
		
		
		//-----------Card 12
		panDealerCard12 = new JPanel();
		panDealerCard12.setBounds(340, 120, 71, 96);
		panDealerCard12.setOpaque(false);
		layeredPane.add(panDealerCard12, new Integer(12));
		panDealerCard12.setLayout(new BorderLayout(0, 0));
																		
		lblDealerCard12 = new JLabel("");
		panDealerCard12.add(lblDealerCard12);
		
		
		//-----------Card 13
		panDealerCard13 = new JPanel();
		panDealerCard13.setBounds(375, 120, 71, 96);
		panDealerCard13.setOpaque(false);
		layeredPane.add(panDealerCard13, new Integer(13));
		panDealerCard13.setLayout(new BorderLayout(0, 0));
																				
		lblDealerCard13 = new JLabel("");
		panDealerCard13.add(lblDealerCard13);
		
		
		//-----------Card 14
		panDealerCard14 = new JPanel();
		panDealerCard14.setBounds(410, 120, 71, 96);
		panDealerCard14.setOpaque(false);
		layeredPane.add(panDealerCard14, new Integer(14));
		panDealerCard14.setLayout(new BorderLayout(0, 0));
																						
		lblDealerCard14 = new JLabel("");
		panDealerCard14.add(lblDealerCard14);
		
		
		
		
		//===============================================================================================
		//											PLAYER'S CARDS
		//===============================================================================================
		
		//-----------Card 1
		panPlayerCard1 = new JPanel();
		panPlayerCard1.setBounds(200, 265, 71, 96);
		panPlayerCard1.setOpaque(false);
		layeredPane.add(panPlayerCard1, new Integer(1));
		panPlayerCard1.setLayout(new BorderLayout(0, 0));
		
		lblPlayerCard1 = new JLabel("");
		panPlayerCard1.add(lblPlayerCard1);
		
		
		//------------Card 2
		panPlayerCard2 = new JPanel();
		panPlayerCard2.setBounds(235, 265, 71, 96);
		panPlayerCard2.setOpaque(false);
		layeredPane.add(panPlayerCard2, new Integer(2));
		panPlayerCard2.setLayout(new BorderLayout(0, 0));
		
		lblPlayerCard2 = new JLabel("");
		panPlayerCard2.add(lblPlayerCard2);
		
		
		//------------Card 3
		panPlayerCard3 = new JPanel();
		panPlayerCard3.setBounds(270, 265, 71, 96);
		panPlayerCard3.setOpaque(false);
		layeredPane.add(panPlayerCard3, new Integer(3));
		panPlayerCard3.setLayout(new BorderLayout(0, 0));
		
		lblPlayerCard3 = new JLabel("");
		panPlayerCard3.add(lblPlayerCard3);
		
		
		//------------Card 4
		panPlayerCard4 = new JPanel();
		panPlayerCard4.setBounds(305, 265, 71, 96);
		panPlayerCard4.setOpaque(false);
		layeredPane.add(panPlayerCard4, new Integer(4));
		panPlayerCard4.setLayout(new BorderLayout(0,0));
		
		lblPlayerCard4 = new JLabel("");
		panPlayerCard4.add(lblPlayerCard4);
		
		
		//-----------Card 5
		panPlayerCard5 = new JPanel();
		panPlayerCard5.setBounds(340, 265, 71, 96);
		panPlayerCard5.setOpaque(false);
		layeredPane.add(panPlayerCard5, new Integer(5));
		panPlayerCard5.setLayout(new BorderLayout(0,0));
		
		lblPlayerCard5 = new JLabel("");
		panPlayerCard5.add(lblPlayerCard5);
		
		
		
		//-----------Card 6
		panPlayerCard6 = new JPanel();
		panPlayerCard6.setBounds(375, 265, 71, 96);
		panPlayerCard6.setOpaque(false);
		layeredPane.add(panPlayerCard6, new Integer(6));
		panPlayerCard6.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard6 = new JLabel("");
		panPlayerCard6.add(lblPlayerCard6);
				
				
		//----------Card 7
		panPlayerCard7 = new JPanel();
		panPlayerCard7.setBounds(410, 265, 71, 96);
		panPlayerCard7.setOpaque(false);
		layeredPane.add(panPlayerCard7, new Integer(7));
		panPlayerCard7.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard7 = new JLabel("");
		panPlayerCard7.add(lblPlayerCard7);
				
				
		
		//------------Card 8
		panPlayerCard8 = new JPanel();
		panPlayerCard8.setBounds(200, 285, 71, 96);
		panPlayerCard8.setOpaque(false);
		layeredPane.add(panPlayerCard8, new Integer(8));
		panPlayerCard8.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard8 = new JLabel("");
		panPlayerCard8.add(lblPlayerCard8);
				
				
		//-----------Card 9
		panPlayerCard9 = new JPanel();
		panPlayerCard9.setBounds(235, 285, 71, 96);
		panPlayerCard9.setOpaque(false);
		layeredPane.add(panPlayerCard9, new Integer(9));
		panPlayerCard9.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard9 = new JLabel("");
		panPlayerCard9.add(lblPlayerCard9);
				
		
		//----------Card 10
		panPlayerCard10 = new JPanel();
		panPlayerCard10.setBounds(270, 285, 71, 96);
		panPlayerCard10.setOpaque(false);
		layeredPane.add(panPlayerCard10, new Integer(10));
		panPlayerCard10.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard10 = new JLabel("");
		panPlayerCard10.add(lblPlayerCard10);
		
		//---------Card 11
		panPlayerCard11 = new JPanel();
		panPlayerCard11.setBounds(305, 285, 71, 96);
		panPlayerCard11.setOpaque(false);
		layeredPane.add(panPlayerCard11, new Integer(11));
		panPlayerCard11.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard11 = new JLabel("");
		panPlayerCard11.add(lblPlayerCard11);
		
		//---------Card 12
		panPlayerCard12 = new JPanel();
		panPlayerCard12.setBounds(340, 285, 71, 96);
		panPlayerCard12.setOpaque(false);
		layeredPane.add(panPlayerCard12, new Integer(12));
		panPlayerCard12.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard12 = new JLabel("");
		panPlayerCard12.add(lblPlayerCard12);
				
		
		//---------Card 13
		panPlayerCard13 = new JPanel();
		panPlayerCard13.setBounds(375, 285, 71, 96);
		panPlayerCard13.setOpaque(false);
		layeredPane.add(panPlayerCard13, new Integer(13));
		panPlayerCard13.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard13 = new JLabel("");
		panPlayerCard13.add(lblPlayerCard13);
				
		
		//--------Card 14
		panPlayerCard14 = new JPanel();
		panPlayerCard14.setBounds(410, 285, 71, 96);
		panPlayerCard14.setOpaque(false);
		layeredPane.add(panPlayerCard14, new Integer(14));
		panPlayerCard14.setLayout(new BorderLayout(0,0));
				
		lblPlayerCard14 = new JLabel("");
		panPlayerCard14.add(lblPlayerCard14);
				
		
		
		
		
		//===============================================================================================
		//											PLAYER STATUS
		//===============================================================================================
		
		
		
		panPlayerStatus = new JPanel();
		panPlayerStatus.setBounds(10, 80, 180, 60);
		panPlayerStatus.setBackground(clrTransparent);
		layeredPane.add(panPlayerStatus, new Integer(1));
		panPlayerStatus.setLayout(new GridLayout(2,1));
		
		lblPlayerName = new JLabel("Player Money:");
		lblPlayerName.setBackground(clrTransparent);
		panPlayerStatus.add(lblPlayerName);
		
		lblPlayerMoney = new JLabel("$1000");
		lblPlayerMoney.setBackground(clrTransparent);
		panPlayerStatus.add(lblPlayerMoney);
		
		
		//===============================================================================================
		//											GAME CONTROLS
		//===============================================================================================
		
		
		panGameControls = new JPanel();
		panGameControls.setBounds(380, 375, 200, 50);
		panGameControls.setBackground(clrTransparent);
		layeredPane.add(panGameControls, new Integer(1));
		panGameControls.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnHit = new JButton("HIT");
		btnHit.addActionListener(new HitListener());
		JButton btnStay = new JButton("STAY");
		btnStay.addActionListener(new StayListener());
		btnDouble = new JButton("DOUBLE");
		btnDouble.addActionListener(new DoubleListener());
		
		panGameControls.add(btnHit);
		panGameControls.add(btnStay);
		panGameControls.add(btnDouble);
		
		panDeal = new JPanel();
		panDeal.setBounds(380, 375, 200, 50);
		panDeal.setBackground(clrTransparent);
		panDeal.setLayout(new GridLayout(1,0,0,0));
		layeredPane.add(panDeal, new Integer(2));
		panDeal.setVisible(false);
		JButton btnDeal = new JButton("Deal");
		btnDeal.addActionListener(new DealBtnListener());
		panDeal.add(btnDeal);
		
		
		
		
		
		
		//===============================================================================================
		//											GAME RESULTS
		//===============================================================================================
		
		panGameResult = new JPanel();
		panGameResult.setBounds(225, 200, 150, 50);
		panGameResult.setBackground(clrMaroon);
		panGameResult.setVisible(false);
		layeredPane.add(panGameResult, new Integer(100));
		panGameResult.setLayout(new BorderLayout(0, 0));
		

		lblGameResult = new JLabel("");
		lblGameResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameResult.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		panGameResult.add(lblGameResult, BorderLayout.SOUTH);
		
		
		lblBustResult = new JLabel("");
		lblBustResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblBustResult.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		panGameResult.add(lblBustResult, BorderLayout.NORTH);
		
		
		//===============================================================================================
		//											PLAYER SCORE
		//===============================================================================================
		panPlayerValue = new JPanel();
		panPlayerValue.setBounds(115, 320, 60, 25);
		//panPlayerValue.setBackground(clrTransparent);
		layeredPane.add(panPlayerValue, new Integer(1));
		panPlayerValue.setLayout(new BorderLayout(0,0));
		
		lblPlayerValue = new JLabel("");
		lblPlayerValue.setHorizontalAlignment(SwingConstants.CENTER);
		//lblPlayerValue.setBackground(clrTransparent);
		panPlayerValue.add(lblPlayerValue, BorderLayout.CENTER);
		
		
	}//end initialize


	
	
	
	//===============================================================================================
	//											GETTERS, SETTERS, AND "SHOW-ERS" (methods that show something)
	//===============================================================================================
	
	
	/**
	 * updates the value of a player's hand, showing both a high and low value, if necessary
	 * @param nVals - an array containing both the high and low value of a player's hand
	 */
	public void updatePlayerValue(int[] nVals){
		
		this.lblPlayerValue.setVisible(false);
		this.panPlayerValue.remove(this.lblPlayerValue);
		
		String str = "";
		
		if(nVals[0] == nVals[1]) str += nVals[0];
		else if(nVals[1] > 21) str += nVals[0];
		else str += nVals[0]+" / "+nVals[1];
		
		lblPlayerValue = new JLabel(str);
		lblPlayerValue.setHorizontalAlignment(SwingConstants.CENTER);
		panPlayerValue.add(lblPlayerValue, BorderLayout.CENTER);
		
	}//end updatePlayerValue
	
	
	/**
	 * set the labels to reflect a dollar amount
	 * this method is only to manipulate GUI elements
	 * @param nDollars - the dollar amount a player has
	 */
	public void updateMoney(int nDollars){
		
		String strDollars = "$";
		strDollars += nDollars;
		
		this.lblPlayerMoney.setText(strDollars);
		this.lblPlayerMoney.repaint();
		
	}//end updateMoney
	
	/**
	 * set the labels
	 * show the labels
	 */
	public void showDealerWins(){
		
		this.lblBustResult.setText(NEGATIVE_RESULT);
		this.lblGameResult.setText(DEALER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showDealerWins
	
	
	/**
	 * set the labels
	 * show the labels
	 */
	public void showPlayerWins(){
		
		this.lblBustResult.setText(POSITIVE_RESULT);
		this.lblGameResult.setText(PLAYER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showPlayerWins
	
	
	/**
	 * set the labels
	 * show the labels
	 */
	public void showPlayerBlackjack(){
		
		this.lblBustResult.setText(PLAYER_BLACKJACK);
		this.lblGameResult.setText(PLAYER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showPlayerBlackjack
	
	/**
	 * set the labels
	 * show the labels
	 */
	public void showPush(){
		
		this.lblBustResult.setText(PUSH);
		this.lblGameResult.setText(PUSH2);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showPush
	
	
	
	/**
	 * method to "wipe the cards off the table"
	 */
	public void clearCards(){
		
		this.lblPlayerCard1.setVisible(false);
		this.lblPlayerCard2.setVisible(false);
		this.lblPlayerCard3.setVisible(false);
		this.lblPlayerCard4.setVisible(false);
		this.lblPlayerCard5.setVisible(false);
		this.lblPlayerCard6.setVisible(false);
		this.lblPlayerCard7.setVisible(false);
		this.lblPlayerCard8.setVisible(false);
		this.lblPlayerCard9.setVisible(false);
		this.lblPlayerCard10.setVisible(false);
		this.lblPlayerCard11.setVisible(false);
		this.lblPlayerCard12.setVisible(false);
		this.lblPlayerCard13.setVisible(false);
		this.lblPlayerCard14.setVisible(false);
		
		
		this.lblDealerUpCard.setVisible(false);
		this.lblDealerDownCard.setVisible(false);
		this.lblDealerCard3.setVisible(false);
		this.lblDealerCard4.setVisible(false);
		this.lblDealerCard5.setVisible(false);
		this.lblDealerCard6.setVisible(false);
		this.lblDealerCard7.setVisible(false);
		this.lblDealerCard8.setVisible(false);
		this.lblDealerCard9.setVisible(false);
		this.lblDealerCard10.setVisible(false);
		this.lblDealerCard11.setVisible(false);
		this.lblDealerCard12.setVisible(false);
		this.lblDealerCard13.setVisible(false);
		this.lblDealerCard14.setVisible(false);
		
	}//end clearCards
	
	
	
	/**
	 * method to set the dealer's up card
	 * dealer's down card will also be set, as we will never set only a dealer up card
	 * @param crd - the first card in the dealer's hand
	 */
	public void setDealerUpCard(Card crd){
		
		this.lblDealerUpCard.setIcon(new ImageIcon(BlackJackView.class.getResource(
				RELATIVE_PATH_PREFIX+
				BlackJackView.suitMap.get(crd.getSuit())+
				BlackJackView.valueMap.get(crd.getcFace())+
				FILE_SUFFIX
				)));
		
		//reset the down card, will always be performed if we are setting the dealer-up card
		lblDealerDownCard.setIcon(new ImageIcon(BlackJackView.class.getResource("/hw4/b2fv.gif")));
		
		panDealerUpCard.repaint();
		panDealerDownCard.repaint();
		lblDealerUpCard.setVisible(true);
		lblDealerDownCard.setVisible(true);
		
	}//end updateDealerupCard
	
	
	/**
	 * set the game results
	 * show the game results
	 */
	public void showDealerBlackjack(){
		
		this.lblBustResult.setText(DEALER_BLACKJACK);
		this.lblGameResult.setText(DEALER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showDealerBlackjack
	
	
	/**
	 * set the game results
	 * show the game results
	 */
	public void showPlayerBusts(){
		
		this.lblBustResult.setText(PLAYER_BUSTS);
		this.lblGameResult.setText(DEALER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showPlayerBusts
	
	
	/**
	 * set the results
	 * show the results
	 */
	public void showDealerBusts(){
		
		this.lblBustResult.setText(DEALER_BUSTS);
		this.lblGameResult.setText(PLAYER_WINS);
		this.panGameResult.setVisible(true);
		this.lblBustResult.setVisible(true);
		this.lblGameResult.setVisible(true);
		
	}//end showDealerBusts
	
	
	/**
	 * turn the game results invisible
	 */
	public void clearGameResult(){
		
		this.lblGameResult.setVisible(false);
		this.lblBustResult.setVisible(false);
		this.panGameResult.setVisible(false);
		
	}//end clearGameResult
	
	
	/**
	 * show the "Deal" button
	 */
	public void showDealBtn() {this.panDeal.setVisible(true);}
	
	/**
	 * hide the "Deal" button
	 */
	public void hideDealBtn() {this.panDeal.setVisible(false);}
	
	
	public void hideDoubleBtn() {this.btnDouble.setVisible(false);}
	
	public void showDoubleBtn() {this.btnDouble.setVisible(true);}
	
	
	/**
	 * method to be written which will allow the player's name to be added to the GUI
	 */
	public void setPlayer() {
		//not completed
	}//end setPlayer
	
	/**
	 * updates to view to show each card in the player's hand
	 * switch statement with no intermittent breaks, cascades down only across each card in player's hand
	 * @param hnd - the player's current hand
	 */
	public void setPlayerHand(Hand hnd){
		
		int numCards = hnd.getCards().size();
		
		switch(numCards){
		
		
		case 14:	this.lblPlayerCard14.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(13).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(13).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard14.setVisible(true);
		
		
		
		
		
		
		case 13:	this.lblPlayerCard13.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(12).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(12).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard13.setVisible(true);
					
		
		
		case 12:	this.lblPlayerCard12.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(11).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(11).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard12.setVisible(true);
		
		
		
		case 11:	this.lblPlayerCard11.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(10).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(10).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard11.setVisible(true);
		
		
		case 10:	this.lblPlayerCard10.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(9).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(9).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard10.setVisible(true);
		
		
		
		case 9:		this.lblPlayerCard9.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(8).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(8).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard9.setVisible(true);
		
		
		case 8:		this.lblPlayerCard8.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(7).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(7).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard8.setVisible(true);
		
		
		case 7:		this.lblPlayerCard7.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(6).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(6).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard7.setVisible(true);
		
		
		
		case 6:		this.lblPlayerCard6.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(5).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(5).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard6.setVisible(true);
		
					
		
		case 5:		this.lblPlayerCard5.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(4).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(4).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard5.setVisible(true);
		
		
		
		case 4:		this.lblPlayerCard4.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(3).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(3).getcFace())+
					FILE_SUFFIX
					)));

					this.lblPlayerCard4.setVisible(true);
		
		
		
		case 3:		this.lblPlayerCard3.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(2).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(2).getcFace())+
					FILE_SUFFIX
					)));
	
					this.lblPlayerCard3.setVisible(true);
		
		
		
		case 2:		this.lblPlayerCard2.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(1).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(1).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard2.setVisible(true);
		
		
		
		case 1:		this.lblPlayerCard1.setIcon(new ImageIcon(BlackJackView.class.getResource(
					RELATIVE_PATH_PREFIX+
					BlackJackView.suitMap.get(hnd.getCards().get(0).getSuit())+
					BlackJackView.valueMap.get(hnd.getCards().get(0).getcFace())+
					FILE_SUFFIX
					)));
		
					this.lblPlayerCard1.setVisible(true);
		
					break;
			default:	System.out.println("Error");
		
		}//end switch
	}//end setPlayerHand
	
	
	/**
	 * use a while-loop to turn over successive cards, starting with the closest to the dealer's up card
	 * switch statement inside the while loop
	 * add a delay at each flip for a better effect
	 * @param hnd - a dealer's hand
	 */
	public void setDealerHand(Hand hnd) {
		
		int numCards = hnd.getCards().size();
		int nCardFlipped = 2;
		
		while(nCardFlipped <= numCards){
			switch(nCardFlipped){
			
			
			case 14:	this.lblDealerCard14.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(13).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(13).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard14.setVisible(true);
						nCardFlipped++;
						break;
			
			
			
			
			
			
			case 13:	this.lblDealerCard13.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(12).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(12).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard13.setVisible(true);
						nCardFlipped++;
						break;
						
			
			
			case 12:	this.lblDealerCard12.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(11).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(11).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard12.setVisible(true);
						nCardFlipped++;
						break;
			
			
			
			case 11:	this.lblPlayerCard11.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(10).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(10).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblPlayerCard11.setVisible(true);
						nCardFlipped++;
						break;
			
			
			case 10:	this.lblDealerCard10.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(9).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(9).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard10.setVisible(true);
						nCardFlipped++;
						break;
			
			
			
			case 9:		this.lblDealerCard9.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(8).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(8).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard9.setVisible(true);
						nCardFlipped++;
						break;
			
			
			case 8:		this.lblDealerCard8.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(7).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(7).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard8.setVisible(true);
						nCardFlipped++;
						break;
			
			
			case 7:		this.lblDealerCard7.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(6).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(6).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard7.setVisible(true);
						nCardFlipped++;
						break;
			
			
			
			case 6:		this.lblDealerCard6.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(5).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(5).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard6.setVisible(true);
						nCardFlipped++;
						break;
			
						
			
			case 5:		this.lblDealerCard5.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(4).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(4).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerCard5.setVisible(true);
						nCardFlipped++;
						break;
			
			
			
			case 4:		this.lblDealerCard4.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(3).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(3).getcFace())+
						FILE_SUFFIX
						)));

						this.lblDealerCard4.setVisible(true);
						nCardFlipped++;
						//delayCardFlip();
						break;
			
			
			
			case 3:		this.lblDealerCard3.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(2).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(2).getcFace())+
						FILE_SUFFIX
						)));
		
						this.lblDealerCard3.setVisible(true);
						nCardFlipped++;
						//delayCardFlip();
						break;
			
			
			case 2:		this.lblDealerDownCard.setIcon(new ImageIcon(BlackJackView.class.getResource(
						RELATIVE_PATH_PREFIX+
						BlackJackView.suitMap.get(hnd.getCards().get(1).getSuit())+
						BlackJackView.valueMap.get(hnd.getCards().get(1).getcFace())+
						FILE_SUFFIX
						)));
			
						this.lblDealerDownCard.setVisible(true);
						nCardFlipped++;
						break;
						
						
						
				default:	System.out.println("Error");
			}//end switch
		}//end while
	}//end setDealerHand
	
	
	/**
	 * @return a reference to the frame
	 */
	public JFrame getFrame(){return frmBlackjack;}
	
	
	//===============================================================================================
	//											HELPERS
	//===============================================================================================
	
	//unable to implement this successfully, this helper would allow for a slight <1sec delay in flipping the dealer's cards
	//i spent far too much time trying to get this to work properly
	/*
	private void delayCardFlip() {
		
		try {
			Thread.currentThread();
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end delayCardFlip
*/

	
}//end BlackJack
