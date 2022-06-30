package booking;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FlightTicketBooking {

	Map<String, TreeMap<String, Seat>> flight = new HashMap<String, TreeMap<String, Seat>>();
	Map<String, Map<String, List<String>>> location = new HashMap<>();
	Map<Integer, Book> bookings = new HashMap<>();
	Map<String, Map<String, Integer>> price = new HashMap<>();
	int bookingId = 1;
	int businessClassPrice = 2000;
	int economyClassPrice = 1000;
	int aislePrice = 100;
	int mealPrice = 200;
	int businessClassSurgePrice = 200;
	int economyClassSurgePrice = 100;

	StringBuilder str = new StringBuilder();

	public FlightTicketBooking() {
		try {
			flightDetails();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String flightDetails() throws IOException {
		FileReader fr = new FileReader("/home/surya-inc1500/eclipse-workspace/FlightTicketBooking/Files/Flights.txt");
		int i;
		String str1 = "";
		String inp = "";
		while ((i = fr.read()) != -1) {
			str.append((char) i);
			if (i == 10) {
				String[] arr = inp.split("-");
				String flightName = arr[1];
				String from = arr[2];
				String toLoc = arr[3];
				Map<String, Integer> map = new HashMap<>();
				map.put("Business", 2000);
				map.put("Economy", 1000);
				price.put(flightName, map);
				inp.trim();
				inp = "/home/surya-inc1500/eclipse-workspace/FlightTicketBooking/Files/" + inp + ".txt";
				putDataInLocationMap(flightName, from, toLoc);
				FileReader fr1 = new FileReader(inp);
				int j;
				while ((j = fr1.read()) != -1) {
					str1 += ((char) j);
				}
				str1 = str1.replaceAll("Business :", "");
				str1 = str1.replaceAll("Economy :", "");
				str1 = str1.replaceAll("\\{", "");
				str1 = str1.replaceAll("}", "");
				str1 = str1.replaceAll(" ", "");
				str1 = str1.replaceAll("\n", ":");
				String[] classType = str1.split(":");
				String array[] = classType[0].split(",");
				int[] values = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
				if (classType.length > 1) {
					String array1[] = classType[1].split(",");
					int[] values1 = Arrays.stream(array1).mapToInt(Integer::parseInt).toArray();
					createSeatObj(values[3], values1[3] + values[3], values1, false, flightName, false);
					createSeatObj(1, values[3], values, true, flightName, false);
				} else {
					String array1[] = classType[1].split(",");
					int[] values1 = Arrays.stream(array1).mapToInt(Integer::parseInt).toArray();
					createSeatObj(values[3], values1[3] + values[3], values1, false, flightName, true);
					createSeatObj(1, values[3], values, true, flightName, true);
				}
				inp = "";
				fr1.close();
			}
			if (i != 10) {
				inp += (char) i;
			}
		}
		fr.close();
		return str.toString();
	}

	public void createSeatObj(int val, int row, int[] arr, boolean isBusinessClass, String flightNo,
			boolean isBusinessFlight) {
		Seat seat;
		int number = 0;
		for (int k = val; k <= row; k++) {
			number = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 1; j <= arr[i]; j++) {
					number += 1;
					String inp = (k + "" + (char) (number + 64));
					if (j == 1 || j == arr[i]) {
						seat = ObjectSetter.seatSetter(true, isBusinessClass, inp, flightNo, isBusinessFlight);
						Map<String, Seat> map = new HashMap<>();
						map.put(inp, seat);
						TreeMap<String, Seat> flightSeat = flight.get(flightNo);
						if (flightSeat == null) {
							flightSeat = new TreeMap<>();
							flight.put(flightNo, flightSeat);
						}
						flightSeat.putAll(map);
					} else {
						seat = ObjectSetter.seatSetter(false, isBusinessClass, inp, flightNo, isBusinessFlight);
						Map<String, Seat> map = new HashMap<>();
						map.put(inp, seat);
						TreeMap<String, Seat> flightSeat = flight.get(flightNo);
						if (flightSeat == null) {
							flightSeat = new TreeMap<>();
							flight.put(flightNo, flightSeat);
						}
						flightSeat.putAll(map);
					}
				}
			}
		}
	}

	public void putDataInLocationMap(String flightName, String from, String toLoc) {
		Map<String, List<String>> temp = location.get(from);
		if (temp == null) {
			temp = new HashMap<>();
		}
		List<String> flights = temp.get(toLoc);
		if (flights == null) {
			flights = new ArrayList<>();
		}
		flights.add(flightName);
		temp.put(toLoc, flights);
		location.put(from, temp);
	}

	public void putDataInFlightMap(String flightName, String seatName, Seat obj) {
		Map<String, Seat> map = flight.get(flightName);
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(seatName, obj);
	}

	public void enterFlightDetails() throws IOException {
		File file = new File("/home/surya-inc1500/eclipse-workspace/FlightTicketBooking/Files/Flights.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Flight-A112-Chennai-Mumbai\n" + "Flight-A113-Chennai-Kolkata\n" + "Flight-A114-Chennai-Delhi");
		fw.close();
	}

	public void flightNo1() throws IOException {
		File file = new File(
				"/home/surya-inc1500/eclipse-workspace/FlightTicketBooking/Files/Flight-A112-Chennai-Mumbai.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Business : {2, 3, 2}, 12\n" + "Economy : {3, 4, 4}, 20");
		fw.close();
	}

	public String listOfFlights() {
		return str.toString();
	}

	public List<String> searchFlight(String from, String toDes) throws Exception {
		Map<String, List<String>> temp = location.get(from);
		if (temp == null) {
			throw new Exception("No flights found");
		}
		List<String> list = temp.get(toDes);
		if (list == null) {
			throw new Exception("No flights found");
		}
		return list;
	}

	public String flightBooking(List<Passengers> pass, int bookingId, Book obj) {
		bookings.put(bookingId, obj);
		return "Booking successful";
	}

	public void seatAllocation(String flightName, List<String> list, Book obj) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			String seatName = list.get(i);
			Seat seatObj = flight.get(flightName).get(seatName);
			flight.get(flightName).remove(seatName);
			obj.setSeats(seatName, seatObj);
		}
	}

	public Seat seatBooking(String flightNo, String seatNo) throws Exception {
		Map<String, Seat> arr = flight.get(flightNo);
		Seat seat = arr.get(seatNo);
		if (seat == null) {
			throw new Exception("Seat not found");
		}
		arr.remove(seatNo);
		return seat;
	}

	public String bookingCancellation(int bookingId) throws Exception {
		Book obj = bookings.get(bookingId);
		nullChecker(obj);
		Map<String, Seat> seat = obj.getSeats();
		String flightName = obj.getFlightName();
		Map<String, Seat> availSeats = flight.get(flightName);
		availSeats.putAll(seat);
		bookings.remove(bookingId);
		int refund = refundCalculator(obj);
		return "Cancelled successfully and the amount to be refunded is rs " + refund;
	}

	public String cancelIndividual(String seatName, int bookingId, String name, int age) throws Exception {
		Book obj = bookings.get(bookingId);
		Map<String, Seat> map = obj.getSeats();
		nullChecker(map);
		Seat seat = map.get(seatName);
		nullChecker(seat);
		Map<String, Seat> flightMap = flight.get(obj.getFlightName());
		flightMap.put(seatName, seat);
		map.remove(seatName);
		List<Passengers> pass = obj.getPassenger();
		for (int i = 0; i < pass.size(); i++) {
			if (pass.get(i).getName().equals(name) && pass.get(i).getAge() == age) {
				pass.remove(i);
			}
		}
		int amount = obj.getAmount();
		int individual = (amount / (obj.getSeats().size() + 1));
		if (!seat.isAisleOrWindow()) {
			individual -= aislePrice;
		}
		int newAmount = amount - individual + 200;
		obj.setAmount(newAmount);
		return "Cancellation successful and amount to be refunded " + (amount - newAmount);
	}

	public int bookingIds() {
		return bookingId++;
	}

	public void nullChecker(Object inp) throws Exception {
		if (inp == null) {
			throw new Exception("Not found");
		}
	}

	public List<String> mealOrderedSeats() {
		List<String> seats = new ArrayList<>();
		for (Book obj : bookings.values()) {
			if (obj.isMealPreference()) {
				seats.addAll(obj.getSeats().keySet());
				System.out.println(obj);
			}
		}
		return seats;
	}

	public Map<String, Seat> availableSeats(String flightName) throws Exception {
		Map<String, Seat> freeSeats = flight.get(flightName);
		if (freeSeats == null) {
			throw new Exception("Flight not found");
		}
		return freeSeats;
	}

	public Book bookingSummary(int bookingId) throws Exception {
		Book book = bookings.get(bookingId);
		nullChecker(book);
		return book;
	}

	public int paymentCalculation(Book obj) throws Exception {
		int amount = 0;
		nullChecker(obj);
		Map<String, Integer> map = price.get(obj.getFlightName());
		businessClassPrice = map.get("Business");
		economyClassSurgePrice = map.get("Economy");
		if (obj.isMealPreference()) {
			amount += (mealPrice) * (obj.getSeats().size());
		}
		for (Seat seat : obj.getSeats().values()) {
			if (seat.isBusinessClass()) {
				amount += businessClassPrice;
				businessClassPrice += businessClassSurgePrice;
				map.put("Business", businessClassPrice);
			} else {
				amount += economyClassPrice;
				economyClassPrice += economyClassSurgePrice;
				map.put("Economy", economyClassSurgePrice);
			}
			if (seat.isAisleOrWindow()) {
				amount += aislePrice;
			}
		}
		price.put(obj.getFlightName(), map);
		obj.setAmount(amount);
		return amount;
	}

	public int refundCalculator(Book obj) {
		int amount = obj.getAmount();
		amount = amount - (obj.getPassenger().size() * 200);
		return amount;
	}

	public List<String> filterBusinessClass() {
		List<String> flights = new ArrayList<>();
		for (Map<String, Seat> temp : flight.values()) {
			for (String val : temp.keySet()) {
				Seat obj = temp.get(val);
				if (obj.isBusinessFlight()) {
					flights.add(obj.getFlightNo());
				}
			}
		}
		return flights;
	}

}
