public class Life extends Insurance {

    public Life(String insuranceType, double monthlyCost) {
        super(insuranceType, monthlyCost);
    }

    @Override
    public void setInsuranceCost() {

    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType());
        System.out.println("Monthly Cost: $" + getMonthlyCost()+"\n");
    }
}
