package niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的K个数
 */
public class MinKNum {

    public static void main(String[] args) {
        int[] input = {2,51,12,95,42,52,76,77,23,81,71,41,2,23,43,4,64,22,71,96,1,87,51,91,67,16,58,11,44,38,63,14,4,69,88,49,92,91,9,15,17,74,21,91,24,78,62,50,82,26,53,18,25,14,94,79,44,11,36,38,44,53,9,34,58,6,50,82,81,50,36,1,6,61,9,47,33,47,84,41,57,48,73,18};
        int k = 4;

        MinKNum t = new MinKNum();
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
