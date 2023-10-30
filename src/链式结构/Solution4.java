package 链式结构;

//递归调试 (递归深度、递归深度字符串) 1.画图 2.单步跟踪 3.打印跟踪
public class Solution4 {

    public ListNode removeElements(ListNode head, int e, int depth) { //递归深度
        //递归深度字符串
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("call: remove " + e + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("return: " + head);
            return head;
        }
        ListNode result = removeElements(head.next, e, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + e + ": " + result);

        ListNode ret;

        if (head.e == e) {
            ret = result;
        } else {
            head.next = result;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        ListNode newListNode = (new Solution4()).removeElements(listNode, 6, 0);
        System.out.println(newListNode);
    }
}
