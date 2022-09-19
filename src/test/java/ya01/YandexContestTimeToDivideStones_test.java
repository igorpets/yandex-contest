package ya01;

import testdriver.TestDriver;

public class YandexContestTimeToDivideStones_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexContestTimeToDivideStones_test();
        test.className = "YandexContestTimeToDivideStones";

        String[] test_data = {
                "6",
                "1",
        };
        String[] result_data = {
                "5",
                "0"
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexContestTimeToDivideStones.main(null);
        return YandexContestTimeToDivideStones.result;
    }
}
