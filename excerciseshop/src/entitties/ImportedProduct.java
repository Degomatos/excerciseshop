package entitties;

public class ImportedProduct extends Product {
	
	private double customFee;
//Constructor
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, double customFee) {
		super(name, price);
		this.customFee = customFee;
	}
//Getters and Setters
	public double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(double customFee) {
		this.customFee = customFee;
	}
//Methods
	public double totalPrice() {
		return super.getPrice()+customFee;
	}
	
	@Override
	public String priceTag() {
		return super.getName()+" $ "+String.format("%.2f", totalPrice())
				+" (Custom Fee: $ "+String.format("%.2f",customFee)+")"
				+String.format("\n");
	}
}
