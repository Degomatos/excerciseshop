package services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entitties.Client;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> item = new ArrayList<OrderItem>();
	private Client client;
//Constructor	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
//Getters and Setters

	public Date getMoment() {
		return moment;
	}

	public void setMomento(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
//Methods
	public void addItem(OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem i : item) {
			sum += i.subTotal();
		}
		return sum;
	}
//toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: "+sdf.format(moment)+"\n");
		sb.append("Order status: "+status+"\n");
		sb.append("Client:"+client+"\n");
		sb.append("Order Items:\n");
		for (OrderItem i : item) {
			sb.append(i+"\n");
		}
		sb.append("Total Price: ");
		sb.append(String.format("%.2f",total()));
		return sb.toString();
	}
	
}
