package solutions.Problem21MergeTwoSortedLists;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建一个存储结果的链表的头部。
 * 从两个链表l1、l2头到位逐位比较，先将小的节点，再将大的节点拼接到结果链表尾部。
 * 当其中一个链表循环到尾部，没有下一节点时，将另一链表的剩余部分全部拼接在结果链表的尾部。
 */
class Solution {

    private int index = 10;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        ListNode head = new ListNode(0), pointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }

        if (l1 != null && l2 == null) {
            pointer.next = l1;
        } else if (l2 != null && l1 == null) {
            pointer.next = l2;
        }

        return head.next;
    }
}
