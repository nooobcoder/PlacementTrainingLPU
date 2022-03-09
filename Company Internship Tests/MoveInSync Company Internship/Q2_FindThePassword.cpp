/*
Student A took Student B's Laptop and started playing with him by changing his password. B requested A to reveal the password , but A doesn't want to end the fun by revealing the password straight away, so he asked B to select a number N. Then he gave a set of N numbers, stating that if he takes the modulo of, sum of the given numbers with the smallest prime number from the given set of numbers if exists, else by finding the smallest prime divisor of sum, would give him the age of his loved ones. So spinning the given numbers that many times in an anticlockwise direction he will get the password for his device.

Example:

N = 6

Input : 90 45 37 80 1 46

Output : 80 1 46 90 45 37

N = 5

Input : 90 45 78 27 63

Output : 27 63 90 45 78

Input Format

8

90 45 37 80 3 2 1 46

Constraints

0 < sum(N) < 1000

Output Format

37 80 3 2 1 46 90 45

Sample Input 0

5
45 35 28 21 4
Sample Output 0

28 21 4 45 35
*/

#include <bits/stdc++.h>

using namespace std;
;

int calcSum(vector<int> arr) {
    int sum_of_elems{0};

    for (std::vector<int>::iterator it = arr.begin(); it != arr.end(); ++it)
        sum_of_elems += *it;

    return sum_of_elems;
}

int main() {
    int num = 0;
    cin >> num;
    vector<int> arr;

    for (int a = 0; a < num; ++a) {
        int temp{0};
        cin >> temp;
        arr.push_back(temp);
    }

    cout << calcSum(arr);
}
