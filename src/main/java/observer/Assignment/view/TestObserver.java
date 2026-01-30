package observer.Assignment.view;

public class TestObserver implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature updated to: " + temperature);
    }
}
