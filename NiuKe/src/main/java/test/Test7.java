package test;

public class Test7 {
    public static void main(String[] args) {
        String str = "9D";

        if(str.endsWith("d") || str.endsWith("D")) {
            String hoursStr = str.substring(0, str.length() - 1);
            int hours = Integer.valueOf(hoursStr) * 60;
            str = String.valueOf(hours);
        }

        System.out.println(str);
    }
}
