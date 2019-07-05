package solutions;

public class Problem21MergeTwoSortedLists {
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
        ListNode l1 = stringToListNode("[5]");
        ListNode l2 = stringToListNode("[1,2,4]");

        ListNode ret = new Solution21().mergeTwoLists(l1, l2);

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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
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
        }else if(l2 != null && l1 == null){
            pointer.next = l2;
        }

        return head.next;
    }
}