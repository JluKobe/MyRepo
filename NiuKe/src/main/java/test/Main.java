package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String result = getStr(str);
        System.out.println(result);

        sc.close();
    }

    public static String getStr(String str) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0'&& c <= '9') || c == '-' || c == ' ') {
                sb.append(c);
            }
        }

        str = sb.toString();
        StringBuffer sbTemp = new StringBuffer();
        StringBuffer sbResult = new StringBuffer();

        for(int i = 0; i < str.length();) {
            char c = str.charAt(i);
            if(c == '-') {
                sbTemp.append(c);
            }

            if(c != '-') {
                sbTemp.delete(0, sbTemp.length());
            }

            if(sbTemp.length() > 1) {
                sbResult.append(" ");
            }

            else {
                sbResult.append(c);
            }

            i ++;
        }

        String[] strArr = sbResult.toString().split(" ");
        String[] resultArr = new String[strArr.length];

        for(int i = 0; i < strArr.length; i ++) {
            String temp = strArr[i];
            if(temp.startsWith("-")) {
                temp = temp.substring(1);
            }

            if(temp.endsWith("-")) {
                temp = temp.substring(0, temp.length() - 1);
            }

            resultArr[i] = temp;
        }

        StringBuffer result = new StringBuffer();

        for(int i = resultArr.length - 1; i >= 0; i --) {
            String strTemp = resultArr[i];
            if("".equals(strTemp)) {
                continue;
            }

            if(i != 0) {
                result.append(strTemp).append(" ");
            }

            if(i == 0) {
                result.append(strTemp);
            }
        }

        return result.toString();
    }
}
