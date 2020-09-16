package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {

        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());

        station.setMeasurements(25, 760);

    }
}

interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

class MeteoStation implements Observed {

    private int temperature;
    private int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather change. Temp = " + temp + " presser = " + presser);
    }
}
