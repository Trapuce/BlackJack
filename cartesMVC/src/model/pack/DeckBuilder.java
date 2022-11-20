package model.pack;

import java.util.LinkedList;
import model.card.Card;
import model.card.Hauteur;
import model.card.Couleur;

public class DeckBuilder {

  public Deck buildDeck(int deckSize){
    LinkedList<Card> deck = new LinkedList<>();
    int numberOfLevel = Hauteur.getNumberOflevel();
    Hauteur[] arrayOfCardLevels = Hauteur.values();
    for(int i = numberOfLevel - 1; i > numberOfLevel - deckSize / Couleur.values().length - 1; i--){
      for(Couleur cardType : Couleur.values()){
        Card card = new Card(arrayOfCardLevels[i], cardType);
        deck.add(card);
      }
    }
    return new Deck(deck);
  }

 


}
