import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int minRange=1;
        int maxRange=100;
        int maxAttempts=10;
        String playAgain="yes";
        int roundsWon=0;
        int totalAttempts=0;
        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain.equalsIgnoreCase("yes")){
            int randomNumber=random.nextInt(maxRange-minRange+1)+minRange;
            int attempts=0;
            boolean hasWon = false;
            System.out.println("\nGuess a number between "+minRange+"and"+maxRange+":");
            while (attempts<maxAttempts) {
                System.out.print("Enter your guess:");
                int userGuess=scanner.nextInt();
                attempts++;
                if (userGuess==randomNumber){
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                System.out.println("Attempts remaining: "+(maxAttempts-attempts));
            }
            if (!hasWon){
                System.out.println("Sorry, you've used all your attempts. The correct number was "+randomNumber+".");
            }
            totalAttempts+=attempts;
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain=scanner.next();
        }
        System.out.println("\nGame Over!");
        System.out.println("Rounds won: "+roundsWon);
        System.out.println("Total attempts:"+totalAttempts);
        scanner.close();
    }
}
