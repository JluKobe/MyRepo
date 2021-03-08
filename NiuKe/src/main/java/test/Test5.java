package test;

public class Test5 {
    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(search(A, 1));
    }

    public static int search (int[] A, int target) {
        int count = -1;

        for(int i = 0; i < A.length; i ++) {
            if(A[i] == target) {
                count = i;
                break;
            }
        }

        return count;
    }
}
