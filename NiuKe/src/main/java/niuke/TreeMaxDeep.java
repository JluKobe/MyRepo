package niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度
 */
public class TreeMaxDeep {

    /**
     * 解法一：递归
     */
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 解法二： 使用queue进行层序遍历
     */
    public int maxDepth_1(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res ++;
        }

        return res;
    }
}
