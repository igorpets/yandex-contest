package ya01;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Yandex01n03_test {
    // new String[2][3]
    private static String[] test_data = {
            "3 10\n" +
                    "1 2 3 4 5 6 7 8 9 10",
            "4 12\n" +
                    "5 10 15 20 3 6 9 25 30 12 21 24",
    };
    private static String[] result_data = {
            "Petya",
            "Vasya"
    };


    public static void main(String[] args) {

        for (int i = 0; i < test_data.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
                writer.flush();
                writer.write(test_data[i] + "\n");
                writer.close();
                Yandex01n03_first.main(null);
                if (Yandex01n03_first.result != result_data[i]) {
                    System.out.println("TEST " + i + " FAILED! " + Yandex01n03_first.result + " " + result_data[i]);
                }

            } catch (Exception e) {

            }
        }
    }
}
