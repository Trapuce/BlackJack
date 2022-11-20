package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.*;
import java.awt.event.*;

import model.card.Card;
import model.game.Blackjack;
import model.game.BlackjackGame;

public class Panneau extends JPanel implements MouseListener {
    private Blackjack game;
    private static final long serialVersionUID = 1L;
	private Image img = null;
	private Image imgBack = null;
	// private int yPos = 200 ;
	private  List<Point> points ;
	
    public Panneau(Blackjack game){
        this.game = game;
		this.points = new ArrayList<Point>();
    }

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			imgBack = ImageIO.read(new File("src/imagesCard/background.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g.drawImage(imgBack,0, 0, this.getWidth(), this.getHeight(),this);


		int xPos = 20;
		int yPos = 20;
		
		System.out.println(game.getDeck().size());
		for(int i=0 ; i<game.getDeck().size();i++) {
			   String imagePath = "src/imagesCard/"+ game.getDeck().getCardAtIndex(i).toString() + ".png";
			System.out.println(imagePath);
            
			try {
				img = ImageIO.read(new File(imagePath));
			} catch (IOException e) {
				 System.out.println(e.getMessage());
			}
               //g.drawImage(img, xPos, yPos,  this);
			   g.drawImage(img, xPos, yPos, 72, 99,  this);
				Point point = new Point(xPos, yPos);
				points.add(point);
               
               xPos+=2;
               yPos+=1;
		}
		System.out.println(game.getDeck().size());
		addMouseListener(this);
		 if(this.game.getDealer().getHand().getNumberOfCard() != 0){
			afficheMain(g);
			}
			
		
	}
	public void afficheMain(Graphics g) {
		g.setColor(Color.white);
		Font font = new Font("Arial", Font.BOLD, 18);
			g.setFont(font);
			g.drawString("Dealer", 400, 30);
			g.drawString(this.game.getPlayer().getName(), 400, 210);
		int xPosi = 400;
	   
		for(int i=0 ; i<game.getPlayer().getHand().getCardsFromHand().size();i++) {
			String imagePath = "src/images/"+ game.getPlayer().getHand().getCardsFromHand().get(i).toString()+ ".gif";
		   
		   try {
			   img = ImageIO.read(new File(imagePath));
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
		   g.drawImage(img, xPosi, 250,  this);
	  
		   
		   
		   xPosi+=80;
		   //yPos+=20;
	   }
	   xPosi = 400;
	   String imagePath = "";
	   for(int i=0 ; i<game.getDealer().getHand().getCardsFromHand().size();i++) {
		if(game.getDealer().getHand().getCardsFromHand().get(i).isHidden()){
			imagePath = "src/imagesCard/"+ game.getDealer().getHand().getCardsFromHand().get(i).toString()+ ".png";
		}else{
			imagePath = "src/images/"+ game.getDealer().getHand().getCardsFromHand().get(i).toString()+ ".gif";
		}
	   
	   try {
		   img = ImageIO.read(new File(imagePath));
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   //g.drawImage(img,xPosi , 50,  this);
	   g.drawImage(img, xPosi, 50, 72, 99,  this);

	   
	   
	   xPosi+=80;
	   //yPos+=20;
   }
   }
  

	@Override
	public void mouseClicked(MouseEvent e) {
		//  int x = e.getX();
		//  int y = e.getY();
		
		//for(int i = 0; i < points.size(); i++){
			//if(points.get(i).getX() > e.getX() &&points.get(i).getX()  < ( e.getX() + getWidth() ) && points.get(i).getY() > e.getY() && points.get(i).getY()  < ( e.getY() + getHeight() )){
				//Card card = this.game.getDeck().popFirst();
				// this.game.initialize();
				// this.repaint();
		//	}
		//}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
