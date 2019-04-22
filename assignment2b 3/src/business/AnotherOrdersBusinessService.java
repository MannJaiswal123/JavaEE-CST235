package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Order;
import data.OrdersDataService;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative

public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	
	public void sendOrder(Order order) {
		
	}
	
@Inject
OrdersDataService service; 
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	
    	orders.add(new Order("4", "Peugeot", 60000f, 84));
    	orders.add(new Order("5", "Mercedes", 70000f, 90));
    	orders.add(new Order("6", "Audi", 80000f, 12));
    	
    	
    }
    public void test() {
    	System.out.println("Hello from the AnotherOrdersBusinessService");
    }
    	List<Order> orders = new ArrayList<Order>();
    	
    	public List<Order> getOrders() {
    		 return orders;
    	}
    	public void setOrders (List<Order>orders)
    	{
    		this.orders = orders;
    	}
    	
public List<Order> getOrdersForRest() {
			
			return service.findAll();
			
		}
       
    
}
