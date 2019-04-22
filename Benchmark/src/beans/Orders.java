package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped


public class Orders 
{
	
	List<Order> orders;
	@Inject
	OrdersBusinessInterface service;
	
	public void init() {
		
	service.getOrders();
	}

	
	
	public Orders()
	{
		
		
	}

	public Orders(List<Order> orders) {
		super();
		this.orders = orders;
	}

	public List<Order> getOrders() {
		setOrders(service.getOrders());
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
