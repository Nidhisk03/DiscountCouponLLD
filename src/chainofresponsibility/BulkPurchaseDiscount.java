package chainofresponsibility;

import modal.Cart;
import strategy.DiscountStragegyManager;
import strategy.DiscountStrategy;
import strategy.StrategyType;

public class BulkPurchaseDiscount extends Coupon{

    double threshold;
    double flat;
    DiscountStrategy ds;

    public BulkPurchaseDiscount(double threshold, double flat){
          this.threshold = threshold;
          this.flat = flat;
          this.ds = DiscountStragegyManager.getInstance().getStrategy(StrategyType.FLAT, flat,0.0);
    }

    @Override
    public boolean isApplicable(Cart c) {
        return c.getOriginalTotal()>= threshold;
    }

    @Override
   public double getDiscount(Cart c) {

        return ds.calculate(c.getCurrentTotal());
    }

    @Override
   public String name() {
         return "Bulk Purchase Rs " + (int) flat + " off over " + (int) threshold;
    }
}
