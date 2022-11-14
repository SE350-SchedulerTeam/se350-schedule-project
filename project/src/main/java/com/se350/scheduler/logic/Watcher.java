package com.se350.scheduler.logic;

public interface Watcher {
     void registerObserver(Observer o);
     void notifyObservers(String notification);
}
