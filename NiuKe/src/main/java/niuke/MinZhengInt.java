package niuke;

import java.util.Arrays;

/**
 * 数组中为出现的最小正整数
 */
public class MinZhengInt {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(minNumberdisappered(array));
    }

    public static int minNumberdisappered (int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int result = 0;
        for(int i : arr) {
            if(i > 0 && i == count) {
                count ++;
                continue;
            }

            if(i > 0 && i != count) {
                result = count;
                break;
            }
        }

        if(result == 0) {
            result = arr[arr.length - 1] + 1;
        }

        return result;
    }
}
