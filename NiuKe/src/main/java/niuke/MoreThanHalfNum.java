package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int max = array.length / 2;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : array) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            }

            else {
                map.put(i, map.get(i) + 1);
            }
        }

        Set<Integer> set = map.keySet();
        for(Integer i : set) {
            int value = map.get(i);
            if(value > max) {
                result = i;
                break;
            }
        }

        return result;
    }
}
