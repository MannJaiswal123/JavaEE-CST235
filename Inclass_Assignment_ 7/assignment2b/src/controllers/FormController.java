package controllers;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
//	@EJB
//	MyTimerService timer;

	@Inject
	OrdersBusinessInterface service;

	public String onSendOrder() {
		Order order = new Order("orderForTestingMessageService", "test", 415f, 415);
		service.sendOrder(order);
		return "OrderResponse.xhtml";

	}
	
	public String onLogoff() {
		
		// Invalidate the Session to clear the security token

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page

		return "Response.xhtml?faces-redirect=true";
		
	}

//	public String onSubmit(User user) {
//
//		// timer.setTimer(10000);
//
//		service.getOrders();
//
//		service.test();
//
//		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
//
//		return "Response.xhtml";
//
//	}

	public OrdersBusinessInterface getService() {

		return service;

	}

	public String onFlash(User user) {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);

		return "Response2.xhtml?faces-redirect=true";

	}

	private void getAllOrders() {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/testapp";
		String username = "postgres";
		String password = "Incorrect1234";
		String sql = "SELECT * FROM testapp.testapp.orders";
		try {
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(String.format("ID is %s at a price of %f", rs.getInt("ID"),
						rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE")));
			}
			rs.close();
		} catch (SQLException e) {

		} finally {

		}
	}
}
