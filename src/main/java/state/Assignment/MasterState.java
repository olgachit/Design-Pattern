package state.Assignment;

public class MasterState implements CharacterState {

    @Override
    public void train(Character character) {
        endGame();
    }

    @Override
    public void meditate(Character character) {
        endGame();
    }

    @Override
    public void fight(Character character) {
        endGame();
    }

    private void endGame() {
        System.out.println("You are a Master. The journey is complete.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public String getAvailableActions() {
        return "game completed";
    }
}

