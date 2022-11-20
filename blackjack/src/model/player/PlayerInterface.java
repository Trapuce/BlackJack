package model.player;

public interface PlayerInterface {
  
  public void bust();
  
  public void push();

  public void stand();

  public int getHandvalue();

  public boolean isBlackjack();

}
