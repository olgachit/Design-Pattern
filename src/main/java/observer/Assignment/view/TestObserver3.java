package observer.Assignment.view;

public class TestObserver3 implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature displays: " + temperature);
    }
}
