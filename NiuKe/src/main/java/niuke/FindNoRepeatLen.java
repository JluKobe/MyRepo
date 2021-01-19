package niuke;

import java.util.LinkedList;

/**
 * 找到字符串的最长无重复字符串长度
 */
public class FindNoRepeatLen {

    public static int maxLength(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i ++){
            if(list.contains(arr[i])){
                int j = list.indexOf(arr[i]);
                while (j >= 0){
                    list.removeFirst();
                    j --;
                }
            }

            list.add(arr[i]);
            ans = Math.max(ans, list.size());
        }
        return ans;
    }
}
