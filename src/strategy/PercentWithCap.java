package strategy;

public class PercentWithCap implements DiscountStrategy{

    double percent;
    double cap;

    PercentWithCap(double percent,double cap){
        this.percent=percent;
        this.cap=cap;
    }

    @Override
    public double calculate(double amount) {
        double amt = ((double) percent /100)*amount;
        if(amt>cap)return cap;
        return amt;
    }
}
