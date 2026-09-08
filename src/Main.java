import chainofresponsibility.BankDiscount;
import chainofresponsibility.BulkPurchaseDiscount;
import chainofresponsibility.LoyaltyDiscount;
import chainofresponsibility.SeasonalOffer;
import modal.Cart;
import modal.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    CouponManger manger = CouponManger.getInstance();
    manger.registerCoupon(new SeasonalOffer(10,"Clothing"));
    manger.registerCoupon(new LoyaltyDiscount(5));
    manger.registerCoupon(new BulkPurchaseDiscount(5000,500));
    manger.registerCoupon(new BankDiscount("SBI",15,200 , 2000));


    Product p1 = new Product("Winter Jacket", "Clothing", 1000);
    Product p2 = new Product("Smartphone", "Electronics", 20000);
    Product p3 = new Product("Jeans", "Clothing", 1000);
    Product p4 = new Product("Headphones", "Electronics", 2000);

    Cart cart = new Cart();
    cart.addProduct(p1,1);
    cart.addProduct(p2,1);
    cart.addProduct(p3,2);
    cart.addProduct(p4,1);
    cart.setLoyaltyMember(true);
    cart.setPaymentBank("SBI");

    System.out.println("Original Cart Total: " + cart.getOriginalTotal() + " Rs");
    List<String> applicable = manger.getApplicableCoupon(cart);
    System.out.println("Applicable Coupons:");
    for (String name : applicable) {
        System.out.println(" - " + name);
    }


    double finalTotal = manger.applyAll(cart);
    System.out.println("Final Cart Total after discounts: " + finalTotal + " Rs");


}
