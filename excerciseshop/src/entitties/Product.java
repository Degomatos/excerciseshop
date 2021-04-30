package entitties;

public class Product {

	private String name;
	private double price;
//Constructor	
	public Product() {
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
//Methods
	public String priceTag() {
		return name+" $ "+String.format("%.2f",price)+String.format("\n");
	}

}
