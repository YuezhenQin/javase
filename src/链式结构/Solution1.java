package 链式结构;
//Leetcode 203: Remove LL Elements

//有fakeHead 和 无fakeHead
public class Solution1 {
//    private class Node {
//        int e;
//        Node next;
//        public Node(int e) {
//            this.e = e;
//        }
//        public Node(int[] arr) {
//            if (arr == null || arr.length == 0) throw new IllegalArgumentException("arr cannot be empty.");
//
//            this.e = arr[0];
//            Node current = this;
//            for (int i = 1; i < arr.length; i++) {
//                current.next = new Node(arr[i]);
//                current = current.next;
//            }
////            Node fakeHead = new Node(Integer.MIN_VALUE);
////            Node prev = fakeHead;
////            for (int i = 0; i < arr.length; i++) {
////                Node node = new Node(i);
////                prev.next = node;
////                prev = node;
////            }
//        }
//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            Node current = this;
//            while (current != null) {
//                sb.append(current.e + "->");
//                current = current.next;
//            }
//            sb.append("NULL");
//            return sb.toString();
//        }
//    }
    public ListNode removeElements(ListNode head, int e) {
        //删除多个元素需要使用循环

        //不设立虚拟 head

        //删除所有在 head 位置且内容e与e相等的节点
        while (head != null && head.e == e) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) return null;

        //此处head一定不是待删除的节点了
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.e == e) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
    public ListNode removeAllElements(ListNode head, int e) {

        //设立虚拟head结点
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;

        ListNode prev = fakeHead;
        while (prev.next != null) {
            if (prev.next.e == e) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode newListNode = (new Solution1()).removeElements(listNode, 6);
        System.out.println(newListNode);
    }
}
