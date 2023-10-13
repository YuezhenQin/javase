package 动态数据结构;

//Leetcode 206: Reverse LinkedList Node
public class Solution206 {
    //非递归实现方式
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev; //反转
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //递归实现方式
    public ListNode reverseListRecursive(ListNode head) {
        //空链表或单元素链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode x = reverseListRecursive(head.next); //结果链表

        head.next.next = head; //此时头结点依然与结果链表的尾结点相链接
        head.next = null;

        return x;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode newListNode = (new Solution206()).reverseListRecursive(listNode);
        System.out.println(newListNode);
    }

}
