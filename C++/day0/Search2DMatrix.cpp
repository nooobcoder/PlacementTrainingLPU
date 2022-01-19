// Source: https://leetcode.com/problems/search-a-2d-matrix/

#include <bits/stdc++.h>

using namespace std;

class Solution {
   public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int i = 0;
        int j = matrix[0].size() - 1;

        while (i < n && j >= 0) {
            // 1st condition
            if (matrix[i][j] == target)
                return true;  // Target Found

            // Either we go left or down
            // 2nd condition
            if (matrix[i][j] > target) {
                j--;
            }
            // 3rd condition
            // Going downwards
            else if (matrix[i][j] < target) {
                i++;
            }
        }

        return false;
    }
};

// Driver Code
int main() {
    vector<vector<int>> matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 13;

    Solution ob = Solution();
    int result = ob.searchMatrix(matrix, target);
    cout << result;

    return 0;
}
