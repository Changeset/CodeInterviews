package tree;

public class TreeDepth55 {
    public static int treeDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
        System.out.println(TreeDepth55.treeDepth(root));
    }
}
