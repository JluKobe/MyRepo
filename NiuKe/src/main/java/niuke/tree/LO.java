package niuke.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LO {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode();
        TreeNode r2 = new TreeNode();
        TreeNode r3 = new TreeNode();
        TreeNode r4 = new TreeNode();
        TreeNode r5 = new TreeNode();

        r1.val = 1;
        r2.val = 2;
        r3.val = 3;
        r4.val = 4;
        r5.val = 5;

        r2.left = r4;
        r3.right = r5;;
        r1.left = r2;
        r1.right = r3;

        ArrayList<ArrayList<Integer>> l = levelOrder(r1);
        System.out.println("test");
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            while (size > 0) {
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }

                size --;
            }

            result.add(list);
        }

        return result;
    }
}
