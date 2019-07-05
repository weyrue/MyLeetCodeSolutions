package solutions;

public class Problem19RemoveNthNodeFromEndofList {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int n = 2;

        ListNode ret = new Solution19().removeNthFromEnd(head, n);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}


/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 做两遍循环
 * 第一遍循环计算出链表长度。
 * 根据长度（length）和逆序位置（n）计算出正序位置（length-n）
 * 第二遍循环，定位到待删除的的节点的上一个节点，将该节点的next字段改为待删除元素的next字段
 */
class Solution19 {
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