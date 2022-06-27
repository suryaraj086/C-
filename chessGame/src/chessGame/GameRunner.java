package chessGame;

import java.io.IOException;
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		ChessGameManagement obj = new ChessGameManagement();
		Scanner scan = new Scanner(System.in);
		boolean bool = true;
		int count = 0;
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
					System.out.print(i + 1 + " ");
					for (int j = 0; j < arr[0].length; j++) {
						if (arr[i][j] != null) {
							System.out.print(arr[i][j] + "  ");
						} else {
							System.out.print("   ");
						}
					}
					System.out.println();
				}
			} else if (chosenPosition.contains("--help")) {
				String position = chosenPosition.charAt(0) + "" + chosenPosition.charAt(1);
				System.out.println(position);
				System.out.println("Enter the coin to move");
				String coin = scan.nextLine();
				try {
					System.out.println(obj.checkVulnerabilty(coin, position));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (obj.getWhitePiece(chosenPosition) != null && count % 2 != 0) {
					System.out.println("Black's turn");
					continue;
				} else if (obj.getBlackPiece(chosenPosition) != null && count % 2 != 1) {
					System.out.println("White's turn");
					continue;
				} else {
					try {
						System.out.println(obj.queen(chosenPosition));
					} catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
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
					} finally {
						try {
							obj.writeRecord();
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						count++;
					}

				}
			}
		}
		scan.close();
	}
}
