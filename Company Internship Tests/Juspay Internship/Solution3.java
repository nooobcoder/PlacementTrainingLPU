/* You are given a maze with N cells.Each cell may have multiple entry points but not more than one exit(ie.entry/exit points are unidirectional doors like valves).

The cells are named with an integer value from 0 to N-1.

Function Description:

The sum of the largest sum cycle in the maze.Return-1 if there are no cycles.Sum of a cycle is the sum of node number of all nodes in that cycle.

INPUT FORMAT

1. An integer T,denoting the number of testcases,followed by 2 T lines,as each testcase will contain 2 lines.

2. The first line of each testcase has the number of cells N.

3. The second line of each testcase has a list of N values of the edge[]array.edge[i]contains the cell number that can be reached from cell'i'in one step.edge[i]is-1 if the'i'th cell doesn'thave an exit.

OUTPUT FORMAT

For each testcase given,output a single line that denotes the sum of the largest sum cycle.

SAMPLE INPUT

1 23 4 4 1 4 13 8 8 8 0 8 14 9 15 11-1 10 15 22 22 22 22 22 21

SAMPLE OUTPUT

45 */

import java.util.*;

public class Solution3 {
	public static int solution(int arr[]) {
		ArrayList<Integer> sum = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> path = new ArrayList<>();
			int j = i;
			int tempSum = 0;
			while (arr[j] < arr.length && arr[j] != i && arr[j] != -1 && !path.contains(j)) {
				path.add(j);
				tempSum += j;
				j = arr[j];
				if (arr[j] == i) {
					tempSum += j;
					break;
				}
			}
			if (j < arr.length && i == arr[j])
				sum.add(tempSum);
		}
		if (sum.isEmpty())
			return -1;
		return Collections.max(sum);
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
