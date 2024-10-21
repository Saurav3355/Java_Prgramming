import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] insurancePolicies = new Insurance[2];

        for (int i = 0; i < insurancePolicies.length; i++) {

            System.out.print("Enter insurance type (Health/Life): ");
            String type = scanner.nextLine();


            while (!type.equalsIgnoreCase("Health") && !type.equalsIgnoreCase("Life")) {
                System.out.println("Invalid type. Please enter Health or Life.");
                type = scanner.nextLine();
            }


            System.out.print("Enter the monthly cost: ");
            double monthlyCost = 0;
            while (true) {
                try {
                    monthlyCost = Double.parseDouble(scanner.nextLine());
                    if (monthlyCost < 0) {
                        System.out.println("Monthly cost cannot be negative. Please enter a positive number.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the monthly cost.");
                }
            }


            if (type.equalsIgnoreCase("Health")) {
                insurancePolicies[i] = new Health("Health", monthlyCost);
            } else {
                insurancePolicies[i] = new Life("Life", monthlyCost);
            }


            System.out.println("Insurance created:");
            insurancePolicies[i].displayInfo();
        }


        System.out.println("\nAll Insurance Policies:");
        for (Insurance insurance : insurancePolicies) {
            insurance.displayInfo();
        }

        scanner.close();
    }
}
