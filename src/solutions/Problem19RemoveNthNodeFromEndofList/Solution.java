package solutions.Problem19RemoveNthNodeFromEndofList;

/**
 * 做两遍循环
 * 第一遍循环计算出链表长度。
 * 根据长度（length）和逆序位置（n）计算出正序位置（length-n）
 * 第二遍循环，定位到待删除的的节点的上一个节点，将该节点的next字段改为待删除元素的next字段
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        /**
         * 计算出链表长度
         */
        while (node != null) {
            length++;
            node = node.next;
        }
        /**
         * 根据长度（length）和逆序位置（n）计算出正序位置（length-n）
         */
        int targetIndex = length - n;
        /**
         * 若删除头节点，将头节点的下一个节点当做头结点返回即可
         */
        if (targetIndex == 0) return head.next;
        /**
         * 定位到要删除的节点的前一个节点
         */
        node = head;
        for (int i = 0; i < targetIndex - 1; i++) {
            node = node.next;
        }
        /**
         * 将该节点的next字段改为待删除元素的next字段
         */
        node.next = node.next.next;

        return head;
    }
}
