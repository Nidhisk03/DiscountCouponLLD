package chainofresponsibility;

import modal.Cart;
import strategy.DiscountStragegyManager;
import strategy.DiscountStrategy;
import strategy.StrategyType;

public class BankDiscount extends Coupon{

    String bank;
    double percent;
    double cap;
    double minSpend;
    DiscountStrategy ds;

    public BankDiscount(String bank, double percent, double cap, double minSpend) {
        this.bank = bank;
        this.percent = percent;
        this.cap = cap;
        this.minSpend = minSpend;
        this.ds = DiscountStragegyManager.getInstance().
                getStrategy(StrategyType.PERCENT_WITH_CAP,percent,cap);
    }

    @Override
    public boolean isApplicable(Cart c) {
        return c.getPaymentBank().equals(bank) && c.getOriginalTotal()>=minSpend;
    }

    @Override
  public   double getDiscount(Cart c) {
        return ds.calculate(c.getCurrentTotal());
    }

    @Override
    public String name() {
        return bank + " Bank Rs " + (int)percent + " off upto " + (int)cap;
    }
}
