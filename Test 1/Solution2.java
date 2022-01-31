import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] p = new int[n];
		for (int i = 0; i < n; ++i)
			p[i] = scanner.nextInt();

		Arrays.sort(p);

		int u = 0;
		int l = -1;
		int cIndex = 0;

		for (int i = 1; i < n; ++i) {
			if (u <= l && p[i] - p[l] > k)
				u = i;

			if (u > l && p[i] - p[u] > k) {
				++cIndex;
				l = i - 1;
				--i;
			}
		}

		if (l == -1 || p[n - 1] - p[l] > k) {
			++cIndex;
			l = n - 1;
		}

		System.out.println(cIndex);
		scanner.close();
	}
}
