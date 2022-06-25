package food;

public class DeliveryHistory {

	String executives;
	String restaurant;
	String destination;
	String order;
	String pickupTime;
	String deliveryTime;
	String deliveryCharge;

	public String getExecutives() {
		return executives;
	}

	public void setExecutives(String executives) {
		this.executives = executives;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "[executives=" + executives + ", restaurant=" + restaurant + ", destination=" + destination + ", order="
				+ order + ", pickupTime=" + pickupTime + ", deliveryTime=" + deliveryTime + ", deliveryCharge="
				+ deliveryCharge + "]";
	}

}
