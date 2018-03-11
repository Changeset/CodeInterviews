package tree;

public class BalancedBinaryTree55 {
    private static boolean isBalanced = true;
    public static int getDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return right > left ? right + 1 : left + 1;
    }

    public static boolean isBalanced(BinaryTreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(6);
        root.right.right.right = new BinaryTreeNode(7);
        System.out.println(BalancedBinaryTree55.isBalanced(root));
    }
}
