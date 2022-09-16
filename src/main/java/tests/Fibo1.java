package tests;

public class Fibo1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(i + " = " + count(i) + " 2=" + count2(i) + " 3=" + count3(i) );
    }

    private static int count(int number) {
        int variants = number != 0 ? number % 2 == 0 ? 2 : 1 : 0;
        for (int twos = 1; twos <= number / 2; twos++) {
            int ones = number - (twos * 2);
            if (ones != 0) {
                variants += ones + 1;
                variants += twos - 1;
            }
        }
        return variants;
    }

    private static int count2(int num) {
        if (num <= 0) return 0;
        else if (num == 1) return 1;
        else if (num == 2) return 2;
        else return count2(num - 1) + count2(num - 2);
    }

    private static int count3(int num) {
        if (num <= 0) return 0;
        int res1 = 0;
        int res2 = 1;
        while (num-- > 0) {
            int temp = res2;
            res2 = res2 + res1;
            res1 = temp;
        }
        return res2;
    }
}
