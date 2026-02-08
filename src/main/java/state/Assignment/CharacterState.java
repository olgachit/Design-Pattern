package state.Assignment;

public interface CharacterState {
    void train(Character character);
    void meditate(Character character);
    void fight(Character character);
    String getLevelName();
    String getAvailableActions();
}
