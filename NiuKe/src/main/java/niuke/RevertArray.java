package niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转数组
 */
public class RevertArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        solve(6, 2, a);
    }

    public static int[] solve (int n, int m, int[] a) {
        if(m == 0) {
            return a;
        }

        if(m > n) {
            m = m % n;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = n - m; i < n; i ++) {
            list.add(a[i]);
        }

        for(int i = 0; i < n - m; i ++) {
            list.add(a[i]);
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i ++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
