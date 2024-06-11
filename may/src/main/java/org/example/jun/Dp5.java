package org.example.jun;

import java.util.Arrays;
import java.util.OptionalInt;

public class Dp5 {

    public static void main(String[] args) {
        
        //String test ="((((((()))((()()))))";
        //String test = "(()";
        String test = "((())";
        int n = test.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            char c = test.charAt(i);
            if (c == '(') {
                dp[i] = 0;
            } else {
                if (i>0 && test.charAt(i-1) == '(') {
                    if (i>1) {  //这个是用来判断 (()
                        System.out.println("测试1");
                        dp[i] = dp[i-2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i > 0 && test.charAt(i-1) == ')') {
                    //这个判断除去已经保存的数据 判断前面是否存在 (
                    if (i - 1 - dp[i-1] >= 0 && test.charAt(i-1-dp[i-1]) == '(') {
                        if ( i - 1 - dp[i-1] -1 >= 0) {  //这个出现的条件是 ((())
                            dp[i] = dp[i-1] +2 +  dp[i - 1 - dp[i-1] -1];
                            System.out.println("1");
                        } else {   // 这个出现的条件是 (())
                            dp[i] = dp[i-1]+2;
                            System.out.println("测试");
                        }
                    }
                }
            }
        }
        OptionalInt max = Arrays.stream(dp).max();
        System.out.println(max);
    }
}
