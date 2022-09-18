package ya01;

/**
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class YandexContestPattern {
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            //
            int params0 = Integer.parseInt(param[0]);
            //
            int params1 = Integer.parseInt(param[1]);

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                int next = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(result);
        } catch (Exception e) {
        }
    }
}
