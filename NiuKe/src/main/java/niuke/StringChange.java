package niuke;

/**
 * 字符串变形
 */
public class StringChange {

    public static void main(String[] args) {
        StringChange t = new StringChange();
        String s1 = "  is a   ";
        int n1 = 9;
        System.out.println(t.trans(s1, n1));
    }

    //This is a sample  16
    public String trans(String s, int n) {
        if(n == 0) {
            return "";
        }

        if(n == 1) {
            return s;
        }

        int countStart = 0;
        int countEnd = 0;
        for(int i = 0; i < n; i ++) {
            char temp = s.charAt(i);
            if(temp != ' ') {
                break;
            }

            if(temp == ' ') {
                countStart ++;
            }
        }

        for(int i = n - 1; i >= 0; i --) {
            char temp = s.charAt(i);
            if(temp != ' ') {
                break;
            }

            if(temp == ' ') {
                countEnd ++;
            }
        }

        String start = s.substring(n - countEnd);
        String end = s.substring(0, countStart);
        StringBuffer sb = new StringBuffer();
        s = s.trim();

        String[] str = s.split(" ");
        sb.append(start);

        for(int i = str.length - 1; i >= 0; i --) {
            String tempStr = getStr(str[i]);
            if(i != 0) {
                sb.append(tempStr).append(" ");
            }

            if(i == 0) {
                sb.append(tempStr);
            }
        }

        sb.append(end);

        return sb.toString();
    }

    public String getStr(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                sb.append(String.valueOf(c).toUpperCase());
            }

            if(c >= 'A' && c <= 'Z') {
                sb.append(String.valueOf(c).toLowerCase());
            }
        }
        return sb.toString();
    }
}
