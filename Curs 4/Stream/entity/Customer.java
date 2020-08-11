package Stream.entity;

import java.util.Arrays;
import java.util.List;

public class Customer {

	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer(Order... orders) {
		this.orders = Arrays.asList(orders);
	}


	
}
