package Network;

//jdk17新特性: 文本代码块
public class TestTextBlock {
    public static void main(String[] args) {
        String json = """
                {
                "id": 1,
                "name:" jdk17
                }
                """;
        System.out.println(json);
    }
}
