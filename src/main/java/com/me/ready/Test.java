package com.me.ready;

import java.util.HashMap;
import java.util.Map;

/**
 * @Autor syl
 * @Date 2019/2/25 20:42
 **/
public class Test {

    public static void main(String[] args) {
        find(new int[]{1, 3, 5, 7, 9}, 12);
    }

    public static void findSum(int[] num, int sum) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            left = i;
            right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }
            if (curSum == sum) {
                for (int j = left; j < right; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void find(int[] numbers, int targetNum) {
        // TODO
        int left = 0;
        int sum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (sum < targetNum) {
                sum += numbers[i];
            } else if (sum > targetNum) {
                sum -= numbers[left];
                left++;
                i--;
            } else {
                for (int j = left; j < i; j++) {
                    System.out.print(numbers[j] + " ");
                }
                break;
            }
        }
        System.out.println();
    }
}
