package 链式结构;

//理解递归的宏观语义: 在以head为头结点的链表中删除值为e的节点，并返回结果链表的头结点
//理解递归调用的微观过程
public class Solution3 {

    public ListNode removeElements(ListNode head, int e) {
        //对于一个空LL，对它删除操作得到的结果还是空
        if (head == null) return null; //最基本的问题的答案(问题规模最小的解)
        head.next = removeElements(head.next, e); //head与结果链表相互链接起来
        return (head.e == e) ? head.next : head;

//        ListNode result = removeElements(head.next, e);
//        if (head.e == e) {
//            return result;
//        } else {
//            head.next = result;
//            return head;
//        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode newListNode = (new Solution3()).removeElements(listNode, 6);
        System.out.println(newListNode);
    }
}
