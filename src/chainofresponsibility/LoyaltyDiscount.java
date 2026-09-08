package chainofresponsibility;

import modal.Cart;
import strategy.DiscountStragegyManager;
import strategy.DiscountStrategy;
import strategy.StrategyType;

public class LoyaltyDiscount extends Coupon{

    double percent;
    DiscountStrategy ds;

  public   LoyaltyDiscount(double percent){
         this.percent = percent;
         this.ds = DiscountStragegyManager.getInstance().getStrategy(StrategyType.PERCENT,percent,0.0);
    }

    @Override
    public boolean isApplicable(Cart c) {
        return c.isLoyaltyMember();
    }

    @Override
   public double getDiscount(Cart c) {

        return ds.calculate(c.getCurrentTotal());
    }

    @Override
    public String name() {
          return "Loyalty Discount " + (int)percent + "% off " ;
    }
}
