package org.example.jun;

import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] matrix = {{5,2},{1,6}};
        int k=1;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i<m; i++) {
            for (int j = 0;j<n;j++) {
                dp[i+1][j+1] = matrix[i][j]^dp[i][j+1]^dp[i+1][j]^dp[i][j];
                if (  pq.size()< k) {
                    pq.offer(dp[i+1][j+1]);
                }else if (dp[i+1][j+1] > pq.peek()) {
                    pq.poll();
                    pq.offer(dp[i+1][j+1]);
                }
            }
        }
        System.out.println(pq.peek());
    }
}
