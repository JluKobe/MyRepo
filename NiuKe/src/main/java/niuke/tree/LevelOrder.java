package niuke.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树层次遍历
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode();
        TreeNode r2 = new TreeNode();
        TreeNode r3 = new TreeNode();
        TreeNode r4 = new TreeNode();
        TreeNode r5 = new TreeNode();
//        TreeNode r6 = new TreeNode();
//        TreeNode r7 = new TreeNode();

        r1.val = 1;
        r2.val = 2;
        r3.val = 3;
        r4.val = 4;
        r5.val = 5;

        r2.left = r4;
        r3.right = r5;;
        r1.left = r2;
        r1.right = r3;

        levelOrder(r1);
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //树为空，返回空list
        if(root==null) {
            return result;
        }

        //使用队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        //使用双重循环，外循环当队列非空
        while(!queue.isEmpty()){

            //队列大小
            int size = queue.size();

            ArrayList<Integer> r = new ArrayList<Integer>();

            //内循环，当队列长度非0
            while(size!=0){
                TreeNode cur = queue.remove();
                r.add(cur.val);

                if(cur.left!=null) {
                    queue.add(cur.left);
                }

                if(cur.right!=null) {
                    queue.add(cur.right);
                }

                size--;
            }

            result.add(r);
        }

        return result;
    }

}
