package 动态数据结构;

public class ListNode {
     int e;
     ListNode next;
     public ListNode(int e) {
         this.e = e;
     }

     //AR to LL
     public ListNode(int[] arr) {
         if (arr == null || arr.length == 0) throw new IllegalArgumentException("arr cannot be empty.");

         this.e = arr[0];
         ListNode current = this;
         for (int i = 1; i < arr.length; i++) {
             current.next = new ListNode(arr[i]);
             current = current.next;
         }
     }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.e + "->");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
