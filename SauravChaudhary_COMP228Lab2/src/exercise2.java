import java.util.Random;
import java.util.Scanner;

public class exercise2 {

    public static class Lotto {
        private int[] numbers;

        public Lotto() {
            numbers = new int[3];
            Random rand = new Random();
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(9) + 1;
            }
        }

        public int[] getNumbers() {
            return numbers;
        }

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
            lotto = new Lotto();
            int sum = lotto.getSum();
            System.out.println("Roll " + i + ": The sum of the lotto numbers is " + sum);

            if (sum == userNumber) {
                System.out.println("Congratulations! You've won!");
                hasWon = true;
                break;
            }
        }

        if (!hasWon) {
            System.out.println("Sorry! The computer wins. Better luck next time!");
        }

        scanner.close();
    }
}
