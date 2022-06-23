package chessGame;

import java.util.Arrays;
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		ChessGameManagement obj = new ChessGameManagement();
		Scanner scan = new Scanner(System.in);
		boolean bool = true;
		while (bool) {
			System.out.println("Enter the position");
			String chosenPosition = scan.nextLine();
			if (chosenPosition.equals("exit")) {
				bool = false;
				System.out.println("--------Exiting the game-------");
				break;
			} else if (chosenPosition.equals("print")) {
				String[][] arr = obj.print();
				for (int i = 0; i < arr.length; i++) {
					System.out.print(i+1+" ");
					for (int j = 0; j < arr[0].length; j++) {
						if (arr[i][j] != null) {
							System.out.print(arr[i][j] + "  ");
						} else {
							System.out.print("   ");
						}
					}
					System.out.println();
				}
			} else {
				try {
					System.out.println(obj.queen(chosenPosition));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter the moved position");
				String movedPosition = scan.nextLine();
				try {
					obj.movement(movedPosition, chosenPosition);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					if (e.getMessage().equals("Check Mate")) {
						System.out.println("---------------game ended-------------");
						scan.close();
						return;
					}
				}
			}
		}
		scan.close();
	}
}
