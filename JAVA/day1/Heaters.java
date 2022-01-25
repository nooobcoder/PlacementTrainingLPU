package JAVA.day1;

import java.util.Arrays;

// Source: https://leetcode.com/problems/heaters/

public class Heaters {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int heaters[] = {2};
        int result = findRadius(houses, heaters);
        System.out.println("result::" + result);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < houses.length) {
            if (houses[i] <= heaters[j]) { //if house is located before heater j.
                if (j == 0) { // corner case when the heater is the first  one
                    ans = Math.max(ans, heaters[j] - houses[i]);
                    i++;
                    continue;
                }
            } else { // if house is located after some heater,
                while (j != heaters.length - 1 && heaters[j] < houses[i]) { // then find a heater that stands after the house
                    j++;
                }
                if (j == 0 || heaters[j] < houses[i]) { // corner cases if j is 0 or there is no more heaters
                    ans = Math.max(ans, houses[i] - heaters[j]);
                    i++;
                    continue;
                }
            }
            int dist = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]); // if house is located between jth and j-1th heaters
            ans = Math.max(ans, dist);
            i++;
        }

        return ans;
    }

}
