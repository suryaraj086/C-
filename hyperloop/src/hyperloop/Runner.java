package hyperloop;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Hyperloop hyper = new Hyperloop();
		boolean bool = true;
		char Spoint;
		while (bool) {
			String inp = scan.nextLine();
			if (inp.contains("INIT")) {
				Spoint = inp.charAt(inp.length() - 1);
				int totalStation = inp.charAt(inp.length() - 3);
				for (int i = 0; i < totalStation; i++) {

				}
			} else if (inp.contains("ADD_PASSENGER")) {
				int length = inp.charAt(inp.length() - 1);
				for (int i = 0; i < length; i++) {
					String data = scan.nextLine();
					String[] arr = data.split(" ");

				}
			} else if (inp.contains("START_POD")) {
				int members = inp.charAt(inp.length() - 1);
				for (int i = 0; i < members; i++) {

				}
			} else if (inp.contains("PRINT_Q")) {

			}
		}
		scan.close();
	}
}