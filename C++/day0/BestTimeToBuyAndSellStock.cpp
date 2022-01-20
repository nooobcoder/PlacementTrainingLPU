// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/* STOCK PRICE = 7
ARR =            7 1 5 3 6 4 Selling
LOWEST RATE =    7 1 1 1 1 1 Buying
                 - - 4 2 5 3 Profit
*/

#include <bits/stdc++.h>
#define endl '\n'

using namespace std;

class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size(), maxa = INT_MIN;
        int mini = INT_MAX;
        for (int i = 0; i < n; i++) {
            mini = min(prices[i], mini);
            maxa = max(maxa, prices[i] - mini);
        }
        return maxa;
    }
};

int main() {
    Solution ob = Solution{};
    vector<int> arr = {7, 1, 5, 3, 6, 4};

    cout << ob.maxProfit(arr) << endl;

    return 0;
}
