package model.game;

import java.util.Scanner;

import model.pack.Deck;
import model.pack.DeckBuilder;
import model.player.Dealer;
import model.player.Player;

public class Blackjack {

  private Deck deck;
  private Dealer dealer;
  private Player player;
  private boolean gameOver;
  private Scanner scanner;

  public Blackjack(int deckSize) {
    this.deck = new DeckBuilder().buildDeck(deckSize);
    this.dealer = new Dealer();
    gameOver = false;
    this.scanner = new Scanner(System.in);
  }

  public void player() {
    System.out.println("Enter player name");
    String playerName = scanner.next();
    this.player = new Player(playerName);
  }

  public void player(String name) {
    this.player = new Player(name);
  }


  public void initialize() {
    deck.shuffle();
    for (int i = 0; i < 2; i++) {
      dealer.addFrom(deck);
      player.addFrom(deck);
    }
    dealer.getCardsFromHand().getLast().setHidden(true);
    System.out.println(dealer);
    System.out.println(player);
  }

  public void checkBlackjack() {
    if (dealer.isBlackjack() && !player.isBlackjack()) {
      System.out.println("player busted");
      player.bust();
      return;
    }
    if (dealer.isBlackjack() && player.isBlackjack()) {
      System.out.println("player pushed");
      player.push();
      return;
    }
    if (!dealer.isBlackjack() && player.isBlackjack()) {
      System.out.println("Player won");
      player.blackjack();
    }

  }

  public void getBet() {
    System.out.print("How much do you want to bet? ");
    int bet = scanner.nextInt();
    player.setBet(bet);
  }

  public void playerDecision() {
    char decision = '0';
    while (!(decision == 'H' || decision == 'S')) {
      System.out.println("What is your next move? (H)it or (S)tand ?");
      String input = scanner.next();
      decision = input.toUpperCase().charAt(0);
      if (decision == 'H') {
        player.hit(deck);
      }
      if (decision == 'S') {
        player.stand();
      }
    }
    System.out.println(player);
    // if (player.getStatus() == Status.HIT)
    // player.hit(deck);
    // if (player.getStatus() == Status.STAND)
    // player.stand();
    // if (player.getStatus() == Status.SPLIT)
    // player.split();

  }

  public void delearCard() {
    dealer.getCardsFromHand().getLast().setHidden(false);
    System.out.println(dealer);
  }

  public void checkRoundWinner() {
    if (player.getHandvalue() > 21) {
      System.out.println("player busted, you loose");
      player.bust();
      return;
    }
    if (dealer.getHandvalue() > 21) {
      System.out.println("Dealer busted, you won");
      player.win();
      return;
    }
    if (player.getHandvalue() == dealer.getHandvalue()) {
      System.out.println("player and dealer are tied");
      player.push();
      return;
    }
    if (player.getHandvalue() > dealer.getHandvalue()) {
      System.out.println("You won");
      player.win();
      return;
    }
    if (player.getHandvalue() == 21) {
      System.out.println("Player blackjack");
      player.blackjack();
      return;
    }
    System.out.println("Your hand is less than of the dealer, you loose");
    player.loss();
  }

  public boolean checkPlayerBank() {
    if (player.getBank() > 0)
      return true;
    System.out.println("Your bank is empty game over");
    player.removeFromGame();
    gameOver = true;
    return false;
  }

  public void keepPlaying() {
    if (!checkPlayerBank())
      return;
    char decision = '0';
    while (!(decision == 'Y' || decision == 'N')) {
      System.out.println("You have " + player.getBank() + "currently");
      System.out.println("Do you wish to continue? (Y)es or (N)o");
      String input = scanner.next();
      decision = input.toUpperCase().charAt(0);
      if (decision == 'Y')
        gameOver = false;
      if (decision == 'N')
        gameOver = true;
    }
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public void clearHands() {
    deck.addAll(dealer.getHand().getHand());
    deck.addAll(player.getHand().getHand());
    dealer.clearHand();
    player.clearHand();
  }

  public Deck getDeck() {
    return deck;
  }

  public Dealer getDealer() {
    return dealer;
  }

  public Player getPlayer() {
    return player;
  }

}
