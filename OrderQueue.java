import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue{
 
    private final Queue<Order> Orders=new LinkedList<>();

    public synchronized void placeOrder(Order order){
        Orders.add(order);
        System.out.println("Order Placed: "+ order.getOrder());
        notify();
    }

    public synchronized Order takeOrder() throws InterruptedException{

        while(Orders.isEmpty()){
            wait();
        }
        return Orders.poll();

    }
   
    

}