package org.example.jun;

public class dp2 {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        int n = nums.length;
        int[] d = new int[n+1];
        int len = 1;
        d[len] =  nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1,right = len + 1,mid;
                while (left < right) {
                    mid = left + (right - left) /2;
                    if (d[mid]<nums[i]) {
                        left = mid +1;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        System.out.println(len);

    }
}
