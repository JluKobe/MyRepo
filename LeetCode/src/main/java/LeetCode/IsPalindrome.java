package LeetCode;

/**
 * 回文数
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        boolean flag = true;

        String str = String.valueOf(x);
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
