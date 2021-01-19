package niuke;

/**
 * 字符串转换为整数
 */
public class StringToInt {
    public static int atoi (String str) {
        // write code here

        if("".equals(str) || str == null) {
            return 0;
        }

        String temp = str.trim();

        char[] chars = temp.toCharArray();
        int i = 0;
        for(; i < chars.length; i ++) {
            if(chars[i] != '+' && chars[i] != '-' && (chars[i] < '0' || chars[i] > '9')) {
                break;
            }
        }

        try {
            return Integer.valueOf(temp.substring(0, i));
        } catch (Exception e) {
            if(temp.charAt(0)=='-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
    }
}
