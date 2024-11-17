import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0; 
        boolean playAgain = true; 

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 7; 
            int score = 100; 
            System.out.println("\nA random number between 1 and 100 has been generated.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher than " + userGuess);
                } else {
                    System.out.println("The number is lower than " + userGuess);
                }

                
                score -= 14;
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + randomNumber);
                score = 0;
            }

            System.out.println("Your score for this round: " + score);
            totalScore += score;
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score: " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
