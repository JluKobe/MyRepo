package niuke;

/**
 * 旋转字符串
 */
public class RotateStr {
    public static void main(String[] args) {
        System.out.println(solve("youzan", "zanyou"));
    }

    public static boolean solve (String A, String B) {
        // write code here

        if(A.equals(B)) {
            return true;
        }

        if(A.length() != B.length()) {
            return false;
        }

        boolean flag = false;

        for(int i = 0; i < A.length(); i ++) {
            StringBuffer sb = new StringBuffer();
            if(i == 0) {
                continue;
            }
            sb.append(A.substring(i)).append(A, 0, i);
            String temp = sb.toString();
            if(temp.equals(B)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
