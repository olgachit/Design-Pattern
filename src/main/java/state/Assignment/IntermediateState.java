package state.Assignment;

public class IntermediateState implements CharacterState {
    private static final int XP_TO_LEVEL_UP = 120;

    @Override
    public void train(Character character) {
        System.out.println("Training... Gaining experience.");
        character.addExperience(15);
        checkLevelUp(character);
    }

    @Override
    public void meditate(Character character) {
        System.out.println("Meditating... Healing up.");
        character.addHealth(10);
    }

    @Override
    public void fight(Character character) {
        System.out.println("You are too inexperienced to fight.");
    }

    private void checkLevelUp(Character character) {
        if (character.getExperience() >= XP_TO_LEVEL_UP) {
            System.out.println("You have advanced to Expert level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public String getAvailableActions() {
        return "train, meditate";
    }
}
