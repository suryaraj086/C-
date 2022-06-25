package food;

public class Executives {
	String executiveNumber;
	String point;
	int chargesEarned;

	public String getExecutiveNumber() {
		return executiveNumber;
	}

	public void setExecutiveNumber(String executiveNumber) {
		this.executiveNumber = executiveNumber;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public int getChargesEarned() {
		return chargesEarned;
	}

	public void setChargesEarned(int chargesEarned) {
		this.chargesEarned = chargesEarned;
	}

	@Override
	public String toString() {
		return "Executives [executiveNumber=" + executiveNumber + ", point=" + point + ", chargesEarned="
				+ chargesEarned + "]";
	}

}
