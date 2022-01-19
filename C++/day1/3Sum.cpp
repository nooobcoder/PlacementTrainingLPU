// Source: https://leetcode.com/problems/3sum/
/*
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Sort the input - [-4, -1, -1, 0, 1, 2]
Select -4 (target)
Rest = [-1, -1, 0, 1, 2]
Pick two from rest such that = -(target)
Pick -1 (rest[0]) and add a number that = 4, if that number does not exist in the array,
go to next number rest[1]
*/

#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<vector<int>> triplets(vector<int> &nums) {
        if (nums.size() <= 2) return {};

        sort(nums.begin(), nums.end());
        vector<vector<int>> result;

        for (int i = 0; i < nums.size() - 2; i++) {
            int curr1 = nums[i];
            int start = i + 1, end = nums.size() - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;
                if (curr1 + nums[start] + nums[end] == 0) {
                    result.push_back({curr1, nums[start], nums[end]});
                    start++;
                    end--;

                    while (start < end && nums[start - 1] == nums[start])
                        start++;

                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (curr1 + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    // curr1 + nums[start] + nums[end] > 0
                    end--;
                }
            }
            while (i < nums.size() - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
};

int main() {}