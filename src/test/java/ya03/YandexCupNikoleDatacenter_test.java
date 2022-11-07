package ya03;

import testdriver.TestDriver;

public class YandexCupNikoleDatacenter_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexCupNikoleDatacenter_test();
        test.className = "YandexCupNikoleDatacenter";

        String[] test_data = {
                "3 3 12\n" +
                        "DISABLE 1 2\n" +
                        "DISABLE 2 1\n" +
                        "DISABLE 3 3\n" +
                        "GETMAX\n" +
                        "RESET 1\n" +
                        "RESET 2\n" +
                        "DISABLE 1 2\n" +
                        "DISABLE 1 3\n" +
                        "DISABLE 2 2\n" +
                        "GETMAX\n" +
                        "RESET 3\n" +
                        "GETMIN",
                "2 3 9\n" +
                        "DISABLE 1 1\n" +
                        "DISABLE 2 2\n" +
                        "RESET 2\n" +
                        "DISABLE 2 1\n" +
                        "DISABLE 2 3\n" +
                        "RESET 1\n" +
                        "GETMAX\n" +
                        "DISABLE 2 1\n" +
                        "GETMIN",
        };
        String[] result_data = {
                "1\n" +
                        "2\n" +
                        "1",
                "1\n" +
                        "2"
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexCupNikoleDatacenter.main(null);
        return YandexCupNikoleDatacenter.result;
    }
}
