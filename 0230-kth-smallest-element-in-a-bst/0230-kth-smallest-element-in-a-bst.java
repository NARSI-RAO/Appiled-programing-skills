import java.util.Scanner;
class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        if (++count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}