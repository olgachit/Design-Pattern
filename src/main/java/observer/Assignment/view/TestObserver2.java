package observer.Assignment.view;

public class TestObserver2 implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature is now: " + temperature);
    }
}
