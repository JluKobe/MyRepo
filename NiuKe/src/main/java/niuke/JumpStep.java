package niuke;

/**
 * 跳台阶
 */
public class JumpStep {
    public int JumpFloor(int target) {
        int a = 1;
        int b = 2;
        if(target == 1) {
            return 1;
        }

        else if(target == 2) {
            return 2;
        }

        else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
