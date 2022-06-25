package food;

import java.util.Scanner;

public class DeliveryRunner {

	public static void main(String[] args) {
		FoodDelivery obj = new FoodDelivery();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Book a deilvery\n2.Delivery Executive activity \n3.Delivery history");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}
		scan.close();
	}

}
