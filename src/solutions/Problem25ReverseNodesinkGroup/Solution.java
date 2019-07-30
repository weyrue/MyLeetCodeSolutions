package solutions.Problem25ReverseNodesinkGroup;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pointer = head;
        ListNode[] reverseGroup = new ListNode[k + 1];
        /**
         * 第一轮
         */
        for (int i = 1; i <= k; i++) {
            if (pointer == null) return head;
            reverseGroup[k - i] = pointer;
            pointer = pointer.next;
        }
        reverseGroup[k] = pointer;
        head = reverseGroup[0];
        pointer = head;
        for (int i = 0; i < k; i++) {
            pointer.next = reverseGroup[i];
            pointer = pointer.next;
        }
        if (reverseGroup[k] == null) return head;
        pointer.next = reverseGroup[k];

        while (true) {
            ListNode pointer2 = pointer.next;
            for (int i = 1; i <= k; i++) {
                if (pointer2 == null) return head;
                reverseGroup[k - i] = pointer2;
                pointer2 = pointer2.next;
            }
            reverseGroup[k] = pointer2;

            for (int i = 0; i < k; i++) {
                pointer.next = reverseGroup[i];
                pointer = pointer.next;
            }
            if (reverseGroup[k] == null) break;
            pointer.next = reverseGroup[k];
        }

        return head;
    }
}
