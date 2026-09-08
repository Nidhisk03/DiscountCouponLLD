package chainofresponsibility;

import modal.Cart;

public abstract  class Coupon {

    Coupon next;

    public void setNext(Coupon next) {
        this.next = next;
    }

    public Coupon getNext() {
        return next;
    }

  public   void applyDiscount(Cart c){
         if(isApplicable(c)){
             double discount = getDiscount(c);
             c.applyDiscount(discount);
             System.out.println(name() + " applied: " + discount);
             if(!isCombinable())return;
         }

         if(next!=null){
             next.applyDiscount(c);
         }
    }

    public abstract boolean isApplicable(Cart c);
   public abstract double getDiscount(Cart c);
   public abstract String name();
    public boolean isCombinable(){
     return true;
    }
}

