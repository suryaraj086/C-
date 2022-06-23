package chessGame;

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
				System.out.println(obj.print());
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
