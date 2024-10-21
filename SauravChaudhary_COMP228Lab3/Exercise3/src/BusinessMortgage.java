public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    protected double calculateInterestRate() {
        return 1.0;
    }
}
