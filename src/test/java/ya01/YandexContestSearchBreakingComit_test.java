package ya01;

import testdriver.TestDriver;

public class YandexContestSearchBreakingComit_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexContestSearchBreakingComit_test();
        test.className = "YandexContestSearchBreakingComit";

        String[] test_data = {
                "11 11\n" +
                        "12 12",
                "21 21\n" +
                        "22 22",
        };
        String[] result_data = {
                "12",
                "22"
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexContestSearchBreakingComit.main(null);
        return YandexContestSearchBreakingComit.result;
    }
}
