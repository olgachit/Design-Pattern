package factory_method.Example.adventure;

public class HorrorGame extends Game {
    @Override
    public Room createRoom() {
        return new ScaryRoom();
    }
}
