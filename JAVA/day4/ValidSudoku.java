package JAVA.day4;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Use HashSets whenever you need to look out for unique values. They search in constant time.
        // https://www.geeksforgeeks.org/hashset-add-method-in-java/#:~:text=util.,already%20present%20in%20the%20HashSet.
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {

            for (int j = 0; j < 9; ++j) {
                char current_val = board[i][j];
                if (current_val != '.') {
                    if (!seen.add(current_val + " found in row " + i) ||
                            !seen.add(current_val + " found in column " + j) ||
                            !seen.add(current_val + " found in sub box " + i / 3 + " - " + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
