package model.game;

public class BlackjackGame {
  
  Blackjack blackjack;

  public BlackjackGame(Blackjack blackjack){
    this.blackjack = blackjack;
  }

  public void play(){
    blackjack.player();
    while(!blackjack.isGameOver()){
      blackjack.initialize();
      blackjack.getBet();
      blackjack.checkBlackjack();
      blackjack.playerDecision();
      blackjack.delearCard();
      blackjack.getDealer().dealerPlay(blackjack.getDeck());
      blackjack.checkRoundWinner();
      blackjack.clearHands();
      blackjack.checkPlayerBank();
      blackjack.keepPlaying();
      blackjack.isGameOver();
    }
  }

}
