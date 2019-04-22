package beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
public class Order implements Serializable

{

	String orderNumber = "";
	String productName = "";
	float price = 0.00f;
	int quantity = 0;
	
	
	/**
	 * @param orderNumber
	 * @param productName
	 * @param price
	 * @param quantity
	 */
	public Order() {
		this.orderNumber = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
	}

	public Order(String orderNumber, String productName, float price, int quantity) {
		super();
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
