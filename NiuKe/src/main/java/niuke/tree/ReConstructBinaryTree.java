package niuke.tree;

import java.util.Arrays;

/**
 * 二叉树重建，给出先序 中序
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //数组长度为0的时候要处理
        if(pre.length == 0){
            return null;
        }

        int rootVal = pre[0];

        //数组长度仅为1的时候就要处理
        if(pre.length == 1){

            return new TreeNode(rootVal);
        }

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i= 0; i < in.length; i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex + 1), Arrays.copyOfRange(in,0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex + 1, pre.length), Arrays.copyOfRange(in,rootIndex + 1, in.length));

        return root;
    }
}
