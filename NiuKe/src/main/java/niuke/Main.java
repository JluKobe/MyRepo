package niuke;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        int M = 7;
        int N = 2;
//        System.out.println(t.solve(M, N));
        int k = Integer.parseInt("7", 2);
        System.out.println(k);
    }

    public String solve (int M, int N) {
        // write code here
        String s = String.valueOf(M);
        int result = Integer.parseInt(s, N);
        return String.valueOf(result);
    }
}
