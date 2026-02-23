package template_method.Assignment;

public class Main {
    public static void main(String[] args) {
        Game game = new HighCardGame();
        game.play(4);
    }
}