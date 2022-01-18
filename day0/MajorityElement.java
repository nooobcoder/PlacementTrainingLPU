package day0;

// Source: https://leetcode.com/problems/majority-element/

// Using Boyer-Moore Majority Voting Algorithm (https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/)
// Complexity: O(n)
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int element = getCandidate(nums);
        int majorityCount = 0;

        for (int num : nums) {
            if (num == element) {
                majorityCount++;
            }
        }

        if (majorityCount > nums.length / 2)
            return element;
        return -1;
    }

    public int getCandidate(int[] num) {
        int majorityElementIndex = 0;
        int majorityCount = 0;

        for (int i = 0; i < num.length; ++i) {
            if (num[i] == num[majorityElementIndex]) {
                majorityCount++;
            } else {
                majorityCount--;
            }
            if (majorityCount == 0) {
                majorityElementIndex = i;
                majorityCount = 1;
            }
        }

        return num[majorityElementIndex];
    }

    public static void main(String[] args) {

    }
}
