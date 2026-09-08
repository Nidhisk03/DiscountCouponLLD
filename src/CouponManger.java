import chainofresponsibility.Coupon;
import modal.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CouponManger {
    static final CouponManger instance = new CouponManger();

   public static CouponManger getInstance(){
        return instance;
    }

    private Coupon head;
    private final Lock lock = new ReentrantLock();
    private CouponManger(){
          this.head = null;
    }

    public  void  registerCoupon(Coupon c){
        lock.lock();

        if(head == null)head=c;
        else{
            Coupon curr = head;
            while (curr.getNext()!=null){
                curr = curr.getNext();
            }
            curr.setNext(c);
        }
        lock.unlock();
    }

    public List<String> getApplicableCoupon(Cart c){
        ArrayList<String> list = new ArrayList<>();
        Coupon curr = head;
        while (curr != null){
            if(curr.isApplicable(c)){
                list.add(curr.name());
            }
            curr = curr.getNext();
        }

        return list;
    }

    public double applyAll(Cart c){
        if(head!=null){
            head.applyDiscount(c);
        }
        return c.getCurrentTotal();
    }


}


