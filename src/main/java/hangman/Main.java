package hangman;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Начать новую игру(н) или выйти(в) из приложения ?");
            char select = readInput();
            if (select == 'н') {
                Hangman game = new Hangman();
                game.play();
            } else if (select == 'в') {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Сделайте выбор ещё раз");
            }
        }
    }

    public static char readInput() {
        char[] input;
       while (true) {
           input = scanner.nextLine().toLowerCase(Locale.ROOT).toCharArray();
           if (oneCharacter(input)) {
               break;
           }
       }
           return input[0];
    }

    private static boolean oneCharacter (char[] inputChar){
        if(inputChar.length > 1){
            System.out.println("Водите только один символ!");
            return false;
        } else if (inputChar.length == 1) {
            return true;
        }
        System.out.println("Вы не ввели символ, попытайтесь еще раз!");
        return false;
    }
}