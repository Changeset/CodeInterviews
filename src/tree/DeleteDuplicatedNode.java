package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:46 2018/3/6
 * @ ModifiedBy:
 */
public class DeleteDuplicatedNode {
    public void deleteDuplication(ListNode head) {
        ListNode prevNode = null;
        ListNode pNode = head;
        if (head == null) return;
        while (pNode != null) {
            boolean needDelete = false;
            ListNode pNext = pNode.next;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;
            if (needDelete) {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                if (prevNode == null) head = pNext;
                else prevNode.next = pNext;
                pNode = pNext;
            }
            else {
                prevNode = pNode;
                pNode = pNext;
            }
        }
    }

    public static void main(String[] args) {
        DeleteDuplicatedNode d = new DeleteDuplicatedNode();
        ListNode head = new ListNode(1);
        ListNode node;
        node = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        head.next = node;
        d.deleteDuplication(head);
    }
}
