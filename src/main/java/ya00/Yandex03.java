package tests;

import java.io.*;

public class Yandex03 {
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