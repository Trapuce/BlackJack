package util;

import java.util.List;

public abstract class AbstractObservableModel {
  
  protected List<Observer> listOfObservers;

  public void addObserver(Observer observer){
    listOfObservers.add(observer);
  }

  public void removeObserver(Observer observer){
    listOfObservers.remove(observer);
  }

  protected void fireChange(){

    for(Observer observer : listOfObservers){
      observer.update(this);
    }
    
  }

}
