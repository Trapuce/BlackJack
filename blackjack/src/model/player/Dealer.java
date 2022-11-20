package model.player;

import model.pack.Deck;

public class Dealer extends AbstractPlayer{

  public Dealer() {
    super("Dealer");
  }

  public void dealerPlay(Deck deck){
    int value = getHandvalue();
    while(value < 17){
      hit(deck);
      value = getHandvalue();
    }

    if(value >= 17 && value <= 21)
      stand();
      
    if(value > 21)
      bust();  
    System.out.println(getHand());  
  }

  @Override
  public void push(){}
  

}
