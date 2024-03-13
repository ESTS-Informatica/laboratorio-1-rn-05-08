public class FullGame {
    private WordGuessingGame wordGuessingGame;
    private InputReader inputReader;

    public FullGame() {
        wordGuessingGame = new WordGuessingGame();
        inputReader = new InputReader();
    }

    private void reset() {
        wordGuessingGame.reset();
    }

    public void play() {
        char playAgain = 's';
        while (playAgain == 's' || playAgain == 'S') {
            wordGuessingGame.play();
            System.out.print("Deseja jogar novamente? (s/S para continuar): ");
            playAgain = inputReader.getChar(null);
            reset();
        }
        System.out.println("Vamos jogar de novo!");
    }

    public static void main(String[] args) {
        FullGame game = new FullGame();
        game.play();
    }
}
