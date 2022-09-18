package ya01;

/**
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class YandexContestDownloadingResourcesInTheDataCenter {
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
                String next = tokenizer.nextToken();
                result = next;
            }
            System.out.println(result);
        } catch (Exception e) {
        }
    }
}
