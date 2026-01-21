package factory_method.Example.adventure;

public class RelaxedGame extends Game {
    @Override
    public Room createRoom() {
        return new LovelyRoom();
    }
}