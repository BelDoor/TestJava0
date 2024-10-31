package hangman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Hangman {
    private static final String[] WORDS = {"программа", "компьютер", "телефон", "программирование", "интернет"};
    private static final int MAX_LIVES = 6;

    private String wordTarget;
    private char[] guessedWord;
    private int lives;
    private Set<Character> attemptLetters;

    public Hangman() {

        long TimeZero = System.currentTimeMillis();
        Random random = new Random();
        wordTarget = WORDS[random.nextInt(WORDS.length)];
        guessedWord = new char[wordTarget.length()];
        Arrays.fill(guessedWord, '_');
        lives = MAX_LIVES;
        attemptLetters = new HashSet<>();
    }

    public void play() {

        while (lives > 0 && !isWordGuessed()) {
            System.out.println("Слово: " + new String(guessedWord));  // заменить guessedWord на колекцию
            System.out.println("Угаданные буквы: " + attemptLetters); // введенные буквы!!!
            System.out.println("Осталось жизней: " + lives);

            System.out.print("Введите букву: ");

            char guess = Main.readInput();
            if (attemptLetters.contains(guess)) {
                System.out.println("Вы уже вводили эту букву.");
                continue;
            }

            attemptLetters.add(guess);
            if (wordTarget.indexOf(guess) >= 0) {
                for (int i = 0; i < wordTarget.length(); i++) {
                    if (wordTarget.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                lives--;
                System.out.println("Вы потеряли жизнь.");
            }
            drawHangman();
        }

        if (isWordGuessed()) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordTarget);
        } else {
            System.out.println("Вы проиграли. Загаданное слово было: " + wordTarget);
        }
    }

    private boolean isWordGuessed() {
        return wordTarget.equals(new String(guessedWord));
    }

    private void drawHangman() {
        System.out.println(" +---+");
        System.out.println(" |   |");
        System.out.println(" " + (lives < 6 ? "O" : " ") + "   |");
        System.out.println(" " + (lives < 5 ? "/" : " ") + (lives < 4 ? "|" : " ") + (lives < 3 ? "\\" : " ") + "  |");
        System.out.println(" " + (lives < 2 ? "/" : " ") + " " + (lives < 1 ? "\\" : " ") + " |");
        System.out.println("     |");
        System.out.println("=======");
    }
}

