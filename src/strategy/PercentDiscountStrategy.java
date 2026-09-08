package strategy;

public class PercentDiscountStrategy implements DiscountStrategy {
    double percent;
    PercentDiscountStrategy(double percent){
        this.percent = percent;
    }

    @Override
    public double calculate(double amount) {
        return ((double) percent /100)*amount;
    }
}
