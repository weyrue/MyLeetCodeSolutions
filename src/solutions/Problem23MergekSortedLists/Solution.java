package solutions.Problem23MergekSortedLists;

/*
 * O(Nlogk)算法：
 * <p>
 * 算法1：
 * 利用优先级队列插入时间复杂度O(logn)。
 * 将每个链表的头插入优先级队列，每次poll出最小的节点做排序，再把最小的节点的next节点插入到优先级队列。
 * <p>
 * 算法2（更优解）：
 * 利用合并两个有序链表的时间复杂度为O(n)，其中n为两个链表节点数量的和，采用分而治之的算法。
 * 第一次将k个有序队列两两合并，时间复杂度为O(N)。
 * 第二次将合并后的k/2个有序队列两两合并，时间复杂度为O(N)。
 * 以此类推
 * 总共的次数为log2(k)，故总时间复杂度为O(Nlogk)
 */
class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode result = new Solution().mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

//    /**
//     * 算法1：
//     * 利用优先级队列插入时间复杂度O(logn)。
//     * 将每个链表的头插入优先级队列，每次poll出最小的节点做排序，再把最小的节点的next节点插入到优先级队列。
//     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        ListNode head = new ListNode(0), pointer = head;
//        /**
//         * 排序链表的头的优先级队列
//         */
//        PriorityQueue<ListNode> currentHeadsOfEachLists = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        /**
//         * 初始化
//         */
//        for (ListNode eachHead : lists) {
//            if (eachHead != null) {
//                currentHeadsOfEachLists.add(eachHead);
//            }
//        }
//        /**
//         * 每次poll出最小的节点做排序，再把最小的节点的next节点插入到优先级队列
//         */
//        while (currentHeadsOfEachLists.size() > 0) {
//            ListNode popNode = currentHeadsOfEachLists.poll();
//            pointer.next = popNode;
//            pointer = pointer.next;
//            if (popNode.next != null) {
//                currentHeadsOfEachLists.add(popNode.next);
//            }
//        }
//        return head.next;
//    }

    /*
     * 算法2：
     * 利用合并两个有序链表的时间复杂度为O(n)，其中n为两个链表节点数量的和，采用分而治之的算法。
     * 第一次将k个有序队列两两合并，时间复杂度为O(N)。
     * 第二次将合并后的k/2个有序队列两两合并，时间复杂度为O(N)。
     * 以此类推
     * 总共的次数为log2(k)，故总时间复杂度为O(Nlogk)
     *
     * @param   lists
     * @return
     * @version 1.0
     * @author Yi
     * @date 7/18/2019
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        /*
         * 为充分利用已有的空间，设置一个逻辑队尾变量
         */
        int totalLength = lists.length;
        /*
         * 有序队列两两合并，将结果记录在原有的数组中（节约空间），totalLength用于记录实际的队尾
         */
        int i;
        while (totalLength > 1) {
            // 有序队列两两合并
            for (i = 0; i < totalLength - 1; i += 2) {
                lists[i >> 1] = mergeTwoLists(lists[i], lists[i + 1]);
            }
            // 如果最后剩下一个队列没有配对合并，则将其插入到数组中用于下一次循环，调整队尾位置
            // 如果所有队列刚好全部配对没有落单，则只需调整队尾位置即可
            if (i == totalLength - 1) {
                totalLength = 1 + (i >> 1);
                lists[totalLength - 1] = lists[i];
            } else {
                totalLength = totalLength >> 1;
            }
        }

        return lists[0];
    }

    /**
     * 合并两个有序队列
     *
     * @param l1  合并队列1
     * @param l2  合并队列1
     * @return
     * @version 1.0
     * @author Yi
     * @date 7/18/2019
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), pointer = head;
        /*
         * 合并两个有序链表，直到有一个为空
         */
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        /*
         * 将非空的链表直接拼接在结果的队尾
         */
        if (l1 != null) {
            pointer.next = l1;
        }
        if (l2 != null) {
            pointer.next = l2;
        }
        return head.next;
    }
}
