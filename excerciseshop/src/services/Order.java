package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entitties.Client;

public class Order {

	private Date momento;
	private OrderStatus status;
	private List<OrderItem> order = new ArrayList<>();
	private Client client;
//Constructor	
	public Order() {
	}

	public Order(Date momento, OrderStatus status, Client client) {
		this.momento = momento;
		this.status = status;
		setClient(client);
	}
//Getters and Setters

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
//Methods
	
	public void addItem(OrderItem item) {
		order.add(item);
	}
}
