package view;

import model.pack.Deck;
import util.Observer;

public abstract class DeckView implements Observer{
  
  private Deck deck;

  public DeckView(Deck deck) {
    this.deck = deck;
    this.deck.addObserver(this);
  }
}
