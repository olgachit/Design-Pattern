package observer.Assignment.model;

import java.util.Random;

public class WeatherStation extends WeatherObserver implements Runnable {

    private final Random random = new Random();
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private boolean running = true;

    public WeatherStation() {
        temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println("WeatherStation initial temperature: " + temperature + "°C");
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature > MAX_TEMP) temperature = MAX_TEMP;
        if (temperature < MIN_TEMP) temperature = MIN_TEMP;

        System.out.println("\n[WeatherStation] Temperature changed to " + temperature + "°C");
        notifyObservers(temperature);
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            updateTemperature();
            try {
                Thread.sleep(1000 + random.nextInt(4000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

