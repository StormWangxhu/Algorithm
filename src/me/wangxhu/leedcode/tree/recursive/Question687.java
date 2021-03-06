package me.wangxhu.leedcode.tree.recursive;

import me.wangxhu.leedcode.dfs.TreeNode;

/**
 * <p>Created on 18-12-1</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * leetcode687 : 相同节点值的最大路径长度 /  最长同值路径
 * <p>
 * 难度级别: 简单
 */
public class Question687 {

    static class Solution {

        private int path = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return path;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
            int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
            path = Math.max(path, (leftPath + rightPath));
            return Math.max(leftPath, rightPath);
        }
    }
}
