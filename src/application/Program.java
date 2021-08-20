package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		char ch = 0;
		
		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported? c/u/i: ");
			ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(ch == 'c') {
				Product prod = new Product(name, price);
				list.add(prod);
			}
			else {
				if(ch == 'u') {
					System.out.print("Manufactore date (dd/mm/aaaa): ");
					Date manufactureDate = sdf.parse(sc.next());
					Product prod = new UsedProduct(name, price, manufactureDate);
					list.add(prod);
				}
				else {
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					Product prod = new ImportedProduct(name, price, customsFee);
					list.add(prod);
				}
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product prod: list) {
			System.out.println(prod.priceTag());
		}
		sc.close();
	}
		
}


