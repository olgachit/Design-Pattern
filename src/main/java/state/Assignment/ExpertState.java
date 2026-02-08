package state.Assignment;

public class ExpertState implements CharacterState{
    private static final int XP_TO_LEVEL_UP = 250;

    @Override
    public void train(Character character) {
        System.out.println("Training... Gaining experience.");
        character.addExperience(20);
        checkLevelUp(character);
    }

    @Override
    public void meditate(Character character) {
        if(character.getHealth() >= 100) {
            System.out.println("Health is already full. Meditation not needed.");
            return;
        }
        System.out.println("Meditating... Healing up.");
        character.addHealth(15);
    }

    @Override
    public void fight(Character character) {
        if (character.getHealth() < 15) {
            System.out.println("Not enough health to fight. Please meditate first.");
            return;
        }
        System.out.println("Fighting enemies... Gaining experience.");
        character.reduceHealth(20);
        character.addExperience(30);
        checkLevelUp(character);
    }

    private void checkLevelUp(Character character) {
        if (character.getExperience() >= XP_TO_LEVEL_UP) {
            System.out.println("You have reached the Master level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public String getAvailableActions() {
        return "train, meditate, fight";
    }
}
