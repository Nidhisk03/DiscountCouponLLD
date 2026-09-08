package strategy;

public class DiscountStragegyManager {

    static final DiscountStragegyManager instance = new DiscountStragegyManager();
    private DiscountStragegyManager(){

    }

    public static DiscountStragegyManager getInstance(){
        return instance;
    }

    public DiscountStrategy getStrategy(StrategyType strategyType, double param1,double param2){
        if(strategyType==StrategyType.PERCENT){
            return new PercentDiscountStrategy(param1);
        }if(strategyType==StrategyType.FLAT){
            return new FlatDicountStrategy(param1);
        }if(strategyType==StrategyType.PERCENT_WITH_CAP){
            return new PercentWithCap(param2,param2);
        }
      return null;
    }
}
