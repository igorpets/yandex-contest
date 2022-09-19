package ya01;

/**
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class YandexContestTimeToDivideStones {
    public static String result = "no_data";
  /*  long[] fract = [1,
        1
            2,
            6,
        24,
            120,
            720,
            5040,
            40320,
            362880,
            3628800,
            11!	39916800
            12!	479001600
            13!	6227020800
            14!	87178291200
            15!	1307674368000
            16!	20922789888000
            17!	355687428096000
            18!	6402373705728000
            19!	121645100408832000
            20!	2432902008176640000
            21!	5,10909 ⋅ 1019
            22!	1,124 ⋅ 1021
            23!	2,5852 ⋅ 1022
            24!	6,20448 ⋅ 1023
            25!	1,55112 ⋅ 1025
            26!	4,03291 ⋅ 1026
            27!	1,08889 ⋅ 1028
            28!	3,04888 ⋅ 1029
            29!	8,84176 ⋅ 1030
            30!	2,65253 ⋅ 1032
            31!	8,22284 ⋅ 1033
            32!	2,63131 ⋅ 1035
            33!	8,68332 ⋅ 1036
            34!	2,95233 ⋅ 1038
            35!	1,03331 ⋅ 1040
            36!	3,71993 ⋅ 1041
            37!	1,37638 ⋅ 1043
            38!	5,23023 ⋅ 1044
            39!	2,03979 ⋅ 1046*/

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            BigInteger max = BigInteger.valueOf(1000000007);
            int input = Integer.parseInt(reader.readLine());
            if (input % 2 == 1) result = "0";
            else {
                input = input / 2;
                BigInteger temp = getFactorial(input);
                //System.out.println(temp.toString());
                BigInteger temp1 = temp.multiply(BigInteger.valueOf(input + 1));
                //System.out.println(temp1.toString());
                BigInteger temp2 = getFactorial2(input + 1, temp, input * 2);
                //System.out.println(temp2.toString() + " " + getFactorial(input * 2).toString());
                BigInteger result2 = temp2.divide(temp.multiply(temp1));
                //System.out.println(result2.toString());
                result = result2.mod(max).toString();
            }
            System.out.println(result);
        } catch (Exception e) {
        }
    }
    public static BigInteger getFactorial(int n) {
        if(n < 2) return BigInteger.valueOf(1);
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
    public static BigInteger getFactorial2(int start, BigInteger result, int n) {
        if (n < 2) return BigInteger.valueOf(1);
        return result.multiply(IntStream.rangeClosed(start, n).parallel().mapToObj(
                BigInteger::valueOf).reduce(BigInteger::multiply).get());
    }
}
