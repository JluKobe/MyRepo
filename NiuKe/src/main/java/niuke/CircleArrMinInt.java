package niuke;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 */
public class CircleArrMinInt {
    public int minNumberInRotateArray(int [] array) {
        if(array.length <= 0) {
            return 0;
        }

        Arrays.sort(array);

        return array[0];
    }
}
