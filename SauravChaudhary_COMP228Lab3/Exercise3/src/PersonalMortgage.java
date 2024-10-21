public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber, customerName, amount, term);
    }

    @Override
    protected double calculateInterestRate() {
        return 2.0;
    }
}
