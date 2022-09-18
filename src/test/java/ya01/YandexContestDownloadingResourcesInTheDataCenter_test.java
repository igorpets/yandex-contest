package ya01;

import testdriver.TestDriver;

public class YandexContestDownloadingResourcesInTheDataCenter_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexContestDownloadingResourcesInTheDataCenter_test();
        test.className = "YandexContestDownloadingResourcesInTheDataCenter";

        String[] test_data = {
                "8\n" +
                        "54578972 99368556\n" +
                        "79699669 54578972\n" +
                        "64508306 99368556\n" +
                        "56554555 64508306\n" +
                        "27101564 81480071\n" +
                        "89445516 27101564\n" +
                        "93762227 81480071\n" +
                        "89808815 93762227\n" +
                        "4\n" +
                        "56554555 2\n" +
                        "93762227 79699669\n" +
                        "99368556 2\n" +
                        "64508306 56554555\n" +
                        "27101564 2\n" +
                        "99368556 79699669\n" +
                        "93762227 2\n" +
                        "56554555 54578972",
                "8\n" +
                        "545 993\n" +
                        "796 545\n" +
                        "645 993\n" +
                        "565 645\n" +
                        "271 814\n" +
                        "894 271\n" +
                        "937 814\n" +
                        "898 937\n" +
                        "4\n" +
                        "565 2\n" +
                        "937 796\n" +
                        "993 2\n" +
                        "645 565\n" +
                        "271 2\n" +
                        "993 796\n" +
                        "937 2\n" +
                        "565 545"
        };
        String[] result_data = {
                "1 79699669\n" +
                        "2 64508306 56554555\n" +
                        "0\n" +
                        "0 ",
                "1 796\n" +
                        "2 645 565\n" +
                        "0\n" +
                        "0 "
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexContestDownloadingResourcesInTheDataCenter.main(null);
        return YandexContestDownloadingResourcesInTheDataCenter.result;
    }
}
