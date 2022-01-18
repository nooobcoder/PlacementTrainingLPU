package day0;

import java.util.PriorityQueue;

// Source: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class KthLargestElement {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        while (--k > 0) {
            pq.poll();
        }
        return pq.peek();
    }
}
