package model.card;

/**
 * Class representing a card
 * A card is definied by its name
 * and its color
 */

public class Card {

  private Hauteur hauteur;
  private Couleur couleur;
  private boolean hidden;

  /**
   * Constructor
   * 
   * @param hauteur
   * @param couleur
   */
  public Card(Hauteur hauteur, Couleur couleur) {
    this.hauteur = hauteur;
    this.couleur = couleur;
    this.hidden = false;
  }

  /**
   * @return the level of the card
   */
  public Hauteur gethauteur() {
    return this.hauteur;
  }

  /**
   * @return the type of the card
   */
  public Couleur getCardColor() {
    return this.couleur;
  }

  /**
   * @return the value of a card
   */
  public int getValue() {
    return gethauteur().getValue();
  }

  /**
   * Getter
   * @return if the card is hidden or not
   */
  public boolean isHidden(){
    return hidden;
  }

  public void setHidden(boolean hidden){
    this.hidden = hidden;
  }

  @Override
  public String toString() {
    return gethauteur() + "_" + getCardColor();
  }



}
