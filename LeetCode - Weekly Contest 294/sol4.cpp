/*
6077. Sum of Total Strength of Wizards

As the ruler of a kingdom, you have an army of wizards at your command.

You are given a 0-indexed integer array strength, where strength[i] denotes the strength of the ith wizard. For a contiguous group of wizards (i.e. the wizards' strengths form a subarray of strength), the total strength is defined as the product of the following two values:

The strength of the weakest wizard in the group.
The total of all the individual strengths of the wizards in the group.
Return the sum of the total strengths of all contiguous groups of wizards. Since the answer may be very large, return it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.

*/

#include <bits/stdc++.h>

using namespace std;

class Solution {
    // Use long long int
   private:
    long smallestElem(vector<long> arr) {
        // Get the smallest element in the array
        long smallest = arr[0];
        for (long i = 1; i < arr.size(); i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    long sumElem(vector<long> arr) {
        // Calculate the sum of the elements in the vector
        long sum = 0;
        for (long i = 0; i < arr.size(); i++) {
            sum += arr[i];
        }
        return sum;
    }

   public:
    int totalStrength(vector<int> arr) {
        vector<long> t;
        long n = arr.size();
        long tot = 0;
        for (long i = 0; i < n; i++) {
            for (long j = i; j < n; j++) {
                long total = 0;
                for (long k = i; k <= j; k++) {
                    t.push_back(arr[k]);
                }
                tot += smallestElem(t) * sumElem(t);
                t.clear();
            }
        }
        return tot;
    }
};

int main() {
    vector<int> arr = {1, 3, 1, 2};
    Solution obj;
    cout << obj.totalStrength(arr);
    return 0;
}
