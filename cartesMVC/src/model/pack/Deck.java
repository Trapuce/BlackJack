package model.pack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import model.card.Card;
import util.AbstractObservableModel;

public class Deck extends AbstractObservableModel {

  private LinkedList<Card> deck;
  private static final int MAX_DECK_SIZE = 52;

  public Deck(LinkedList<Card> deck) {
    this.deck = deck;
  }

  public void addFirst(Card carte) {
    if (deck.size() >= MAX_DECK_SIZE) {
      System.out.println("Deck is full");
    } else {
      deck.addFirst(carte);
      // fireChange();
    }
  }

  public void addLast(Card carte) {
    if (deck.size() >= MAX_DECK_SIZE) {
      System.out.println("Deck is full");
    } else {
      deck.addLast(carte);
      // fireChange();
    }
  }

  public void addAll(Deck deck) {
    this.deck.addAll(deck.getDeck());
  }

  public Card popFirst() {
    if (deck.size() == 0) {
      System.out.println("Deck is empty");
      return null;
    }
    Card firstCard = deck.removeFirst();
    // fireChange();
    return firstCard;
  }

  public Card popLast() {
    if (deck.size() == 0) {
      System.out.println("Deck is empty");
      return null;
    }
    Card lastCard = deck.removeLast();
    // fireChange();
    return lastCard;
  }

  public Card popAtIndex(int index) {

    if (index < 0 || index >= deck.size()) {
      throw new ArrayIndexOutOfBoundsException("Index not valid");
    }
    Card card = deck.get(index);
    deck.remove(index);
    // fireChange();
    return card;
  }

  public Card getCardAtIndex(int index) {
    if (index < 0 || index >= deck.size()) {
      throw new ArrayIndexOutOfBoundsException("Index not valid");
    }
    return deck.get(index);
  }

  public Card getRandomCarte() {
    int size = deck.size();
    Random rand = new Random();
    int randomIndex = rand.nextInt(size);
    return deck.get(randomIndex);
  }

  public void shuffle() {
    Collections.shuffle(deck);
    // fireChange();
  }

  public Deck cutDeck() {
    Deck cards = new Deck(new LinkedList<>());
    LinkedList<Card> cardsToRemoveFromDeck = new LinkedList<>();
    int size = deck.size();
    Random rand = new Random();
    int randomIndex = rand.nextInt(size);
    for (int i = 0; i <= randomIndex; i++) {
      cards.addLast(deck.get(i));
      cardsToRemoveFromDeck.add(deck.get(i));
    }
    deck.removeAll(cardsToRemoveFromDeck);
    // fireChange();
    return cards;
  }

  public void clear() {
    deck.removeAll(deck);
  }

  public boolean contains(Card card){
    return deck.contains(card);
  }

  public int size(){
    return deck.size();
  }

  public LinkedList<Card> getDeck() {
    return this.deck;
  }

  public int getDeckSize() {
    return deck.size();
  }

  public void setDeck(LinkedList<Card> deck) {
    this.deck = deck;
  }

  @Override
  public String toString() {
    return getDeck().toString();
  }

}
