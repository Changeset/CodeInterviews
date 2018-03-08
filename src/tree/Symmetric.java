package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:56 2018/3/7
 * @ ModifiedBy:
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if(isSymmetricHelper(root.left, root.right)) return true;
        return false;
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetricHelper(left.right, right.left) &&
                isSymmetricHelper(left.left, right.right);
    }
}
