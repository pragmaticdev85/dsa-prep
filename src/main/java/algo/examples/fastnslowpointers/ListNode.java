package algo.examples.fastnslowpointers;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        ListNode curNode = this;
        do {
            sb.append(String.format("%s -> ", curNode.val));
        } while ((curNode = curNode.next) != null);
        return sb.toString();
    }
}