package org.example.jun;

public class dp1 {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        int n = nums.length;
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0;j<i; j++) {
                if (nums[i] >nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    res = Math.max(res,dp[i]);
                }
            }
        }
        System.out.println(res);
    }
}
