package ya01;

import testdriver.TestDriver;

public class YandexContestStonesAndJewelry_test extends TestDriver {

    public static void main(String[] args) {
        TestDriver test = new YandexContestStonesAndJewelry_test();
        test.className = "YandexContestStonesAndJewelry";
        String[] test_data = {
                "ab\n" +
                        "aabbccd",
                "cdab\n" +
                        "ursjmklklsfelllslplllplpmpspkfpsfkpwpfpspspspfspspwpiptpypwpfpjpfspwqssszx",
                "agi\n" +
                        "aggkikijpoqngajhaewqtrlkmnibg",
                "edcba\n" +
                        "gcttbyaebtecuidqdtrqwdaatbecrdhemtmeomk"
        };
        String[] result_data = {
                "4",
                "0",
                "10",
                "18"
        };
        test.runtest(test_data, result_data, 1);
    }

    protected String work() {
        YandexContestStonesAndJewelry.main(null);
        return YandexContestStonesAndJewelry.result;
    }
}
