package food;

public class Booking {
	long customerId;
	long bookingId;
	String restaurant;
	String destination;
	long time;

	Booking(long cusId, long id, String res, String des, long currTime) {
		bookingId = cusId;
		bookingId = id;
		restaurant = res;
		destination = des;
		time = currTime;
	}

	public long getBookingId() {
		return bookingId;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public String getDestination() {
		return destination;
	}

	public long getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", restaurant=" + restaurant + ", destination=" + destination
				+ ", time=" + time + "]";
	}

}
