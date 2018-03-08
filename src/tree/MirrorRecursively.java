package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:35 2018/3/7
 * @ ModifiedBy:
 */
public class MirrorRecursively {
    public TreeNode mirrorRecursively(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorRecursively(root.right);
        mirrorRecursively(root.left);
        return root;
    }

    public static void main(String[] args) {
        MirrorRecursively m = new MirrorRecursively();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        m.mirrorRecursively(root);
    }
}
