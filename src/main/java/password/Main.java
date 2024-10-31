package password;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
            static String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@$%^&*";
            static SecureRandom rnd = new SecureRandom();
            public static void main(String[] args) {
               int  length = 0;
               boolean repeat = false;

               Scanner scanner = new Scanner(System.in);


               while(!repeat){
                   System.out.println("Введите желаемую длину пароля от 8 до 12");

                   if(!scanner.hasNextInt()){
                       System.out.println("Вы ввели не число!");
                       scanner.next();
                       continue;
                   }
                   length = scanner.nextInt();
                   if(length >= 8 & length <= 12){
                       break;
                   }
               }

                for (int i = 0; i < 10; i++) {
                 System.out.println(randomPass(symbols, length));
                }

            }

            public static String randomPass(String symbols, int len){
                StringBuilder pass = new StringBuilder(len);
                for (int i = 0; i < len; i++) {
                    pass.append(symbols.charAt(rnd.nextInt(symbols.length())));
                }
                return pass.toString();
            }
        }
