package zkart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZKart {
	Map<String, UserDetails> user = new HashMap<>();
	Map<Category, Map<String, List<Product>>> stock = new HashMap<>();
	Map<String, List<History>> historyMap = new HashMap<>();
	Map<String, List<Product>> cart = new HashMap<>();

	public ZKart() {
		Map<String, List<Product>> map = new HashMap<>();
		Product obj = new Product("Aspire 7", "Acer", 50000, 10, 3, Category.LAPTOP);
		List<Product> arr = new ArrayList<>();
		arr.add(obj);
		map.put("Acer", arr);
		stock.put(Category.LAPTOP, map);
		UserDetails obj1 = new UserDetails("Admin", "1234", "admin@123.com", 955131531, 10, false);
		user.put("admin@123.com", obj1);

	}

	public void customerInitialization() throws IOException {
		File f = new File("zusers_db.txt");
		FileReader fr = new FileReader(f);
		String strCurrentLine = "";
		try (BufferedReader br = new BufferedReader(fr)) {
			int i;
			br.readLine();
			while ((i = br.read()) != -1) {
				if (i == 10) {
					strCurrentLine += "\t";
					continue;
				}
				strCurrentLine += (char) i;
			}
		}
		String arr[] = strCurrentLine.split("\t");
		String username = null, password = null, name = null;
		long number = 0;
		int credit = 0;
		int count = 0, count1 = 1, count2 = 4, count3 = 5, count4 = 6;
		for (int i = 0; i < arr.length; i++) {
			if (i == count) {
				username = arr[i];
			} else if (i == count1) {
				password = arr[i];
			} else if (i == count2) {
				name = arr[i];
			} else if (i == count3) {
				number = Long.parseLong(arr[i]);
			} else if (i == count4) {
				credit = Integer.parseInt(arr[i]);
			} else if (i == count4 + 1) {
				count += 7;
				count1 += 7;
				count2 += 7;
				count3 += 7;
				count4 += 7;
				UserDetails obj = new UserDetails(username, password, name, number, credit, false);
				user.put(name, obj);
			}
		}
	}

	public void inventoryInitialization() throws IOException {
		File f = new File("z-kart_db.txt");
		FileReader fr = new FileReader(f);
		String strCurrentLine = "";
		try (BufferedReader br = new BufferedReader(fr)) {
			int i;
			br.readLine();
			while ((i = br.read()) != -1) {
				if (i == 10) {
					strCurrentLine += "\t";
					continue;
				}
				strCurrentLine += (char) i;
			}
		}
		String arr[] = strCurrentLine.split("\t");
		String name = null, brand = null, model = null;
		Category type = null;
		int price = 0, stock1 = 0, discount = 0;
		int count = 0, count1 = 2, count2 = 3, count3 = 4, count4 = 5, count5 = 6;
		for (int i = 0; i < arr.length; i++) {
			if (i == count) {
				type = Category.valueOf(arr[i]);
				continue;
			} else if (i == count1) {
				brand = arr[i];
				continue;
			} else if (i == count2) {
				model = arr[i];
				continue;
			} else if (i == count3) {
				price = Integer.parseInt(arr[i]);
				continue;
			} else if (i == count4) {
				stock1 = Integer.parseInt(arr[i]);
				continue;
			} else if (i == count5) {
				discount = Integer.parseInt(arr[i]);
				continue;
			} else if (i == count5 + 1) {
				Product cus1 = new Product(name, brand, price, stock1, discount, type);
				count += 7;
				count1 += 7;
				count2 += 7;
				count3 += 7;
				count4 += 7;
				count5 += 7;
				Map<String, List<Product>> map = stock.get(type);
				if (map == null) {
					map = new HashMap<>();
				}
				List<Product> prod = map.get(brand);
				if (prod == null) {
					prod = new ArrayList<>();
				}
				prod.add(cus1);
				map.put(model, prod);
				stock.put(type, map);
			}
		}

	}

	public void nullChecker(Object inp) throws Exception {
		if (inp == null) {
			throw new Exception("Not found");
		}
	}

	public String loginChecker(String userName, String password) throws Exception {
		UserDetails obj = user.get(userName);
		nullChecker(obj);
		boolean bool = obj.passwordValidator(password);
		if (bool) {
			return "Admin";
		}
		return "Customer";
	}

	public String addToKart(String cat, String model, int product, String userName, int numberOfStock)
			throws CloneNotSupportedException {
		Category type = Category.valueOf(cat);
		Map<String, List<Product>> map = stock.get(type);
		List<Product> products = map.get(model);
		Product obj = (Product) products.get(product);
		Product obj1 = (Product) obj.clone();
		obj1.setStock(numberOfStock);
		List<Product> arr = cart.get(userName);
		if (arr == null) {
			arr = new ArrayList<>();
		}
		arr.add(obj1);
		cart.put(userName, arr);
		return "Added to cart";
	}

	public String buyProductFromCart(String userName) throws Exception {
		List<Product> arr = cart.get(userName);
		nullChecker(arr);
		int amount = 0;
		for (int i = 0; i < arr.size(); i++) {
			Product obj = arr.get(i);
			nullChecker(obj);
			obj.getType();
//			Map<String, List<Product>> map = stock.get(obj.getType());
//			List<Product> prod = map.get(obj.getBrandName());
			Product reduceStock = getFromList(obj);
			reduceStock.setStock(reduceStock.getStock() - obj.getStock());
			amount += calculateDiscountPrice(reduceStock.getPrice(), reduceStock.getDiscount());
			amount *= obj.getStock();
			int credit = creditCalculator(amount);
			System.out.println("The credit amount is " + credit);
			user.get(userName).setCredit(credit);

		}
		return "Bought successfully and amount paid rs " + amount;
	}

	public Product getFromList(Product obj) throws Exception {
		Map<String, List<Product>> map = stock.get(obj.getType());
		List<Product> prod = map.get(obj.getBrandName());
		for (int i = 0; i < prod.size(); i++) {
			if (prod.get(i).getProductName().equals(obj.getProductName())) {
				return prod.get(i);
			}
		}
		throw new Exception("Product not found");
	}

	public int calculateDiscountPrice(int amount, int discount) {
		float dis = (float) (discount / 100.0);
		int newAmount = (int) (amount * dis);
		return amount - newAmount;
	}

	public int creditCalculator(int amount) {
		int newAmount = amount / 1000;
		return newAmount * 20;
	}

	public String removeFromCart(String product, String userName) {
		List<Product> arr = cart.get(userName);
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getProductName().equals(product)) {
				arr.remove(i);
			}
		}
		return "Removed successfully";
	}

	public String displayAllItems() {
		String out = "";
		for (Map<String, List<Product>> map : stock.values()) {
			for (List<Product> prod : map.values()) {
				out += prod;
			}
		}
		return out;
	}

	public String displayLessStocks() {
		String out = "";
		for (Map<String, List<Product>> map : stock.values()) {
			for (List<Product> prod : map.values()) {
				for (int i = 0; i < prod.size(); i++) {
					Product obj = prod.get(i);
					boolean bool = obj.getLessStock();
					if (bool) {
						out += obj;
					}
				}
			}
		}
		return out;
	}

	public String listAllCategory() {
		Category[] out = Category.values();
		String output = "";
		for (int i = 0; i < out.length; i++) {
			output += (i + 1) + "." + out[i].toString() + "\n";
		}
		return output;
	}

	public String listModels(String cat) {
		Category type = Category.valueOf(cat);
		return stock.get(type).keySet().toString();
	}

	public String listAllProduct(String cat, String model) {
		Category type = Category.valueOf(cat);
		Map<String, List<Product>> map = stock.get(type);
		List<Product> products = map.get(model);
		String out = "";
		for (int i = 0; i < products.size(); i++) {
			out += products.get(i).toString();
		}
		return out;
	}

	public String changeDiscountPrice(String cat, String model, String product, int discount) {
		Category type = Category.valueOf(cat);
		Map<String, List<Product>> map = stock.get(type);
		List<Product> products = map.get(model);
		for (int i = 0; i < products.size(); i++) {
			Product obj = products.get(i);
			if (obj.getProductName().equals(product)) {
				obj.setDiscount(discount);
			}
		}
		return "Discount percentage changed";
	}

	public String changeStockPrice(String cat, String model, String product, int stock1) {
		Category type = Category.valueOf(cat);
		Map<String, List<Product>> map = stock.get(type);
		List<Product> products = map.get(model);
		for (int i = 0; i < products.size(); i++) {
			Product obj = products.get(i);
			if (obj.getProductName().equals(product)) {
				obj.setStock(stock1);
			}
		}
		return "Added stocks";
	}

}
