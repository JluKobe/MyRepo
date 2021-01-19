package niuke;

import java.util.*;

public class FindMaxK {

    public static void main(String[] args) {
        FindMaxK findMaxK = new FindMaxK();
        int[] nums = {1,3,5,2,2};
        int n = 5;
        int k = 3;
        System.out.println(findMaxK.findKth(nums, n, k));
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);

        Set set = new HashSet();
        for(int i : a) {
            set.add(i);
        }

        int temp = 0;
        int num = 0;

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            temp ++;
            if(temp == K) {
                num = (int)iterator.next();
                break;
            }
            iterator.next();
        }

        return num;
    }
}