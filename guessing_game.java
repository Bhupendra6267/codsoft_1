import java.util.Random;
import java.util.Scanner;

public class guessing_game {
    static Scanner sc = new Scanner(System.in);
    private int oNum;
    private int count = 0;

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private int random_num() {
        Random random = new Random();
        int num = random.nextInt(100);
        System.out.print(num);
        return num;
    }

    public void sleep(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String check(int num) {
        String message = null;
        if (num > oNum) {
            if (num - oNum > 15)
                message = "number is TOO HIGH!!";
            else
                message = "number is HIGH!!";
        } else if (num < oNum) {
            if (oNum - num > 15)
                message = "number is TOO LOW!!";
            else
                message = "number is LOW!!";
        }

        return message;
    }

    guessing_game() {
        clear();
        System.out.println("*************************************************");
        System.out.println("Welcome to Guesing Game!!\n");
        System.out.println("We have created a random number between 1 and 100, Your task is to guess the number.\n");
        System.out.println("Please Wait while we Start.....");
        sleep(4000);
        clear();
        play();
        ;
    }

    public void play() {
        oNum = random_num();
        int num = 0;
        while (num != oNum) {
            System.out.println("\nGuess the number...");
            num = sc.nextInt();
            count++;
            if (num != oNum) {
                System.out.println(check(num));
            }
        }
        sc.close();
        System.out.println("Congratulations!! You guessed the number in " + count + " trials..");
        System.out.println("The number is: " + oNum);
    }


    public static void main(String[] args) {
        new guessing_game();
        sc.close();
    }
}
