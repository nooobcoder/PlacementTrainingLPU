#include <iostream>
using namespace std;

// Source: https://www.codechef.com/problems/SUBPERM

int main() {
    int tc{0};
    cin >> tc;

    while (tc--) {
        int i, j;
        cin >> i >> j;

        if (i == 1) {
            cout << "1";
        } else if (j == 1) {
            cout << "-1";
        } else {
            for (int k = j; k <= i; ++k) {
                cout << k << " ";
            }
            for (int k = 1; k < j; ++k) {
                cout << k << " ";
            }
        }
        cout << endl;
    }

    return 0;
}
