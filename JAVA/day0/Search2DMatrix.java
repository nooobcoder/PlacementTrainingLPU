package JAVA.day0;

// https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int start, end, mid, m, n, element;
        m = matrix.length;
        n = matrix[0].length;
        start = 0;
        end = m * n - 1;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            element = matrix[mid / n][mid % n];

            if (target == element) {
                return true;
            } else if (target < element) {
                end = mid;
            } else {
                start = mid;
            }
        }


        element = matrix[start / n][start % n];
        if (target == element) {
            return true;
        }

        element = matrix[end / n][end % n];
        if (target == element) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
