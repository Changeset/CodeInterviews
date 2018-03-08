package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 14:50 2018/3/5
 * @ ModifiedBy:
 */
public class ConstructBinaryTree {
    public TreeNode constructBinaryTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode();
        return subConstruct(preOrder, inOrder, 0, n-1, 0, n-1);
    }

    public TreeNode subConstruct(int[] preOrder, int[] inOrder, int preLo, int preHi, int inLo, int inHi) {
        if (inLo > inHi) return null;
        if (inLo == inHi) return new TreeNode(preOrder[preLo]);
        TreeNode root = new TreeNode();
        root.val = preOrder[preLo];
        for (int i = inLo; i <= inHi; i++) {
            int lengthPre = 0;
            if (preOrder[preLo] == inOrder[i]) {
                lengthPre = i - inLo + 1;
                root.left = subConstruct(preOrder, inOrder, preLo+1, preLo-inLo+i, inLo, i-1);
                root.right = subConstruct(preOrder, inOrder, preLo+lengthPre, preLo+lengthPre+inHi-i-1, i+1, inHi);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree c = new ConstructBinaryTree();
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        TreeNode root = c.constructBinaryTree(preOrder, inOrder);
        System.out.println(root);
    }
}
