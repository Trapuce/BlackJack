package main;


import model.pack.Deck;
import model.pack.DeckBuilder;

public class Main {
  
  public static void main(String[] args){

    DeckBuilder packBuilder = new DeckBuilder();
    Deck pack = packBuilder.buildDeck(32);
    System.out.println(pack);

  }
  
}
