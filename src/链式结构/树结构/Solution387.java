package 链式结构.树结构;

public class Solution387 {
    public static int firstUniqueChar(String str) {

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            //将字符'a'-'z'转换为索引 0-25
            freq[str.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(freq[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("loveleetcode"));
    }
}
