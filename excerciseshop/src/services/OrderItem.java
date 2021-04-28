package services;

import entitties.Product;

public class OrderItem {
	
	 private Integer quantity;
	 private double price;
	 private Product product;
//Constructors
	 public OrderItem() {
	 }

	public OrderItem(Integer quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
//Setters and Getters

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
//Methods	 
	public double subTotal() {
		return quantity * price;
	}
	
	@Override
	public String toString() {
		return getProduct().getName()
				+", $"
				+String.format("%.2f",price)					
				+", Quantity: "
				+quantity
				+", Subtotal: $"
				+String.format("%.2f",subTotal());
	}
}
