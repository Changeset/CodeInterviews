package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:15 2018/3/7
 * @ ModifiedBy:
 */

class BinaryTreeNode {
    double val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode() { }
    BinaryTreeNode(int x) {val = x;}
}
public class SubstructureInTree26 {
    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (Equal(root1.val, root2.val))
                result = DoesTree1HaveTree2(root1, root2);
            if (!result) result = hasSubtree(root1.left, root2);
            if (!result) result = hasSubtree(root1.right, root2);
        }

        return result;
    }

    private boolean DoesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (!Equal(root1.val, root2.val)) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) &&
                DoesTree1HaveTree2(root1.right, root2.right);
    }

    private boolean Equal(double num1, double num2) {
        if (Math.abs(num1-num2) < 1E-7) return true;
        else return false;
    }
}
