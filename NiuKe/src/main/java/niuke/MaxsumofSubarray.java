package niuke;

/**
 * 子数组最大累加和
 */
public class MaxsumofSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int[] arr2 = {-2, 1, 3, 5, -2, 6, -1};

        System.out.println(maxsumofSubarray2(arr2));
        System.out.println(maxsumofSubarray3(arr2));
    }

    public static int maxsumofSubarray (int[] arr) {
        // write code here
        int max = 0;

        for(int i = 0; i < arr.length - 1; i ++) {
            int tempMax = arr[i];
            for(int j = i + 1; j < arr.length; j ++) {
                tempMax = tempMax + arr[j];
                if(tempMax > max) {
                    max = tempMax;
                }
            }
        }

        return max;
    }

    public static int maxsumofSubarray2 (int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            cur += temp;
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    public static int maxsumofSubarray3 (int[] array){
        int max = Integer.MIN_VALUE;
        int current = 0;

        for(int i = 0; i < array.length; i ++) {
            int temp = array[i];

            current += temp;

            max = Math.max(max, current);

            if(current < 0) {
                current = 0;
            }
        }

        return max;
    }
}
