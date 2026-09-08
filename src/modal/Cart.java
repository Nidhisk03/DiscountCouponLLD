package modal;

import java.util.ArrayList;

public class Cart {
    public ArrayList<CartItem> items = new ArrayList<>();
    boolean loyaltyMember;
    double originalTotal= 0.0;
    double currentTotal = 0.0;
    String paymentBank;

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    public void setLoyaltyMember(boolean loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }

    public ArrayList<CartItem> getItems(){
        return items;
    }
    public void addProduct(Product p , int quantity){
        CartItem c = new CartItem(p,quantity);
         items.add(c);
         originalTotal+=c.itemTotal();
         currentTotal+=c.itemTotal();
    }

    public boolean isLoyaltyMember(){
        return loyaltyMember;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public double getOriginalTotal(){
        return  originalTotal;
    }

    public double getCurrentTotal(){
        return  currentTotal;
    }

    public void applyDiscount(double amount){
         currentTotal = getCurrentTotal()-amount;
         System.out.println("Current Total after applying dicount of "+amount
         +" is "+currentTotal);
    }

}
