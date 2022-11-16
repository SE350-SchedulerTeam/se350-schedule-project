package org.se350.logic;

public interface Watcher {
     void registerObserver(Observer o);
     void notifyObservers(String notification);
}
