package chessGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGameManagement {

	Map<String, String> whitePosition = new HashMap<>();
	Map<String, String> blackPosition = new HashMap<>();

	int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int temp1 = 0;
	int diagonal[] = { -1, -1, 1, 1 };
	int diagonal1[] = { -1, 1, -1, 1 };
	int vertical[] = { -1, 1, 0, 0 };
	int horizontal[] = { 0, 0, 1, -1 };
	List<String> path = new ArrayList<>();

	public int queenPath(int N, int x, int y, int num) {
		int[][] grid = new int[N][N];
//		for (int i = 0; i < kx1.length; i++) {
//			grid[kx1[i]][kx2[i]] = 1;
//		}
		grid[x][y] = 2;
		queensMovement(grid, x, y, num);
		return temp1;
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
				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
					break;
				}
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				if (whitePosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else if (blackPosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else {
					break;
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
				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
					break;
				}
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				if (whitePosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else if (blackPosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else {
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
				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
					break;
				}
				char val = (char) (cd + 1 + 96);
				movedPosition = val + "" + (rd + 1);
				if (whitePosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else if (blackPosition.get(movedPosition) == null) {
					path.add(movedPosition);
				} else {
					break;
				}
				movedPosition = "";
				rd += horizontal[dir];
				cd += vertical[dir];
			}
		}
		return false;
	}

	public List<String> queen(String position) {
		String piece = "";
		if (whitePosition.get(position) != null) {
			piece = whitePosition.get(position);
		} else if (blackPosition.get(piece) != null) {
			piece = blackPosition.get(position);
		}
		int val = position.charAt(0) - 96 - 1;
		int val1 = Integer.parseInt(position.charAt(1) + "") - 1;
		if (piece.contains("_R")) {
			int[][] grid = new int[8][8];
			grid[val1][val] = 2;
			rookMovement(grid, val1, val, 0);
		} else if (piece.contains("_Q")) {
			queenPath(8, val1, val, 0);
		} else if (piece.contains("_K")) {
			queenPath(8, val1, val, 1);
		} else if (piece.contains("_B")) {
			int[][] grid = new int[8][8];
			grid[val1][val] = 2;
			bishopMovement(grid, val1, val, 0);
		} else if (piece.contains("_N")) {
		} else if (piece.contains("_p")) {
			int[][] grid = new int[8][8];
			grid[val1][val] = 2;
//			pawnMovement(grid, val1, val, 0);
		}

//		queenPath(8, val1, val, 0);
		int[][] grid = new int[8][8];
		grid[val1][val] = 2;
		bishopMovement(grid, val1, val, 0);
		return path;
	}

}