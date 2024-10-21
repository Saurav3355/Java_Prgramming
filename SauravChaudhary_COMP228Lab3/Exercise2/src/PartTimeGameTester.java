public class PartTimeGameTester extends GameTester {
    private double hoursWorked;

    public PartTimeGameTester(String name, double hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double determineSalary() {
        return hoursWorked * 20;
    }
}
