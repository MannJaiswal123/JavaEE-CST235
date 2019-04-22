package business;

import javax.annotation.Resource;
import javax.ejb.EJB;
//import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;


/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Alternative
//@Local
public class OrdersBusinessService  implements OrdersBusinessInterface{
	
	@EJB
	OrdersDataService service;

    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stubs
    	
    
    	
    	
    	
    }
    @Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	//@Override
	public void test() {
		
		
		// TODO Auto-generated method stub
		System.out.println("Hello from the OrdersBusinessService");
	}
		public void sendOrder(Order order) {
			
			// Send a Message for an Order
			try 
			{
				Connection connection = connectionFactory.createConnection();
				Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageProducer messageProducer = session.createProducer(queue);
				TextMessage message1 = session.createTextMessage();
				ObjectMessage message2 = session.createObjectMessage();
				message1.setText("This is test message");
				messageProducer.send(message1);
				message2.setObject(order);
				messageProducer.send(message2);
				connection.close();
			} 
			catch (JMSException e) 
			{
				e.printStackTrace();
			}		

			
			
			
		}
		List<Order> orders = new ArrayList<Order>();
		
		public List<Order> getOrders()
		{
		
			
			
			service.create(new Order("orderdata1", "orderdata1", 18f, 19));
			System.out.println("added \"orderdata1\", \"orderdata1\", 18f, 19");
			service.update(new Order("orderdata1", "orderdata1", 20f, 19));
			System.out.println("updated \"orderdata1\", \"orderdata1\", 20f, 19");
			service.delete(new Order("orderdata1", "orderdata1", 18f, 19));
			System.out.println("removed \"orderdata1\", \"orderdata1\", 20f, 19");
			
			service.findById(0);
			setOrders(service.findAll());
			return orders;
		}
		
		@Override
		public void setOrders (List<Order> orders)
		{
			this.orders = orders;
		}
	
		public List<Order> getOrdersForRest() {
			
			return service.findAll();
			
			
			
		}

}
