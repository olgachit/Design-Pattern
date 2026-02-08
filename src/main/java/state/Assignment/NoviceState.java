package state.Assignment;

public class NoviceState implements CharacterState {

    private static final int XP_TO_LEVEL_UP = 50;

    @Override
    public void train(Character character) {
        System.out.println("Training... Gaining experience.");
        character.addExperience(10);

        if (character.getExperience() >= XP_TO_LEVEL_UP) {
            System.out.println("You have advanced to Intermediate level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(Character character) {
        System.out.println("Meditation is not available at Novice level.");
    }

    @Override
    public void fight(Character character) {
        System.out.println("You are too inexperienced to fight.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public String getAvailableActions() {
        return "train";
    }
}
