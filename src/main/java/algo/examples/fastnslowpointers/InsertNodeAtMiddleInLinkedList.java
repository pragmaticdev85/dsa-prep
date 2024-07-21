package algo.examples.fastnslowpointers;

import java.util.List;

public class InsertNodeAtMiddleInLinkedList {
    public static void main(String[] args) {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        ListNode fiveNode = new ListNode(5);
        ListNode sixNode = new ListNode(6);
        ListNode sevenNode = new ListNode(7);
        ListNode eightNode = new ListNode(8);

        oneNode.next = twoNode;
        oneNode.next.next = threeNode;
        oneNode.next.next.next = fourNode;
        oneNode.next.next.next.next = fiveNode;
        oneNode.next.next.next.next.next = sixNode;
        oneNode.next.next.next.next.next.next = sevenNode;
        oneNode.next.next.next.next.next.next.next = eightNode;

        ListNode nineNode = new ListNode(9);
        System.out.format("Before inserting [9] in the middle, the linked list: %s%n", oneNode.toString());
        insertAtMiddle(oneNode, nineNode);
        System.out.format("After inserting [9] in the middle, the linked list: %s%n", oneNode.toString());
        System.out.println("Middle node: " + FindingMiddleNodeInLinkedList.findMiddleNode(oneNode).val);
    }

    private static void insertAtMiddle(ListNode oneNode, ListNode nineNode) {
        ListNode slow = oneNode;
        ListNode fast = oneNode.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        nineNode.next = slow.next;
        slow.next = nineNode;
    }
}
