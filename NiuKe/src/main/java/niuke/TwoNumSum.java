package niuke;

/**
 * 两数之和
 */
public class TwoNumSum {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 4};
        int target = 6;

        TwoNumSum t = new TwoNumSum();
        int[] result = t.twoSum(numbers, target);

    }

    public int[] twoSum (int[] numbers, int target) {
        int[] result = new int[2];
        boolean flag = false;

        for(int i = 0; i < numbers.length - 1; i ++) {
            if(flag) {
                break;
            }

            for(int j = i + 1; j < numbers.length; j ++) {
                if((numbers[i] + numbers[j]) == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    flag = true;
                    break;
                }
            }
        }

        return result;
    }
}
