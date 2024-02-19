package Hashing.tmp;

public class StringDemo {
    public static void main(String[] args) {
        String str = "Aloha String!";
        //遍历
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
        }
        //子串
        System.out.println(str.indexOf("x"));
        System.out.println(str.contains("x"));

        //回文串

        //倒序

    }
}
