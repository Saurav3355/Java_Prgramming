public abstract class Mortgage implements MortgageConstants {
    private String mortgageNumber;
    private String customerName;
    private double amount;
    private double interestRate;
    private int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, int term) {
        if (amount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = amount;
        this.term = (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) ? term : SHORT_TERM;
        this.interestRate = calculateInterestRate();
    }

    protected abstract double calculateInterestRate();

    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nAmount: $" + amount +
                "\nInterest Rate: " + interestRate + "%" +
                "\nTerm: " + term + " year(s)" +
                "\nTotal Owed: $" + calculateTotalOwed();
    }

    public double calculateTotalOwed() {
        double interest = (amount * interestRate / 100) * term;
        return amount + interest;
    }
}
