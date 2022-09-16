package tests;

public class TwoDigits {
    public static void main(String[] args) {
        int ok_count = 0;
        int not_ok_count = 0;
        for (int n1 = 0; n1 < 499; n1++) {
            int test1 = getNCount_new(n1);
            int test2 = getNCount_new2(n1);
            if (test1 != test2) {
                System.out.println("[" + n1 + "]  " + test1 + "  " + test2);
                not_ok_count++;
            } else {
                ok_count++;
            }
        }

        /*
        for (int n1 = 0; n1 < 48; n1++)
            for (int n2 = n1 + 1; n2 < 49; n2++) {
                int test1 = getNCount(n1, n2);
                int test2 = getNCount2(n1, n2);
                if (test1 != test2) {
                    System.out.println("-- [" + n1 + "," + n2 + "] " + test1 + "  " + test2);
                    System.out.println((n2 - n1) % 10 + " " + n1 % 10 + " " + n2 % 10 + " " + (n2 + n1) % 10);
                    not_ok_count++;
                } else {
                    //System.out.println("++ [" + n1 + "," + n2 + "] " + test1 + "  " + test2);
                    ok_count++;
                }
            }*/
        System.out.println("OK=" + ok_count + " NOT_OK=" + not_ok_count);
    }

    private static int getNCount(int n1, int n2) {
        if (n2 <= n1) return 0;
        int res = 0;
        for (int i = n1; i <= n2; i++)
            if ((i / 10) % 10 != 5 && i % 10 != 5) res++;
        return res;
    }

    private static int getNCount2(int n1, int n2) {
        if (n2 <= n1) return 0;
        // Максимальное количество чисел.
        int res = n2 - n1;
        if ((n2 - n1) % 10 < 5) res++;
        res -= (n2 - n1) / 10;

        return res;
    }

    private static int getNCount_new(int n) {
        if (n < 0) return 0;
        int res = 0;
        for (int i = 0; i <= n; i++)
            if ((i / 100) % 10 != 5 && (i / 10) % 10 != 5 && i % 10 != 5) res++;
        return res;
    }

    private static int getNCount_new2(int n) {
        if (n < 0) return 0;
        // Максимальное количество чисел.
        int res = n - n / 10;
        if (n % 10 < 5) res++;
        if ((n / 10) % 10 == 5) res -= (n % 10 + 1);
        if (n >= 55) res += (n - 55) / 100 + 1;
        if (n >= 60) res -= (1 + (n - 60) / 100) * 10;

        return res;
    }
}
