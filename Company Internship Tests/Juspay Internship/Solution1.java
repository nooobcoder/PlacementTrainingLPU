/* You are given a maze with N cells.Each cell may have multiple entry points but not more than one exit(ie.entry/exit points are unidirectional doors like valves).

The cells are named with an integer value from 0 to N-1.

You have to find:

Find the node number of maximum weight node(Weight of a node is the sum of node numbers of all nodes pointing to that node)

INPUT FORMAT

1. An integer T,denoting the number of testcases,followed by 2 T lines,as each testcase will contain 2 lines.

2. The first line of each testcase has the number of cells N.

3. The second line of each testcase has a list of N values of the edge[]array.edge[i]contains the cell number that can be reached from of cell'i'in one step.edge[i]is-1 if the'i'th cell doesn'thave an exit.

OUTPUT FORMAT

First line denotes the node number with maximum wight node.

Sample Input

1 23 4 4 1 4 13 8 8 8 0 8 14 9 15 11-1 10 15 22 22 22 22 22 21

Sample Output

22 */

import java.util.*;

public class Solution1 {
	static int solution(int[] array) {
		int n = array.length;
		int count[] = new int[n];
		Arrays.fill(count, 0);
		for (int i = 0; i < n; i++) {
			if (array[i] != -1)
				count[array[i]] += i;
		}
		int maxWeight = 0;
		int nodeNumber = 0;
		for (int i = 0; i < n; i++) {
			if (count[i] > maxWeight) {
				maxWeight = count[i];
				nodeNumber = i;
			}
		}
		return nodeNumber;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int loop = 0; loop < testCases; loop++) {
			int numOfBlocks = scanner.nextInt();
			int array[] = new int[numOfBlocks];
			int src, des;
			for (int i = 0; i < numOfBlocks; i++) {
				array[i] = scanner.nextInt();
			}
			System.out.println(solution(array));
		}
		scanner.close();
	}
}
