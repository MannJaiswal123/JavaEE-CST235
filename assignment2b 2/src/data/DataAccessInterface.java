package data;

import java.util.List;

import beans.Order;

public interface DataAccessInterface {
	
	public Order findById(int id);

	public void create(Order order);

	public void update(Order order);

	public void delete(Order order);
	
	public List<Order> findAll();

}
