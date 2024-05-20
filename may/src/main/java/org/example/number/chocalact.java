package org.example.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class chocalact {

    public static void main(String[] args) {
        int[] prices = {98,54,6,34,66,63,52,39};
        int money = 62;

        Arrays.sort(prices);
        if (money<prices[0] + prices[1]) {
            System.out.println(money);
        }
         money -= (prices[0] + prices[1]);
        System.out.println(money);



//        ArrayList<Integer> integers = new ArrayList<>();
//
//        for (int i=0 ;i< prices.length;i++) {
//            for (int j= i+1; j<prices.length;j++) {
//                if (prices[i]+prices[j] <= money) {
//                    Integer price = money-prices[j]-prices[i];
//                    integers.add(price);
//                }
//            }
//        }
//        Collections.sort(integers);
//        System.out.println(integers);
//        if (integers.isEmpty()) {
//
//            System.out.println(money);
//        }else {
//
//            System.out.println(integers.get(integers.size()-1));
//        }
    }
}
