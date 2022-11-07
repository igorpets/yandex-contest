package ya03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class YandexCupNumberSystem {
    public static String result = "no_data";

    public static void main(String[] args) {
        // System.out.println('Z'-65);
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            // Число связей между серверами.
            String line = reader.readLine().toUpperCase();
            String[] lines = line.split("=");
            int max_base = 26 + 10;
            int base = 2;
            for (char chr : line.toCharArray()) {
                if (chr >= '0' && chr <= '9') {
                    int temp = chr - 47;
                    if (base < temp)
                        base = temp;
                } else if (chr >= 'A' && chr <= 'Z') {
                    int temp = chr - 54;
                    if (base < temp)
                        base = temp;
                }
            }
            for (; base <= max_base; base++) {
                BigDecimal big_base = new BigDecimal(base);
                BigDecimal res1 = get_result(lines[0], big_base);
                BigDecimal res2 = get_result(lines[1], big_base);
                if (res1.equals(res2))
                    break;
            }
            if (base <= 36) result = String.valueOf(base);
            else result = "-1";

            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static BigDecimal get_result(String line, BigDecimal base) {
        BigDecimal res =BigDecimal.ZERO;
        BigDecimal val = BigDecimal.ZERO;
        BigDecimal m = BigDecimal.ONE;
        for (char chr : line.toCharArray()) {
            if (Character.isDigit(chr)) {
                val = val.multiply(base).add(new BigDecimal(chr - 48));
                //System.out.println("D val=" + val + " res=" + res);
            } else if (Character.isAlphabetic(chr)) {
                val = val.multiply(base).add(new BigDecimal(chr - 55));
                //System.out.println("A val=" + val + " res=" + res);
            } else if (chr == '+') {
                res = res.add(val.multiply(m));
                val = BigDecimal.ZERO;
                m = BigDecimal.ONE;
                //System.out.println("+ res=" + res);
            } else if (chr == '-') {
                res = res.add(val.multiply(m));
                val = BigDecimal.ZERO;
                m = new BigDecimal(-1);
                //System.out.println("- res=" + res);
            }
        }
        res = res.add(val.multiply(m));
        //System.out.println(base + " res = " + res);
        return res;
    }
}
