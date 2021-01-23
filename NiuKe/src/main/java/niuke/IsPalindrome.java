package niuke;

/**
 * 回文数字
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome (int x) {
        String str = String.valueOf(x);
        boolean flag = true;

        for(int i = 0, j = str.length() - 1; i < j; i ++, j --) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);

            if(c1 != c2) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
