package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mArr = sc.nextLine().split(",");
        String[] nArr = sc.nextLine().split(",");
        int k = sc.nextInt();

        method(mArr, nArr, k);

        sc.close();
    }

    public static void method(String[] mArr, String[] nArr, int k) {
        CountClass[] countClasses = new CountClass[mArr.length];
        for(int i = 0; i < mArr.length; i ++) {
            countClasses[i] = new CountClass(Integer.valueOf(mArr[i]), Integer.valueOf(nArr[i]));
        }

        Arrays.sort(countClasses);

        for(int i = 0; i < countClasses.length; i ++) {
            if(k >= countClasses[i].m && countClasses[i].n > countClasses[i].m) {
                k = k + (countClasses[i].n - countClasses[i].m);
            }
        }

        System.out.println(k);
    }

    static class CountClass implements Comparable<CountClass> {
        int m;
        int n;

        CountClass(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public int compareTo(CountClass o) {
            if(m > o.m) {
                return 1;
            }

            if(m < o.m) {
                return -1;
            }

            if(n > o.n) {
                return -1;
            }

            if(n < o.n) {
                return 1;
            }

            return 0;
        }
    }
}
