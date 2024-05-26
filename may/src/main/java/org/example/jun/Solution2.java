package org.example.jun;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {4, 9}, {3, 7}};
        int k = 2;
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int[][] prefixXors = new int[m + 1][n + 1];
        int[] allXos = new int[total];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixXors[i+1][j+1] = prefixXors[i][j + 1] ^ prefixXors[i + 1][j] ^ prefixXors[i][j] ^ matrix[i][j];
                allXos[i*n+j]  = prefixXors[i+1][j+1];
            }
        }
        Arrays.sort(allXos);
        System.out.println(total - k);
    }
}