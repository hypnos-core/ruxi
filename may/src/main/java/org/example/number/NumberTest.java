package org.example.number;

import java.util.LinkedList;

public class NumberTest {
    public static void main(String[] args) {
        int[] arr = {1,4,8,9,2,3};
        int n = arr.length;
        int ret=arr[0];
        int count = 0;
        int k = 2;
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i=1;i<n ; i++) {
            integers.offer(arr[i]);
        }

        while (true) {
            //获取第一个值
            int temp = integers.poll();
            if (ret>temp) {
                count ++;
                integers.offer(temp);
            } else {
                integers.offer(ret);
                ret=temp;
                count=1;
            }
            if (count == k || count>n-1)
                break;
        }
        System.out.println(ret);
    }
}
