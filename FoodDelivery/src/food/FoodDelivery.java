package food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDelivery {
	List<String> points = new ArrayList<>();
	List<Executives> deilveryExecutives = new ArrayList<>();
	List<DeliveryHistory> history = new ArrayList<>();
	Map<Integer, Booking> book = new HashMap<>();

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

	public String order(int customerId, String restaurantPoint, String destination) {

		return "";
	}

	public Executives nearByExecutives(String restaurant) {
		for (int i = 0; i < deilveryExecutives.size(); i++) {
			Executives obj = deilveryExecutives.get(i);
		}
		return null;
	}
}
