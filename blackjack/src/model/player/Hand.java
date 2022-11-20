package model.player;

import java.util.LinkedList;

import model.card.Card;
import model.pack.Deck;

public class Hand {
  
  private Deck hand;

  public Hand(){
    hand  = new Deck(new LinkedList<Card>());
  }

  public int calculateHand(){
    int total = 0;
    boolean aceFlag = false;
    for(Card card : hand.getDeck()){
      int value = card.isHidden()? 0 : card.getValue();
      if(value >= 10)
        value = 10;
      if(value == 1)
        aceFlag = true;
      total += value;    
    }
    if(aceFlag && total + 10 <= 21)
      total += 10;
    return total;  
  }

  public void addFrom(Deck deck){
    hand.addFirst(deck.popFirst());
  }

  public void clearHand(){
    hand.clear();
  }

  public void removeFromHand(){
    hand.getDeck().removeLast();
  }

  public int getNumberOfCard(){
    return hand.getDeckSize();
  }

  public LinkedList<Card> getCardsFromHand(){
    return hand.getDeck();
  }

  public Deck getHand(){
    return hand;
  }

  @Override
  public String toString() {
    return  getHand().toString();
  }

 


}
