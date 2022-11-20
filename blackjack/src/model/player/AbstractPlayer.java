package model.player;

import java.util.LinkedList;

import model.card.Card;
import model.game.Status;
import model.pack.Deck;

public abstract class AbstractPlayer implements PlayerInterface{

  protected Hand hand;
  protected String name;
  protected Status status;

  /**
   * Constructor
   * 
   * @param name : the name of the player
   */
  public AbstractPlayer(String name) {
    this.hand = new Hand();
    this.name = name;
    this.status = null;
  }


  public void addFrom(Deck deck) {
    hand.addFrom(deck);
  }

  public void removeFromHand() {
    hand.removeFromHand();
  }

  public int getNumberOfCard() {
    return hand.getNumberOfCard();
  }

  public LinkedList<Card> getCardsFromHand() {
    return hand.getCardsFromHand();
  }


  /**
   * Getter
   * 
   * @return the hand
   */
  public Hand getHand() {
    return hand;
  }

  /**
   * Getter
   * 
   * @return the name of the player
   */
  public String getName() {
    return name;
  }

  /**
   * Setter
   * 
   * @param hand the new hand
   */
  protected void setHand(Hand hand) {
    this.hand = hand;
  }

  /**
   * Add a card to the player hand
   * 
   * @param card
   */
  public void hit(Deck deck) {
    hand.addFrom(deck);
  }

  public void stand() {
    status = Status.STAND;
  }

  public void bust() {
    status = Status.BUST;
  }

  /**
   * Determines if player achieved a blackjack
   */
  public boolean isBlackjack() {
    if (hand.calculateHand() == 21)
      return true;
    return false;
  }

  /**
   * Determine if the first two cards dealt is a blackjack
   * 
   * @return boolean
   */
  public boolean isNaturalBlackjack() {
    if (hand.getNumberOfCard() == 2 && hand.calculateHand() == 21)
      return true;
    return false;
  }

  /**
   * Clears the hand of a player
   */
  public void clearHand() {
    hand.clearHand();
  }

  /**
   * Return the total of player's hand
   * 
   * @return an integer representing the total
   */
  public int getHandvalue() {
    return hand.calculateHand();
  }

  public Status getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "{" +
        " name=" + getName() +
        ", hand=" + getHand() +
        ", status=" + getStatus() + 
        ", 'value=" + getHandvalue() +
        " }";
  }

}
