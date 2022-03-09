/*
There is a drill in the army. The Army general wants to know the best cumulative power of his troops. Troops give the best results when the maximum different level of a soldier stands together. If a troop contains 2 same levels of a soldier their power becomes 0. Let assume there are x different levels in the army, You have to find the power of the best troop from the army given. Assume 1 soldier power to be 1 unit.

1) Input: army = "wpwkewe" (w,p,k,e : are diffrent levels of soilder) Output: 4 At max 4 is max power of any troop formed. (pwke)

2) Input: army = "afjbaifbi" Output: 5 At max 5 is max power of any troop formed. (fjbai)

Input Format

abcd

Constraints

string.length() > 0

Output Format

4

Sample Input 0

abbcd
Sample Output 0

3
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

void printdistinctsoldier() {
    string s;
    cin >> s;

    int length = s.size();

    unordered_map<char, int> m;
    int j = 0;

    int ans = 0;

    for (int i = 0; i < length; i++) {
        m[s[i]] += 1;
        while (m[s[i]] > 1) m[s[j]] -= 1, j += 1;

        ans = max(ans, i - j + 1);
    }

    cout << ans << "\n";
}

int main() {
    printdistinctsoldier();
}
