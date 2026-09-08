package chainofresponsibility;

import modal.Cart;
import modal.CartItem;
import strategy.DiscountStragegyManager;
import strategy.DiscountStrategy;
import strategy.StrategyType;

public class SeasonalOffer extends Coupon{
    int percent;
    String category;
    DiscountStrategy ds;

    public SeasonalOffer(int percent, String category){
        this.percent = percent;
        this.category = category;
        this.ds = DiscountStragegyManager.getInstance().getStrategy(StrategyType.PERCENT,percent,0.0);
    }

    @Override
   public boolean isApplicable(Cart c) {
        for (CartItem item : c.getItems()) {
            if (item.getProduct().getCategory().equals(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getDiscount(Cart c) {
        double total = 0.0;
        for(CartItem item:c.getItems()){
            if (item.getProduct().getCategory().equals(category)){
                total += item.itemTotal();
            }
        }
        return ds.calculate(total);
    }


    @Override
    public String name() {
          return "Seasonal Offer " + (int)percent + "% off " + category;
    }
}
