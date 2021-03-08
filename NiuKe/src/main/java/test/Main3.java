package test;

public class Main3 {
    public static void main(String[] args) {
        pri();
    }

    public static void pri() {
        String str = "a*ba#1";
        for(int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(c <= 'z' && c >='a') {
                System.out.println(c);
            }
        }
    }
}
