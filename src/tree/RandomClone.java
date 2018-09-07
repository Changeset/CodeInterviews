package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:48 2018/9/5
 * @ ModifiedBy:
 */
public class RandomClone {
    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        CloneRandom(pHead);
        return ReconnectNodes(pHead);
    }

    private void CloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        if (pNode == null) return;
        while (pNode != null) {
            RandomListNode pClone = new RandomListNode(pNode.label);
            RandomListNode pNext = pNode.next;
            pClone.next = pNext;
            pNode.next = pClone;
            pNode = pNext;
        }
    }

    private void CloneRandom(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        if (pNode == null) return;
        while (pNode != null) {
            RandomListNode pClone = pNode.next;
            if (pNode.random != null)
                pClone.random = pNode.random.next;
            pNode = pClone.next;
        }
    }

    private RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode pCloneNode = null;
        if (pNode != null) {
            cloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
}
