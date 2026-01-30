package observer.Assignment;

import observer.Assignment.model.WeatherStation;
import observer.Assignment.view.*;

public class main {

    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();

        Observer observer1 = new TestObserver();
        Observer observer2 = new TestObserver2();
        Observer observer3 = new TestObserver3();

        station.addObserver(observer1);
        station.addObserver(observer2);
        station.addObserver(observer3);

        Thread stationThread = new Thread(station);
        stationThread.start();

        Thread.sleep(15000);

        station.removeObserver(observer2);
        System.out.println("\nRemoved Second Observer\n");

        Thread.sleep(15000);

        station.stop();
        System.out.println("\nWeather Station stopped running\n");
        stationThread.join();
    }
}

