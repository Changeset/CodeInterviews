package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:19 2018/3/9
 * @ ModifiedBy:
 */
public class FirstCommonNodesInLists52 {
    public static ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int difLength = Math.abs(length1-length2);
        ListNode longHead, shortHead;
        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
        } else {
            longHead = head2;
            shortHead = head1;
        }
        for (int i = 0; i < difLength; i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null
                && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
        }
        return length;
    }
}
