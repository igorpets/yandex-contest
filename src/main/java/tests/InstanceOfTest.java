package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InstanceOfTest {
    public static void main(String[] args) {

        Integer x = new Integer(22);
        System.out.println(x);
        //System.out.println(x instanceof String);
    }

    public static class Yandex01 {
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

    public static class Yandex02 {
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

    public static class Yandex03 {
        public static void main(String[] args) throws Exception {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String J = r.readLine();
            String S = r.readLine();

            int result = 0;
            for (int i = 0; i < S.length(); ++i) {
                if (J.indexOf(S.charAt(i)) >= 0) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
