package tests;

public class TryTest {
    public static void main(String[] args) {
        System.out.println(try_test());
        System.out.println();
        System.out.println(try_test2());
    }

    private static int try_test() {
        int test = 0;
        try {
            test = 1;
            if (test == 1) {
                System.out.println(test);
                return test;
            }
            test = 2;
            System.out.println(test);
        } catch (Exception e) {
            return test+10;
        } finally {
            test = test+20;
            System.out.println(test);
        }
        return test+40;
    }
    private static int try_test2() {
        int test = 0;
        while (true) {
            try {
                test = 1;
                if (test == 1) {
                    System.out.println(test);
                    break;
                }
                test = 2;
                System.out.println(test);
            } catch (Exception e) {
                test = test + 10;
            } finally {
                test = test + 20;
            }
            break;
        }
        return test;
    }
}

