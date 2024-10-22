package algo.examples.fastnslowpointers;

public class FindingMiddleNodeInLinkedList {
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

        ListNode middleNode = findMiddleNode(oneNode);
        System.out.println("Middle node: " + middleNode.val);
    }

    public static ListNode findMiddleNode(ListNode oneNode) {
        ListNode slow = oneNode;
        ListNode fast = oneNode.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
