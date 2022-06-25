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
			System.out.println("Enter the customer id");
			long id = scan.nextLong();
			System.out.println("Enter the restaurant");
			String restaurantLoc = scan.nextLine();
			System.out.println("Enter the delivery location");
			String delivery = scan.nextLine();
			System.out.println(obj.order(choice, restaurantLoc, delivery));
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
