package main;

import model.game.Blackjack;
import model.game.BlackjackGame;
import view.VuePaquet;


public class Main {
  
  public static void main(String[] args){

    Blackjack blackjack = new Blackjack(52);
    BlackjackGame game = new BlackjackGame(blackjack);
    //game.play(); 
    VuePaquet v = new VuePaquet(blackjack);   
    v.setVisible(true);
  }
}
