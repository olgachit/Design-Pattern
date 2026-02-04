package decorator.Example;

public class BasicOrator implements Orator {
    @Override
    public void say(String message) {
        System.out.println(message);
    }
}