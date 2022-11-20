package model.game;

public enum Status {

  BUST(-1),
  STAND(0),
  HIT(1),
  SPLIT(2),
  PUSH(3);

  private int value;

  private Status(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
