package niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的K个数
 */
public class MinKNum {

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;

        MinKNum t = new MinKNum();
        ArrayList<Integer> list = t.GetLeastNumbers_Solution(input, k);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length) {
            return list;
        }

        else {
            for(int i = 0; i < k; i ++) {
                list.add(input[i]);
            }
            return list;
        }
    }
}
