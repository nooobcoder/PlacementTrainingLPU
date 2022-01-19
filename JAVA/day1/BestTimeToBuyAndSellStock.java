package JAVA.day1;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/* STOCK PRICE = 7
ARR =            7 1 5 3 6 4 Selling
LOWEST RATE =    7 1 1 1 1 1 Buying
                 - - 4 2 5 3 Profit
*/


public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for (int price : prices) {
            int money = price - min;
            if (money > max) max = money;
            if (price < min) min = price;
        }

        return max;
    }
}
