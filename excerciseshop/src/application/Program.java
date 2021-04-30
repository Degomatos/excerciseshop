package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitties.Client;
import entitties.ImportedProduct;
import entitties.Product;
import entitties.UsedProduct;
import services.Order;
import services.OrderItem;
import services.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("");
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter #"+ (i+1) +" item data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0); 
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			

			if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				
				Product product = new UsedProduct(productName, productPrice, date);
				OrderItem it = new OrderItem(quantity, productPrice, product);
				order.addItem(it);
		
			} else if(type == 'i') {
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				
				Product product = new ImportedProduct(productName, productPrice, customFee);
				OrderItem it = new OrderItem(quantity, (productPrice+customFee), product);
				order.addItem(it);
			}else {
				
				Product product = new Product(productName, productPrice);
				OrderItem it = new OrderItem(quantity, productPrice, product);
				order.addItem(it);
			}
									
		}
		
		System.out.println();
		System.out.println(order);
		System.out.println();
		System.out.println("PRICE TAGS");
		System.out.println(order.priceTags());
		
	sc.close();
	}

}
