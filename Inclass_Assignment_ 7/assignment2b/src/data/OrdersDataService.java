package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;
@Stateless
@LocalBean
@Local(DataAccessInterface.class)
public class OrdersDataService implements DataAccessInterface {
	
	public Order findById(int id) {
		Order order = new Order("blank","blank", 2f, 3);
		String url = "jdbc:postgresql://localhost:5432/test app";
		String username = "postgres";
		String password = "Incorrect1234";
		String sql = "SELECT product_name, order_no, price, quantity FROM testapp.orders WHERE product_name LIKE '%" + order.getProductName() + "%'";
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			
			Statement stmt = conn.createStatement();
			
		    ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Successful database connection! in delete method");
			
			while(rs.next()) {
				order.setOrderNumber(rs.getString("order_no"));
				order.setProductName(rs.getString("product_name"));
				order.setPrice(rs.getFloat("price"));
				order.setQuantity(rs.getInt("quantity"));
				
			//	System.out.println(String.format("ID is %d for product %s at a price of %f and quantity %d", rs.getInt("order_no"), rs.getString("product_name"), rs.getFloat("price"),rs.getInt("quantity")));
			}
			
			
		}
		catch (SQLException e)
		{
			System.out.println("Connection failed in delete method");
		}
		
		finally
		{
			if (conn  != null)
			{
				try
				{
					conn.close();
					return order;
					
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return order;
		
		
	}

	public void create(Order order) {
		String url = "jdbc:postgresql://localhost:5432/test app";
		String username = "postgres";
		String password = "Incorrect1234";
		String sql = String.format("INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('%s', '%s', %f, %d)",order.getOrderNumber(), order.getProductName(), order.getPrice(), order.getQuantity());
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("first");
			Statement stmt = conn.createStatement();
			System.out.println("second");
		    stmt.executeUpdate(sql);
			System.out.println("Successful database connection! in create method");
			
			
		}
		catch (SQLException e)
		{
			System.out.println("Connection failed in create method");
		}
		
		finally
		{
			if (conn  != null)
			{
				try
				{
					conn.close();
					
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void update(Order order) {
		delete(order);
		create(order);
		
	}

	public void delete(Order order) {
		String url = "jdbc:postgresql://localhost:5432/test app";
		String username = "postgres";
		String password = "Incorrect1234";
		String sql = "DELETE FROM testapp.Orders WHERE product_name = '"+ order.getProductName() + "'";
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			
			Statement stmt = conn.createStatement();
			
		    stmt.executeUpdate(sql);
			System.out.println("Successful database connection! in delete method");
			
			
		}
		catch (SQLException e)
		{
			System.out.println("Connection failed in delete method");
		}
		
		finally
		{
			if (conn  != null)
			{
				try
				{
					conn.close();
					
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	

	@Override
	public List<Order> findAll() {
		List<Order> list = new ArrayList<>();
	
		
Order order = new Order("test", "test2", 2.50f, 300);
		
		String url = "jdbc:postgresql://localhost:5432/test app";
		String username = "postgres";
		String password = "Incorrect1234";
		String sql = "SELECT * FROM testapp.Orders";
		Connection conn = null;
		
		try
		{
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("first");
			Statement stmt = conn.createStatement();
			System.out.println("second");
		    ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Successful database connection! in onSubmit method");
			while(rs.next())
			{
				System.out.println(String.format("ID is %d for Product %s at a price of %f", rs.getInt("id"), rs.getString("product_name"), rs.getFloat("price")));
				list.add(new Order(rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity")));
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("Connection failed in onSubmit method");
		}
		
		finally
		{
			if (conn  != null)
			{
				try
				{
					conn.close();
					return list;
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
