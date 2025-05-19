package internship_projects;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int target = rand.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess;

                if (sc.hasNextInt()) {
                    guess = sc.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The number was: " + target);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            sc.nextLine();
            String response = sc.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nGame Over. Your final score: " + score + " round(s) won.");
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
