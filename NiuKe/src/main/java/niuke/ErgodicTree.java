package niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序，中序，后序遍历
 */
public class ErgodicTree {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t3 = new TreeNode();
        TreeNode t4 = new TreeNode();
        t1.val = 1;
        t2.val = 2;
        t3.val = 3;
        t4.val = 4;
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
    }

    public int[][] threeOrders (TreeNode root) {
        // write code here
        getBefore(root);
        getMiddle(root);
        getPost(root);
        int[][] result = new int[3][];
        int[] temp1 = new int[list1.size()];
        int[] temp2 = new int[list2.size()];
        int[] temp3 = new int[list3.size()];
        getResult(temp1, list1);
        getResult(temp2, list2);
        getResult(temp3, list3);
        result[0] = temp1;
        result[1] = temp2;
        result[2] = temp3;

        return result;
    }

    public void getResult(int[] temp, List<Integer> list) {
        for(int i = 0; i < list.size(); i ++) {
            temp[i] = list.get(i);
        }
    }

    public void getBefore(TreeNode root) {
        if(root == null) return;
        list1.add(root.val);
        getBefore(root.left);
        getBefore(root.right);
    }

    public void getMiddle(TreeNode root) {
        if(root == null) return;
        getMiddle(root.left);
        list2.add(root.val);
        getMiddle(root.right);
    }

    public void getPost(TreeNode root) {
        if(root == null) return;
        getPost(root.left);
        getPost(root.right);
        list3.add(root.val);
    }
}
