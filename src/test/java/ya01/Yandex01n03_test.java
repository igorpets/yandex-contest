package ya01;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Yandex01n03_test {
    private static String[] test_data = {
            "3 10\n" +
                    "1 2 3 4 5 6 7 8 9 10",
            "4 12\n" +
                    "5 10 15 20 3 6 9 25 30 12 21 24",
            "20 12\n" +
                    "5 10 15 20 3 6 9 25 30 12 21 24",
            "20 12\n" +
                    "5 10 15 20 3 6 9 25 30 12 21 20",
            "7 22\n" +
                    "5 10 15 20 3 10 9 25 30 12 21 24 2 1 13 15 40 18 100 33 46 98",
            "7 22\n" +
                    "5 10 15 20 3 10 9 25 30 12 21 24 2 1 13 15 18 40 33 100 46 98"
    };//
    private static String[] result_data = {
            "Petya",
            "Vasya",
            "Petya",
            "Draw",
            "Vasya",
            "Petya"
    };


    public static void main(String[] args) {

        for (int i = 0; i < test_data.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
                writer.flush();
                writer.write(test_data[i] + "\n");
                writer.close();
                Yandex01n03.main(null);
                if (Yandex01n03.result != result_data[i]) {
                    System.out.println("TEST " + i + " FAILED! " + Yandex01n03.result + " " + result_data[i]);
                }

            } catch (Exception e) {

            }
        }
    }
}
