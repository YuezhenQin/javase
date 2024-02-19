package FileIO;

import java.time.LocalDate;

public class FormatterDate {
    public static void main(String[] args) {
        System.out.printf("%4d-%02d-%02d%n", 2024, 2, 1);

        LocalDate today = LocalDate.now();
        System.out.println(today);
//        System.out.printf("Today is %1$tB %1$td %1$tY%n", today);
    }
}
