package food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDelivery {
	List<String> points = new ArrayList<>();
	Map<String, Executives> deilveryExecutives = new HashMap<>();
	List<DeliveryHistory> history = new ArrayList<>();
	Map<Integer, Booking> book = new HashMap<>();
	int bookingId;
	int charge;
	int chargeForNearbyDelivery;
	int allowance;

	public FoodDelivery() {
		Executives exe = new Executives();
		exe.setPoint("A");
		exe.setExecutiveNumber("DE1");
		exe.setChargesEarned(0);
		points.add("A");
		points.add("B");
		points.add("C");
		points.add("D");
	}

	public String order(int customerId, String restaurantPoint, String destination, long time) {
		Booking previBooking = book.get(bookingId);
		if (previBooking.getDestination() == destination) {
			if (previBooking.getNextDeliveryLimit() < time) {
				String executive = previBooking.getExecutive();
				Booking obj = new Booking(customerId, bookingId, restaurantPoint, destination, time, executive);
				book.put(bookingId++, obj);
				Executives executiveObj = deilveryExecutives.get(executive);
				executiveObj.setChargesEarned(chargeForNearbyDelivery);
				return "Alloted delivery executive " + executive;
			}
		}
		Executives exe = lowEarningExecutives(restaurantPoint);
		exe.setChargesEarned(charge + allowance);
		Booking obj1 = new Booking(customerId, bookingId, restaurantPoint, destination, time, exe.getExecutiveNumber());
		book.put(bookingId++, obj1);
		return "Alloted delivery executive " + exe.getExecutiveNumber();
	}

	public Executives lowEarningExecutives(String restaurant) {
		int temp = Integer.MAX_VALUE;
		Executives e = null;
		Executives out = null;
		for (int i = 0; i < deilveryExecutives.size(); i++) {
			e = deilveryExecutives.get(i);
			int val = e.getChargesEarned();
			if (val < temp) {
				temp = val;
				out = deilveryExecutives.get(i);
			}
		}
		return out;
	}
}
