package org.example.number;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // 假设有一个整数数组arr

        // 保存第一个元素
        int firstElement = arr[1];

        // 将数组中的元素向前移动一个位置
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // 将第一个元素放置在数组的最后一个位置
        arr[arr.length - 1] = firstElement;

        // 输出移动后的数组
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
