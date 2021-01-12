package niuke;

/**
 * 最长公共前缀
 */
public class MaxLenPublicStartString {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null) {
            return "";
        }

        if(strs.length <= 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        int len = Integer.MAX_VALUE;

        for(String s : strs) {
            len = Math.min(len, s.length()); //得到字符数组里面最短字符的长度
        }

        StringBuffer sb = new StringBuffer(len);

        //每个字符只需要遍历到最小长度即可，因为大于最小长度字符的那一部分不可能有公共
        for(int i = 0; i < len; i ++) {
            char temp = strs[0].charAt(i);

            for(int j = 0; j < strs.length; j ++) {
                char c = strs[j].charAt(i);
                if(c != temp) {//每个与第一个字符开始比较，也就是与下标为0的字符的元素比较。
                    return sb.toString();
                }
            }

            sb.append(temp);//相同就加进结果集
        }

        return sb.toString();
    }
}
