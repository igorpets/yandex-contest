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
                "10\n" +
                        "85619126 64616465\n" +
                        "98159933 85619126\n" +
                        "73978229 85619126\n" +
                        "29978081 64616465\n" +
                        "72404745 29978081\n" +
                        "97698445 75243921\n" +
                        "36815728 97698445\n" +
                        "18360411 97698445\n" +
                        "66445821 75243921\n" +
                        "92142380 66445821\n" +
                        "4\n" +
                        "97698445 4\n" +
                        "75243921 92142380 98159933 73978229\n" +
                        "66445821 4\n" +
                        "29978081 92142380 73978229 97698445\n" +
                        "18360411 4\n" +
                        "29978081 92142380 98159933 97698445\n" +
                        "36815728 4\n" +
                        "64616465 92142380 97698445 29978081",
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
                        "0",
                "2 75243921 92142380\n" +
                        "2 92142380 97698445\n" +
                        "2 92142380 97698445\n" +
                        "2 92142380 97698445",
                "1 796\n" +
                        "2 645 565\n" +
                        "0\n" +
                        "0"
        };
        test.runtest(test_data, result_data, 1);
    }
    protected String work(){
        YandexContestDownloadingResourcesInTheDataCenterByArrayList.main(null);
        return YandexContestDownloadingResourcesInTheDataCenterByArrayList.result;
    }
}
