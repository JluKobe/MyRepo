package test;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(thenumberof0(1000000000));
    }

    public static long thenumberof0 (long n) {
        long result = 1L;
        for(int i = 1; i <= n; i ++) {
            result = result * i;
        }

        String str = String.valueOf(result);
        long len1 = str.length();
        str = str.trim();
        long len2 = str.length();
        return len1 - len2;
    }
}
