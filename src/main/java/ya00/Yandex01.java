package tests;

import java.util.Scanner;

public class Yandex01 {
    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        String line;
        try (Scanner scan = new Scanner(System.in)) {
            A = scan.nextInt();
            B = scan.nextInt();
        } catch (Exception e) {
        }
        int res = A + B;
        System.out.println(String.valueOf(res));
    }
}
