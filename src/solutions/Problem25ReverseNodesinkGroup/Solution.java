package solutions.Problem25ReverseNodesinkGroup;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode nodeBeforeHead = new ListNode(0), pointer = nodeBeforeHead;
        nodeBeforeHead.next = head;
        while (true) {
            ListNode tmpPointer = pointer;
            for (int i = 0; i < k; i++) {
                if (tmpPointer.next == null) return nodeBeforeHead.next;
                tmpPointer = tmpPointer.next;
            }
            pointer = reverseNodes(pointer, k);
        }
    }

    private ListNode reverseNodes(ListNode nodeBeforeStartNode, int k) {
        ListNode startNode = nodeBeforeStartNode.next, nodeBeforeReverseNode;
        ListNode reverseNode = startNode;
        ListNode nodeAfterReverseNode = startNode.next;
        while (--k > 0) {
            nodeBeforeReverseNode = reverseNode;
            reverseNode = nodeAfterReverseNode;
            nodeAfterReverseNode = nodeAfterReverseNode.next;
            reverseNode.next = nodeBeforeReverseNode;
        }

        nodeBeforeStartNode.next = reverseNode;
        startNode.next = nodeAfterReverseNode;
        return startNode;
    }
}
