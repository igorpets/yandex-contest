package ya03;

import testdriver.TestDriver;

public class YandexCupNumberSystem_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexCupNumberSystem_test();
        test.className = "YandexCupNumberSystem";

        String[] test_data = {
                "2 + 2 = 11 - 1",
                "1 = 1",
                "2 = 3",
                "B = A + 1",
                "2+3+G2+Z+10+45= A0+62+Y + 1+5+55",
                "0-AAA+12= 0-A00 -AA+6+7"
        };
        String[] result_data = {
                "4",
                "2",
                "-1",
                "12",
                "36",
                "11"
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexCupNumberSystem.main(null);
        return YandexCupNumberSystem.result;
    }
}
