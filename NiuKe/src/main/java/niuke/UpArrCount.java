package niuke;

/**
 * 数字在升序数组中出现的次数
 */
public class UpArrCount {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int i : array) {
            if(i == k) {
                count ++;
            }

            if(i > k) {
                break;

            }        }

        return count;
    }
}
