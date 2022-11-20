package model.player;


import model.game.Status;
import model.pack.Deck;

public class Player extends AbstractPlayer{

  private Hand secondHand;
  private float bank;
  private int bet;
  private static final int BANK_AMOUNT = 1000;

  public Player(String name) {
    super(name);
    bank = BANK_AMOUNT;
    bet = 0;
    secondHand = new Hand();
  }

 
  // Removes a player's bet from their bank if they bust. Sets bet to zero
  // afterwards.
  public void bust() {
    setBank(bank - bet);
    setBet(0);
  }

  // Adds a player's bet from their bank if they win. Sets bet to zero afterwards.
  public void win() {
    setBank(bank + bet);
    setBet(0);
  }

  // Sets a player's bet to 0 if he "push".
	public void push() {
    status = Status.PUSH;
		bet = 0;
	}

  /**
   * Adds a card to player hand
   * when player decide to hit
   */
  @Override
  public void hit(Deck deck){
    status = Status.HIT;
    hand.addFrom(deck);
  }

  /**
   * function to check if the player hand can 
   * be split in two
   */
  private boolean isSplitable(){
    if(hand.getNumberOfCard() != 2)
      return false;
    if(getCardsFromHand().get(0).equals(getCardsFromHand().get(1)))
      return false;
    return true;  
  }

  /**
   * Split the hand of a player
   */
  public void split(){
    if(isSplitable()){
      status = Status.SPLIT;
      secondHand.addFrom(hand.getHand());
      setBet(2 * bet);
    }
  }

  // Removes a player's bet from their bank if they lose. Sets bet to zero
  // afterwards.
  public void loss() {
    setBank(bank - bet);
    setBet(0);
  }

  // This sets the player bank to -1. -1 is unreachable and they are removed from
  // the game
  public void removeFromGame() {
    bank = -1;
  }

  // This calculate the bet for a player who has a Blackjack
  public void blackjack() {
    setBank((float) (bank + 1.5 * bet));
    bet = 0;
  }

  /**
   * Set the bet of the player
   * Throws an illegal an exception if bet is invalid
   * @param newBet
   */
  public void setBet(int newBet) {
    if(newBet < 0 || newBet > BANK_AMOUNT){
      throw new IllegalArgumentException("The bet is invalid");
    }
    bet = newBet;
  }

  /**
   * Getter
   * @return the bet of the player
   */
  public int getBet() {
    return this.bet;
  }

  /**
   * Getter
   * @return the total amount present in palyer's bank
   */
  public float getBank() {
    return bank;
  }

  /**
   * Setter
   * @param amount : the new value of the player bank
   */
  private void setBank(float amount){
    this.bank = amount;
  }

  @Override
  public String toString(){
    return super.toString() + "bet= " + bet + " ,bank = " + bank;
  }
 

}
