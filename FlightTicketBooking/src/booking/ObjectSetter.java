package booking;

import java.util.List;

public class ObjectSetter {

	public static Book bookSetter(Book obj, List<Passengers> list, int id, String from, String toLoc, String flightName,
			boolean mealPreference) {
		obj.setBookingId(id);
		obj.setFromLoc(from);
		obj.setToLoc(toLoc);
		obj.setFlightName(flightName);
		obj.setPassenger(list);
		obj.setMealPreference(mealPreference);
		return obj;
	}

	public static Passengers PassengerSetter(String name, int age, int id) {
		Passengers pass = new Passengers();
		pass.setAge(age);
		pass.setName(name);
		pass.setBookingId(id);
		return pass;
	}

	public static Seat seatSetter(boolean aisleOrWindow, boolean isBusinessClass, String inp, String flightNo,
			boolean isBusinessFlight) {
		Seat seat = new Seat();
		seat.setAisleOrWindow(aisleOrWindow);
		seat.setSeatName(inp);
		seat.setBusinessClass(isBusinessClass);
		seat.setFlightNo(flightNo);
		seat.setBusinessFlight(isBusinessFlight);
		return seat;
	}

}
