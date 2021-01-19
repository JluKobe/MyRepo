package niuke;

/**
 * 最长公共子串
 */
public class FindMaxLenSubStr {

    public static void main(String[] args) {
//        "1AB2345CD","12345EF"
        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        System.out.println(LCS(str1, str2));
    }

    public static String LCS (String str1, String str2) {
        int[][] arr = new int[str1.length()][str2.length()];
        int max = 0;
        int startLocal = 0;

        for(int i = 0; i < str1.length(); i ++) {
            for(int j = 0; j < str2.length(); j ++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }

                    else {
                        arr[i][j] = 1;
                    }

                    if(arr[i][j] > max) {
                        max = arr[i][j];
                        startLocal = i - max + 1;
                    }
                }

                else {
                    arr[i][j] = 0;
                }
            }
        }

        return str1.substring(startLocal, startLocal + max);
    }

    public static String getSubString(String str1, String str2) {
        int[][] arr = new int[str1.length()][str2.length()];
        int max = 0;
        int local = 0;

        for(int i = 0; i < str1.length(); i ++) {
            for(int j = 0; j < str2.length(); j ++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }

                    else {
                        arr[i][j] = 1;
                    }

                    if(max < arr[i][j]) {
                        max = arr[i][j];
                        local = i;
                    }
                }

                else {
                    arr[i][j] = 0;
                }
            }
        }

        return str1.substring(local, local + max);
    }
}
