package algo.examples.fastnslowpointers;


public class DetectCyclesInLinkedList {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return false;
            }
        }
        return true;
    }

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
        oneNode.next.next.next.next.next.next.next.next = threeNode;

        System.out.println("Cycle present: "  + DetectCyclesInLinkedList.hasCycle(oneNode));
    }

}