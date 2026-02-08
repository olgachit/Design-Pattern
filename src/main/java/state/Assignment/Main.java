package state.Assignment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character = new Character("Arin");

        while (!(character.getState() instanceof MasterState)) {
            character.showStatus();
            System.out.print("Choose action: ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        }

        System.out.println("\nCongratulations! You have completed the game.");
        scanner.close();
    }
}
