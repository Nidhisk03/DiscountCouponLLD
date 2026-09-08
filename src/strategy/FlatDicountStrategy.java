package strategy;

public class FlatDicountStrategy implements DiscountStrategy{

    double amount;

    public FlatDicountStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculate(double baseAmount) {
         return Math.min(amount,baseAmount);
    }
}
