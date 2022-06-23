package chessGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGameManagement {

	Map<String, String> whitePosition = new HashMap<>();
	Map<String, String> blackPosition = new HashMap<>();
	Map<String, String> recording = new HashMap<>();
	String color;
	int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int diagonal[] = { -1, -1, 1, 1 };
	int diagonal1[] = { -1, 1, -1, 1 };
	int vertical[] = { -1, 1, 0, 0 };
	int horizontal[] = { 0, 0, 1, -1 };
	List<String> path = new ArrayList<>();
	List<String> kingPath = new ArrayList<>();

	public ChessGameManagement() {
		whitePosition.put("a1", "W_R");
		whitePosition.put("b1", "W_N");
		whitePosition.put("c1", "W_B");
		whitePosition.put("d1", "W_Q");
		whitePosition.put("e1", "W_K");
		whitePosition.put("f2", "W_P");
		whitePosition.put("f1", "W_B");
		whitePosition.put("g1", "W_N");
		whitePosition.put("h1", "W_R");

		blackPosition.put("a8", "B_R");
		blackPosition.put("b8", "B_N");
		blackPosition.put("c8", "B_B");
		blackPosition.put("d8", "B_Q");
		blackPosition.put("d7", "B_Q");
		blackPosition.put("e8", "B_K");
		blackPosition.put("f8", "B_B");
		blackPosition.put("g8", "B_N");
		blackPosition.put("h8", "B_R");
	}

	boolean queensMovement(int[][] grid, int row, int col, int num) {
		String movedPosition;
		for (int dir = 0; dir < 8; dir++) {
			int k, rd = row + x[dir], cd = col + y[dir];
			int wordLen = grid.length;
			if (num == 1) {
				wordLen = 1;
			}
			for (k = 0; k < wordLen; k++) {
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				checker(movedPosition, rd, cd, grid);
				if (path.size() != 0 && path.get(path.size() - 1).contains("(can be occupied)")) {
					break;
				}
				movedPosition = "";
				rd += x[dir];
				cd += y[dir];
			}
		}
		return false;
	}

	boolean kingMovement(int[][] grid, int row, int col, int num) {
		String movedPosition;
		for (int dir = 0; dir < 8; dir++) {
			int k, rd = row + x[dir], cd = col + y[dir];
			int wordLen = 1;
			for (k = 0; k < wordLen; k++) {
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0
						|| (whitePosition.get(movedPosition) != null && color.equals("W_"))
						|| (blackPosition.get(movedPosition) != null && color.equals("B_"))) {

				} else if (blackPosition.get(movedPosition) != null && color.equals("W_")) {
					kingPath.add(movedPosition + "(can be occupied)");
				} else if (whitePosition.get(movedPosition) != null && color.equals("B_")) {
					kingPath.add(movedPosition + "(can be occupied)");
				} else {
					kingPath.add(movedPosition);
				}

				movedPosition = "";
				rd += x[dir];
				cd += y[dir];
			}
		}
		return false;
	}

	boolean bishopMovement(int[][] grid, int row, int col, int num) {
		String movedPosition;
		for (int dir = 0; dir < 4; dir++) {
			int k, rd = row + diagonal[dir], cd = col + diagonal1[dir];
			int wordLen = grid.length;
			for (k = 0; k < wordLen; k++) {
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				checker(movedPosition, rd, cd, grid);
				if (path.size() != 0 && path.get(path.size() - 1).contains("(can be occupied)")) {
					break;
				}
				movedPosition = "";
				rd += diagonal[dir];
				cd += diagonal1[dir];
			}
		}
		return false;
	}

	boolean rookMovement(int[][] grid, int row, int col, int num) {
		String movedPosition;
		for (int dir = 0; dir < 4; dir++) {
			int k, rd = row + horizontal[dir], cd = col + vertical[dir];
			int wordLen = grid.length;
			for (k = 0; k < wordLen; k++) {
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				checker(movedPosition, rd, cd, grid);
				if (path.size() != 0 && path.get(path.size() - 1).contains("(can be occupied)")) {
					break;
				}
				movedPosition = "";
				rd += horizontal[dir];
				cd += vertical[dir];
			}
		}
		return false;
	}

	boolean pawnMovement(int[][] grid, int row, int col, int num) {
		String movedPosition;
		int k, rd = row, cd = col;
		int wordLen = pawnChecker(row);
		for (k = 0; k < wordLen; k++) {
			char val = (char) (cd + 1 + 96);
			movedPosition = val + "" + (rd + 1);
			checker(movedPosition, rd, cd, grid);

			movedPosition = "";
			if (color.equals("W_")) {
				rd += 1;
			} else if (color.equals("B_")) {
				rd -= 1;
			}
		}
		return false;
	}

	public int pawnChecker(int row) {
		if (row == 1 && color.equals("w_")) {
			return 2;
		} else if (row == 6 && color.equals("B_")) {
			return 2;
		}
		return 1;
	}

	boolean knightMovement(int[][] grid, int row, int col, int num) {

		String movedPosition;

		int cd = col - 2, rd = row - 1;
		char val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);

		cd = col - 1;
		rd = row - 2;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);

		cd = col + 1;
		rd = row + 2;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);

		cd = col + 2;
		rd = row + 1;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);
		cd = col - 1;
		rd = row + 2;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);
		cd = col + 1;
		rd = row - 2;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);
		cd = col - 2;
		rd = row + 1;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);
		cd = col + 2;
		rd = row - 1;
		val = (char) (cd + 1 + 96);
		movedPosition = val + "" + (rd + 1);
		checker(movedPosition, rd, cd, grid);
		return false;
	}

	public void checker(String movedPosition, int rd, int cd, int[][] grid) {
		if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0
				|| (whitePosition.get(movedPosition) != null && color.equals("W_"))
				|| (blackPosition.get(movedPosition) != null && color.equals("B_"))) {

		} else if (blackPosition.get(movedPosition) != null && color.equals("W_")) {
			path.add(movedPosition + "(can be occupied)");
		} else if (whitePosition.get(movedPosition) != null && color.equals("B_")) {
			path.add(movedPosition + "(can be occupied)");
		} else {
			path.add(movedPosition);
		}
	}

	public void movement(String movedPosition, String previousPosition) throws Exception {
		String piece = whitePosition.get(previousPosition);
		if (piece == null) {
			piece = blackPosition.get(previousPosition);
		}
		if (piece.contains("W_")) {
			whitePosition.remove(previousPosition);
			whitePosition.put(movedPosition, piece);
			blackPosition.remove(movedPosition);
			path.clear();
			blackCheckMateChecker();
		} else if (piece.contains("B_")) {
			blackPosition.remove(previousPosition);
			blackPosition.put(movedPosition, piece);
			whitePosition.remove(movedPosition);
			path.clear();
			whiteCheckMateChecker();
		} else {
			return;
		}
		path.clear();
		recording.put(piece, movedPosition);
	}

	public void blackCheckMateChecker() throws Exception {
		for (String position : blackPosition.keySet()) {
			String piece = blackPosition.get(position);
			color = "B_";
			if (piece.equals("B_K")) {
				int val = position.charAt(0) - 96 - 1;
				int val1 = Integer.parseInt(position.charAt(1) + "") - 1;
				int[][] grid = new int[8][8];
				grid[val1][val] = 2;
				allWhitePath();
				if (path.contains(position + "(can be occupied)") && !path.containsAll(kingPath)) {
					throw new Exception("Check");
				} else if (path.contains(position + "(can be occupied)") && path.containsAll(kingPath)) {
					throw new Exception("Check Mate");
				}
			}
		}
		kingPath.clear();
		return;
	}

	public void allWhitePath() throws Exception {
		for (String position : whitePosition.keySet()) {
			queen(position);
		}
	}

	public void allBlackPath() throws Exception {
		for (String position : blackPosition.keySet()) {
			queen(position);
		}
	}

	public void whiteCheckMateChecker() throws Exception {
		for (String position : whitePosition.keySet()) {
			String piece = whitePosition.get(position);
			color = "W_";
			if (piece.equals("W_K")) {
				int val = position.charAt(0) - 96 - 1;
				int val1 = Integer.parseInt(position.charAt(1) + "") - 1;
				int[][] grid = new int[8][8];
				grid[val1][val] = 2;
				kingMovement(grid, val1, val, 0);
				allBlackPath();
				if (path.contains(position + "(can be occupied)") && !path.containsAll(kingPath)) {
					throw new Exception("Check");
				} else if (path.contains(position + "(can be occupied)") && path.containsAll(kingPath)) {
					throw new Exception("Check Mate");
				}
			}
		}
		kingPath.clear();
		return;
	}

	public String print() {
		String[][] arr = new String[8][8];
		for (String pos : whitePosition.keySet()) {
			int col = pos.charAt(0) - 96 - 1;
			int row = Integer.parseInt(pos.charAt(1) + "") - 1;
			String piece = whitePosition.get(pos);
			arr[row][col] = piece;
		}

		for (String pos : blackPosition.keySet()) {
			int col = pos.charAt(0) - 96 - 1;
			int row = Integer.parseInt(pos.charAt(1) + "") - 1;
			String piece = blackPosition.get(pos);
			arr[row][col] = piece;
		}
		return Arrays.deepToString(arr);
	}

	public List<String> queen(String position) throws Exception {
		String piece = "";
		if (whitePosition.get(position) != null) {
			piece = whitePosition.get(position);
			color = "W_";
		} else if (blackPosition.get(position) != null) {
			piece = blackPosition.get(position);
			color = "B_";
		}
		int val = position.charAt(0) - 96 - 1;
		int val1 = Integer.parseInt(position.charAt(1) + "") - 1;

		int[][] grid = new int[8][8];
		grid[val1][val] = 2;
		if (piece.contains("_R")) {
			rookMovement(grid, val1, val, 0);
		} else if (piece.contains("_Q")) {

			queensMovement(grid, val1, val, 0);
		} else if (piece.contains("_K")) {
			queensMovement(grid, val1, val, 1);

		} else if (piece.contains("_B")) {

			bishopMovement(grid, val1, val, 0);
		} else if (piece.contains("_N")) {

			knightMovement(grid, val1, val, 0);
		} else if (piece.contains("_p")) {

			pawnMovement(grid, val1, val, 0);
		}
		return path;
	}

}