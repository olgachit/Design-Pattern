package template_method.Assignment;

public class HighCardGame extends Game {

    private int[] scores;
    private int numberOfPlayers;
    private Deck deck;
    private int winner = -1;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];
        this.deck = new Deck();

        for (int i = 0; i < numberOfPlayers; i++) {
            scores[i] = 0;
        }

        System.out.println("Game started with " + numberOfPlayers + " players");
        System.out.println("Players draw cards until the deck is empty");
    }

    @Override
    public boolean endOfGame() {
        return deck.isEmpty();
    }

    @Override
    public void playSingleTurn(int player) {
        if (!deck.isEmpty()) {
            Card card = deck.drawCard();
            scores[player] += card.getValue();

            System.out.println("Player " + player + " drew: " + card);
            System.out.println("Player " + player + " total score: " + scores[player]);
        }
    }

    @Override
    public void displayWinner() {
        int highestScore = -1;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                winner = i;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Player " + winner + " wins with " + highestScore + " points!");
    }
}
