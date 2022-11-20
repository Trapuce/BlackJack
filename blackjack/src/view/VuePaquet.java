package view;

import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import model.game.Blackjack;
import model.game.BlackjackGame;

public class VuePaquet  extends JFrame{

    private Panneau pan ;
    private VueMain vueMainPlayer;
    private Blackjack game ;
    private JButton btnStart;  
    private JButton btnHit;  
    private JButton btnStand;  
    private JButton btnDeal; 
    private JLabel betLabel; 
    private JButton btnEndGame;
    private JTextField tfBalance;
    private JLabel lblInitialBalance ;
    private JLabel lblCurrentBalance;
    private JLabel lblBalanceAmount ;
    private JLabel lblInfo ;
    private JTextField tfBetAmount;
    private JLabel lblEnterBet ;
    private Container content= this.getContentPane() ;

    public VuePaquet(Blackjack game) {
        this.game = game;
        String playerName = JOptionPane.showInputDialog(this, "Enter name");
        game.player(playerName);
        setTitle("Blackjack");
         //content = this.getContentPane();

        btnStart = new JButton("Start");
        btnStart.setBounds(20, 610, 99, 50);
        btnStart.setBackground(Color.white);
       // btnStart.setBorder(null);
        // btnStart.setBorder(new RoundBtn(15));   
        btnStart.addActionListener(this::start);
        content.add(btnStart);

        btnEndGame = new JButton("End Game");
        btnEndGame.setEnabled(false);
        btnEndGame.setBounds(121, 610, 99, 50);
        content.add(btnEndGame);

        btnHit = new JButton("HIT");
        btnHit.addActionListener(this::hit);
       // btnHit.setBounds(600, 450, 100, 75);
        btnHit.setBounds(290, 515, 140, 35);
        btnHit.setVisible(false);
        content.add(btnHit);

        btnStand = new JButton("STAND");
        //btnStand.setBounds(500, 450, 100, 75);
        btnStand.setBounds(470, 515, 140, 35);
        btnStand.addActionListener(this::stand);
        content.add(btnStand);
        btnStand.setVisible(false);


        btnDeal = new JButton("DEAL");
        //btnDeal.setBounds(700, 450, 100, 75);
        btnDeal.setBounds(679, 610, 200, 50);
        btnDeal.addActionListener(this::bet);
        content.add(btnDeal);
        btnDeal.setVisible(false);


		
        tfBalance = new JTextField(); // Text field to store initial balance
		tfBalance.setText("100");
        tfBalance.setBounds(131, 580, 89, 28);
        tfBalance.setColumns(10);
        content.add(tfBalance);

        lblInitialBalance = new JLabel("Initial Balance:"); // Initial balance label
		lblInitialBalance.setFont(new Font("Arial", Font.BOLD, 13));
		lblInitialBalance.setForeground(Color.WHITE);
		lblInitialBalance.setBounds(30, 586, 100, 16);
        content.add(lblInitialBalance);


        
		lblCurrentBalance = new JLabel("Current Balance:"); // Current balance label
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBalance.setFont(new Font("Arial", Font.BOLD, 16));
		lblCurrentBalance.setForeground(Color.WHITE);
		lblCurrentBalance.setBounds(315, 578, 272, 22);
		content.add(lblCurrentBalance);


        lblBalanceAmount = new JLabel(); // Balance label, shows current balance
		lblBalanceAmount.setText(String.format("0"));
		lblBalanceAmount.setForeground(Color.ORANGE);
		lblBalanceAmount.setFont(new Font("Arial", Font.BOLD, 40));
		lblBalanceAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceAmount.setBounds(315, 600, 272, 50);
		content.add(lblBalanceAmount);

        lblInfo = new JLabel("Please enter a bet and click Deal"); // Deal info label
		lblInfo.setBackground(Color.ORANGE);
		lblInfo.setOpaque(false);
		lblInfo.setForeground(Color.ORANGE);
		lblInfo.setFont(new Font("Arial", Font.BOLD, 16));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(290, 482, 320, 28);
		content.add(lblInfo);

        tfBetAmount = new JTextField(); // Bet amount text field
		tfBetAmount.setText("10");
		tfBetAmount.setBounds(790, 580, 89, 28);
		content.add(tfBetAmount);

        lblEnterBet = new JLabel("Enter Bet:"); // Bet amount info label
		lblEnterBet.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnterBet.setForeground(Color.WHITE);
		lblEnterBet.setBounds(689, 586, 100, 16);
		this.getContentPane().add(lblEnterBet);

        this.pan = new Panneau(game);
        content.add(pan);
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void start(ActionEvent event) {
        
        this.game.initialize();
        btnDeal.setVisible(true);
        btnEndGame.setEnabled(true);


        System.out.println("Deck size: " + game.getDeck().size());
        this.pan.repaint();
        
    }
    
    public void hit(ActionEvent event){
        this.game.getPlayer().hit(game.getDeck());
        game.getDealer().getHand().getCardsFromHand().getLast().setHidden(false);
        this.pan.repaint();
        try {
            Thread.sleep(3000);
            game.getDealer().dealerPlay(game.getDeck());
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void stand(ActionEvent event){
        this.game.getPlayer().stand();
        game.getDealer().getHand().getCardsFromHand().getLast().setHidden(false);
        this.pan.repaint();
        try {
            Thread.sleep(3000);
            game.getDealer().dealerPlay(game.getDeck());
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void bet(ActionEvent event){
        String betS = JOptionPane.showInputDialog("Enter Bet");
        int bet = Integer.parseInt(betS);
        game.getPlayer().setBet(bet);
        System.out.println(game.getPlayer().getBet());
        btnHit.setVisible(true);
        btnStand.setVisible(true);
    }
    
}
