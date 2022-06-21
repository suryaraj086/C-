package booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {

	private int bookingId;
	private List<Passengers> passenger;
	private String fromLoc;
	private String toLoc;
	private long takeOffTime;
	private long landingTime;
	private Map<String, Seat> seats;
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(boolean mealPreference) {
		this.mealPreference = mealPreference;
	}

	String flightName;
	boolean mealPreference;

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Map<String, Seat> getSeats() {
		return seats;
	}

	public void setSeats(String key, Seat val) {
		if (seats == null) {
			seats = new HashMap<>();
		}
		this.seats.put(key, val);
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public List<Passengers> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passengers> passenger) {
		this.passenger = passenger;
	}

	public String getFromLoc() {
		return fromLoc;
	}

	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}

	public String getToLoc() {
		return toLoc;
	}

	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}

	public long getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(long takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public long getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(long landingTime) {
		this.landingTime = landingTime;
	}

	@Override
	public String toString() {
		return "Book [bookingId=" + bookingId + ", passenger=" + passenger + ", from Location=" + fromLoc
				+ ", Destination=" + toLoc + ", takeOffTime=" + takeOffTime + ", landingTime=" + landingTime
				+ ", seats=" + seats + ", flightName=" + flightName + ", Meal preference=" + mealPreference + "]";
	}

}
