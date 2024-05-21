package org.example.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class NumberTest1 {


    public static void main(String[] args) {

        int[] player1 = {6,9,10,4,4};
        int[] player2 = {8,10,5,1,7};



        int result1 = 0;
        int result2 = 0;
        int p=0,w=0;
        int t=0,q=0;
        for (int i : player1) {
            if (0<p&&p<=2) {
                i*=2;
                p--;
            }
            if (i==10) {
                p = 2;
            }
            result1+=i;
        }

        for (int i : player2) {

            if (0<t&&t<=2) {
                i*=2;
                t--;
            }
            if (i==10) {
                t = 2;
            }
            result2+=i;
        }

        System.out.println(result1 +";"+result2);
        if (result1>result2) System.out.println(1);
            else System.out.println(2);

    }

}
