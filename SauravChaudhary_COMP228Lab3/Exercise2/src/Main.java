import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game tester type:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the game tester: ");
        String name = scanner.nextLine();

        GameTester gameTester;

        if (choice == 1) {
            gameTester = new FullTimeGameTester(name);
        } else if (choice == 2) {
            System.out.print("Enter the number of hours worked for part-time tester: ");
            double hours = scanner.nextDouble();
            gameTester = new PartTimeGameTester(name, hours);
        } else {
            System.out.println("Invalid choice. Exiting.");
            scanner.close();
            return;
        }


        System.out.printf("The salary for "+ gameTester.name +" is: "+ gameTester.determineSalary());

        scanner.close();
    }
}
