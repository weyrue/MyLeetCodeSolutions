package solutions.Problem24SwapNodesinPairs;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pointer = head;
        head = head.next;
        /**
         * 先交换前两个节点
         */
        pointer.next = head.next;
        head.next = pointer;
        /**
         * 循环两两交换后面的节点
         */
        while (pointer.next != null && pointer.next.next != null) {
            // 交换两个节点
            ListNode tmp = pointer.next;
            pointer.next = pointer.next.next;
            tmp.next = pointer.next.next;
            pointer.next.next = tmp;
            // 把pointer移到下次循环的0号位
            pointer = tmp;
        }
        return head;
    }
}