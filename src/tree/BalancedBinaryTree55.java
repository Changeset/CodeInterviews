package tree;

public class BalancedBinaryTree55 {
    static int[] depth;
    public static boolean isBalanced(BinaryTreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = Math.abs(left - right);
            if (diff <= 1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    public static boolean isBalanced(BinaryTreeNode root) {
        int depth = 0;
        return isBalanced(root, depth);
    }
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(6);
        System.out.println(BalancedBinaryTree55.isBalanced(root));
    }
}
