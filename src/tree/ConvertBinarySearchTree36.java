package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:08 2018/3/8
 * @ ModifiedBy:
 */
public class ConvertBinarySearchTree36 {
    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode pLastNodeInList = null;
        pLastNodeInList = convertNode(root, pLastNodeInList);
        BinaryTreeNode pHeadOfList;
        pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null)
            pHeadOfList = pHeadOfList.left;
        return pHeadOfList;
    }
    public BinaryTreeNode convertNode(BinaryTreeNode pNode, BinaryTreeNode pLastNodeInList) {
        if (pNode == null) return pLastNodeInList;
        BinaryTreeNode pCurrent = pNode;
        if (pCurrent.left != null)
            pLastNodeInList = convertNode(pCurrent.left, pLastNodeInList);
        pCurrent.left = pLastNodeInList;
        if (pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;
        pLastNodeInList = pCurrent;
        if (pCurrent.right != null)
            pLastNodeInList = convertNode(pCurrent.right, pLastNodeInList);
        return pLastNodeInList;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);
        ConvertBinarySearchTree36 c = new ConvertBinarySearchTree36();
        c.convert(root);
    }
}
