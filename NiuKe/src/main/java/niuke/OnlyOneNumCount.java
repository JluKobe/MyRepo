package niuke;

import java.util.*;

/**
 * 数组中只出现一次的数字
 */
public class OnlyOneNumCount {

    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        FindNumsAppearOnce(array, num1, num2);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
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
            if(list.size() == 2) {
                break;
            }

            if(map.get(i) == 1) {
                list.add(i);
            }
        }

        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
