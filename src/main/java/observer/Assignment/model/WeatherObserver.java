package observer.Assignment.model;

import observer.Assignment.view.*;
import java.util.ArrayList;
import java.util.List;

public abstract class WeatherObserver {

    private final List<Observer> observers = new ArrayList<>();

    public synchronized void addObserver(Observer observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected synchronized void notifyObservers(int temperature) {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
