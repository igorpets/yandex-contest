package ya01;

import testdriver.TestDriver;

public class YandexContestIntrestingGame_test extends TestDriver {
    public static void main(String[] args) {
        TestDriver test = new YandexContestIntrestingGame_test();
        test.className = "YandexContestAnInterestingGame";
        String[] test_data = {
                "3 10\n" +
                        "1 2 3 4 5 6 7 8 9 10",
                "4 12\n" +
                        "5 10 15 20 3 6 9 25 30 12 21 24",
                "20 12\n" +
                        "5 10 15 20 3 6 9 25 30 12 21 24",
                "20 12\n" +
                        "5 10 15 20 3 6 9 25 30 12 21 20",
                "7 22\n" +
                        "5 10 15 20 3 10 9 25 30 12 21 24 2 1 13 15 40 18 100 33 46 98",
                "7 22\n" +
                        "5 10 15 20 3 10 9 25 30 12 21 24 2 1 13 15 18 40 33 100 46 98"
        };
        String[] result_data = {
                "Petya",
                "Vasya",
                "Petya",
                "Draw",
                "Vasya",
                "Petya"
        };
        test.runtest(test_data, result_data, 0);
    }
    protected String work(){
        YandexContestAnInterestingGame.main(null);
        return YandexContestAnInterestingGame.result;
    }
}
