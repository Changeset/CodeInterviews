package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:12 2018/3/7
 * @ ModifiedBy:
 */
public class Clone {
    public ComplexListNode clone(ComplexListNode pHead) {
        CloneNodes(pHead);
        CloneSibling(pHead);
        return ReconnectNodes(pHead);
    }

    private void CloneNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        if (pNode == null) return;
        while (pNode != null) {
            ComplexListNode pClone = new ComplexListNode();
            ComplexListNode pNext = pNode.next;
            pClone.val = pNode.val;
            pClone.next = pNext;
            pNode.next = pClone;
            pNode = pNext;
        }
    }

    private void CloneSibling(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        if (pNode == null) return;
        while (pNode != null) {
            ComplexListNode pClone = pNode.next;
            if (pNode.sibling != null)
                pClone.sibling = pNode.sibling.next;
            pNode = pClone.next;
        }
    }

    private ComplexListNode ReconnectNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        ComplexListNode cloneHead = null;
        ComplexListNode pClonedNode = null;
        if (pNode != null) {
            cloneHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Clone c = new Clone();
    }
}
