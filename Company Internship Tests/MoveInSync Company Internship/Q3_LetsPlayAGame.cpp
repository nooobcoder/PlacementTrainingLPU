/*
A and B are good friends and they do everything in a similar way. People started calling them like minded people, but they don't believe they're like minded. One day when they're feeling bored they decided to play a game to find out how similar they are. So both of them will write down some strings, if the strings contain a common substring of at least half the length of the string which is having the greatest length among the both then they will consider themselves as like minded as people say

Input Format

SUNRISE

ARISE

Constraints

1 < length(A) <1000

1 < length(B) <1000

Output Format

YES

Sample Input 0

RUSSIA
UKRAINE
Sample Output 0

NO
*/

#include <bits/stdc++.h>
using namespace std;

int largestSize{0};

int FsT(vector<string> arr) {
    int n = arr.size();

    string s = arr[0];
    largestSize = s.length();
    int len = s.length();

    string res = "";

    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j <= len; j++) {
            string stem = s.substr(i, j);
            int k = 1;
            for (k = 1; k < n; k++) {
                if (arr[k].length() > largestSize)
                    largestSize = arr[k].length();
                if (arr[k].find(stem) == std::string::npos) break;
            }

            if (k == n && res.length() < stem.length())
                res = stem;
        }
    }

    return res.size();
}
int main() {
    // vector<string> arr{"UKRAINE", "RUSSIA"};
    std::string line;
    std::vector<std::string> arr;

    while (getline(std::cin, line) && !line.empty()) {
        arr.push_back(line);
    }
    int stems = FsT(arr);
    largestSize = (largestSize / 2);
    if (stems <= largestSize)
        cout << "NO" << endl;
    else
        cout << "YES" << endl;
}
