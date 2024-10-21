public abstract class Insurance {
    private String insuranceType;
    protected double monthlyCost;

    public Insurance(String insuranceType, double monthlyCost) {
        this.insuranceType = insuranceType;
        this.monthlyCost = monthlyCost;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost();

    public abstract void displayInfo();
}
