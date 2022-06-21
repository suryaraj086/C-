package booking;

public class Passengers {

	private String name;
	private int age;
	private int bookingId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Passengers [name=" + name + ", age=" + age + ", bookingId=" + bookingId + "]";
	}

}
