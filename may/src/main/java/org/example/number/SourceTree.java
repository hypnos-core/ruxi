package org.example.number;

public class SourceTree {


    public static void main(String[] args) {

        String s = "01000111000011111";
        int ans = 0, index = 0, zero = 0, one = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1'){
                one++;
                ans = Math.max(ans,Math.min(zero,one)*2);
            }else if (i==0||s.charAt(i-1)=='1'){
                one=0;
                zero=1;
            }else {
                zero++;
            }
        }
        System.out.println(ans);


//        int res = 0;
//        int n = s.length();
//        int[] count = new int[2];
//
//        for (int i =0;i<n;i++){
//            if (s.charAt(i)=='1'){
//                count[1]++;
//                res = Math.max(res,2*Math.min(count[0],count[1]));
//            }else if (i==0 || s.charAt(i-1)=='1'){
//                count[0] = 1;
//                count[1] = 0;
//            }else {
//                count[0]++;
//            }
//        }


    }
}
