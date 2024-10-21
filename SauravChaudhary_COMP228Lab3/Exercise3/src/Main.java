import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter mortgage number: ");
            String mortgageNumber = scanner.nextLine();

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter mortgage type (Business/Personal): ");
            String type = scanner.nextLine();

            System.out.print("Enter amount of mortgage: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter current interest rate: ");
            double currentInterestRate = scanner.nextDouble();

            System.out.print("Enter term (1 for short, 3 for medium, 5 for long): ");
            int term = scanner.nextInt();
            scanner.nextLine();

            if (type.equalsIgnoreCase("Business")) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, term);
            } else if (type.equalsIgnoreCase("Personal")) {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, term);
            } else {
                System.out.println("Invalid mortgage type. Please enter either Business or Personal.");
                i--;
            }

            System.out.println();
        }

        System.out.println("\nMortgage Information:");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("------------------------------");
        }

        scanner.close();
    }
}
