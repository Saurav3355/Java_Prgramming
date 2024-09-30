import java.util.Random;
import java.util.Scanner;

public class exercise2 {

    // Lotto class to generate random numbers and calculate the sum
    public static class Lotto {
        private int[] numbers;

        // Constructor that populates the array with random integers from 1 to 9
        public Lotto() {
            numbers = new int[3];
            Random rand = new Random();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(9) + 1; // Generates numbers between 1 and 9
            }
        }

        // Method to return the array of numbers
        public int[] getNumbers() {
            return numbers;
        }

        // Method to calculate the sum of the numbers
        public int getSum() {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose a number between 3 and 27: ");
        int userNumber = scanner.nextInt();

        if (userNumber < 3 || userNumber > 27) {
            System.out.println("Invalid number! Please run the game again and choose a valid number.");
            scanner.close();
            return;
        }

        Lotto lotto;
        boolean hasWon = false;

        for (int i = 1; i <= 5; i++) {
            lotto = new Lotto(); // Create a new lotto instance
            int sum = lotto.getSum(); // Get the sum of the lotto numbers
            System.out.println("Roll " + i + ": The sum of the lotto numbers is " + sum);

            if (sum == userNumber) {
                System.out.println("Congratulations! You've won!");
                hasWon = true;
                break; // End the game if the user wins
            }
        }

        if (!hasWon) {
            System.out.println("Sorry! The computer wins. Better luck next time!");
        }

        scanner.close(); // Close the scanner to free up resources
    }
}
