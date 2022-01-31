import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

	private static final StringBuilder output = new StringBuilder();

	private static boolean solvePuzzle(char[][] board, List<String> words) {
		Location start = null;
		StringBuilder prefixBuilder = new StringBuilder();
		Direction direction = null;
		int expectedSize = 0;
		int col = -1;
		int row = -1;
		for (int i = 0; i < board.length && row < 0; i++) {
			for (int j = 0; j < board[i].length && col < 0; j++) {
				if (board[i][j] == '-') {
					row = i;
					col = j;
				}
			}
		}

		if (col + 1 < board[row].length && board[row][col + 1] == '-') {
			direction = Direction.RIGHT;
			int start1 = col;
			for (int j = col - 1; j >= 0 && board[row][j] != '+'; j--) {
				prefixBuilder.append(board[row][j]);
				expectedSize++;
				start1 = j;
			}
			prefixBuilder.reverse();
			for (int j = col; j < board[row].length && board[row][j] != '+'; j++) {
				expectedSize++;
			}
			start = new Location(row, start1);
		} else {
			direction = Direction.DOWN;
			int start1 = row;
			for (int i1 = row; i1 < board.length && board[i1][col] == '-'; i1++) {
				expectedSize++;
			}
			for (int i1 = row - 1; i1 >= 0 && board[i1][col] != '+'; i1--) {
				prefixBuilder.append(board[i1][col]);
				expectedSize++;
				start1 = i1;
			}
			prefixBuilder.reverse();
			start = new Location(start1, col);
		}

		String prefix = prefixBuilder.toString();
		List<String> matching = new ArrayList<>();
		for (String word : words) {
			if (word.length() == expectedSize && (prefix.isEmpty() || word.startsWith(prefix))) {
				matching.add(word);
			}
		}
		if (matching.isEmpty()) {
			return false;
		}

		for (String matched : matching) {
			words.remove(matched);

			if (direction == Direction.RIGHT) {
				for (int i = 0; i < matched.length(); i++) {
					board[start.row][start.col + i] = matched.charAt(i);
				}
			} else {
				for (int i = 0; i < matched.length(); i++) {
					board[start.row + i][start.col] = matched.charAt(i);
				}
			}

			char[][] clone = clone(board);
			boolean result = true;
			if (!words.isEmpty()) {
				result = solvePuzzle(clone, words);
			}
			if (!result) {
				words.add(matched);
			} else {
				print(clone);
				return true;
			}
		}
		return words.isEmpty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[10][];
		for (int i = 0; i < 10 && scanner.hasNextLine(); i++) {
			String str = scanner.nextLine();
			board[i] = str.toCharArray();
		}

		String[] words = scanner.nextLine().split(";");
		List<String> list = new ArrayList<>(words.length);
		Collections.addAll(list, words);
		solvePuzzle(board, list);
		scanner.close();
		System.out.println(output);
	}

	private static void print(char[][] board) {
		if (output.length() > 0) {
			return;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				output.append(board[i][j]);
			}
			output.append(System.lineSeparator());
		}
	}

	private static char[][] clone(char[][] board) {
		char[][] result = new char[board.length][];
		System.arraycopy(board, 0, result, 0, board.length);
		return result;
	}

	private static class Location {
		private final int row;
		private final int col;

		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private enum Direction {
		LEFT, RIGHT, UP, DOWN
	}
}
