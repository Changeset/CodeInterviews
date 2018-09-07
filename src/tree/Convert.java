package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:16 2018/9/5
 * @ ModifiedBy:
 */
public class Convert {
    public TreeNode Convert(TreeNode root) {
        TreeNode pLastNodeInList = null;
        pLastNodeInList = convertNode(root, pLastNodeInList);
        TreeNode pHeadOfList;
        pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null)
            pHeadOfList = pHeadOfList.left;
        return pHeadOfList;
    }

    private TreeNode convertNode(TreeNode pNode, TreeNode pLastNodeInList) {
        if (pNode == null) return pLastNodeInList;
        TreeNode pCurrent = pNode;
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
}
