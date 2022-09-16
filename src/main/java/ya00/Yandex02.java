package tests;

import java.io.*;

public class Yandex02 {
    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        String line;
        int ch;
        try (FileReader reader = new FileReader("input.txt");
             FileWriter writer = new FileWriter("output.txt")) {
            while ((ch = reader.read()) > 0) {
                if (ch < '0' || ch > '9') break;
                A = A * 10 + Character.getNumericValue(ch);
            }
            while ((ch = reader.read()) > 0) {
                if (ch < '0' || ch > '9') break;
                B = B * 10 + Character.getNumericValue(ch);
            }
            int res = A + B;
            System.out.println(res);
            writer.write(String.valueOf(res));
        } catch (Exception e) {
        }
    }
}