package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        int[] A = new int[10000];
        int[] B = {1};

//        merge(A, 0, B, 1);

//        System.out.println("test");
//        System.out.println("test");
//        System.out.println("test");

        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int[] arr2 = {-2, 1, 3, 5, -2, 6, -1};
        int[] arr3 = {-9,-5,-2,-8,-1,-6};

        System.out.println(maxsumofSubarray4(arr));
        System.out.println(maxsumofSubarray4(arr2));
        System.out.println(maxsumofSubarray4(arr3));
    }

    public static void merge(int A[], int m, int B[], int n) {
        List<Integer> list = new ArrayList<>();
        for(int i : A) {
            list.add(i);
        }

        for(int i : B) {
            list.add(i);
        }

        Collections.sort(list);

        for(int i = 0; i < m + n; i ++) {
            A[i] = list.get(i);
        }
    }

    public static int maxsumofSubarray4 (int[] array){
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
