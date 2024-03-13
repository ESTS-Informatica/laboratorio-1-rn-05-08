public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private WordGenerator wordGenerator;
    private InputReader inputReader;

    public WordGuessingGame() {
        wordGenerator = new WordGenerator();
        hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        numberOfTries = 0;
        inputReader = new InputReader();
    }

    private void initializeGuessedWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hiddenWord.length(); i++) {
            builder.append("_");
        }
        guessedWord = builder.toString();
    }

    public void play() {
        showWelcome();
        while (!hiddenWord.equals(guessedWord)) {
            showGuessedWord();
            guess();
        }
        showResult();
    }

    private void showWelcome() {
        System.out.println("Bem-vindo ao Word Guessing Game!");
    }


    private void guess() {
        char letter = inputReader.getChar("Adivinha a letra: ");
        if (hiddenWord.contains(String.valueOf(letter)) && !guessedWord.contains(String.valueOf(letter))) {
            updateGuessedWord(letter);
        } else {
            System.out.println("Errado! Tenta novamente.");
        }
        numberOfTries++;
    }
    
    private void updateGuessedWord(char letter) {
        StringBuilder updatedWord = new StringBuilder();
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                updatedWord.append(letter);
            } else {
                updatedWord.append(guessedWord.charAt(i));
            }
        }
        guessedWord = updatedWord.toString();
    }

    private void showGuessedWord() {
        System.out.println("Palavra adivinhada: " + guessedWord);
    }

    private void showResult() {
        System.out.println("Parabéns! Adivinhaste a palavra '" + hiddenWord + "' em " + numberOfTries + " tentativas.");
    }
    
    public void reset() {
        hiddenWord = wordGenerator.generateWord();
        initializeGuessedWord();
        numberOfTries = 0;
    }
}
