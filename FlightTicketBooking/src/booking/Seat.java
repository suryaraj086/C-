package booking;

public class Seat {
	private String seatName;
	private String flightNo;
	private boolean isBusinessClass;
	private boolean isBusinessFlight;
	private boolean aisleOrWindow;

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Override
	public String toString() {
		return "Seat [seatName=" + seatName + ", flightNo=" + flightNo + ", isBusinessClass=" + isBusinessClass
				+ ", isBusinessFlight=" + isBusinessFlight + ", aisleOrWindow=" + aisleOrWindow + "]";
	}

	public boolean isBusinessClass() {
		return isBusinessClass;
	}

	public void setBusinessClass(boolean isBusinessClass) {
		this.isBusinessClass = isBusinessClass;
	}

	public boolean isBusinessFlight() {
		return isBusinessFlight;
	}

	public void setBusinessFlight(boolean isBusinessFlight) {
		this.isBusinessFlight = isBusinessFlight;
	}

	public boolean isAisleOrWindow() {
		return aisleOrWindow;
	}

	public void setAisleOrWindow(boolean aisleOrWindow) {
		this.aisleOrWindow = aisleOrWindow;
	}

}
