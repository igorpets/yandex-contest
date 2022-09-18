package ya01;

/**
 * Петя и Вася играют в интересную игру. Сначала Вася объявляет, сколько очков нужно набрать, чтобы игра закончилась.
 * Затем Петя берет карточки, на которых написаны целые неотрицательные числа, и начинает выкладывать их на стол
 * одну за другой. Если на карточке число, кратное пяти, то Вася получает одно очко. Если на карточке число, кратное
 * трем, то одно очко получает Петя. Если на карточке число, не кратное ни трем, ни пяти, или наоборот,
 * кратное им обоим, то очков не получает никто.
 * -
 * Как только кто-то из участников наберет количество очков, которое назвал в начале игры Вася, игра прекращается
 * и этот игрок становится победителем. Если никто из участников не набрал нужного количества очков, но при этом
 * все карточки закончились, то победителем считается игрок, у которого больше очков. Если все карточки закончились,
 * а очков поровну, то объявляется ничья.
 * -
 * Петя и Вася иногда очень спешат, поэтому хотят не играть в игру полностью, а сразу узнать, кто выиграл бы при
 * известных начальных данных. Они попросили вас написать программу, которая поможет ответить на этот вопрос.
 * -
 * Зарегистрироваться на направление Бэкенд и другие треки чемпионата вы можете на сайте Yandex Cup.
 * -
 * Формат ввода
 * В первой строке через пробел даны два целых положительных числа: количество очков K, которое объявляет в начале
 * игры Вася, и количество карточек N, которые есть у Пети (1≤K≤1000,1≤N≤10^6).
 * В следующей строке даны N целых неотрицательных чисел, разделенных пробелом, каждое из которых не превосходит 1000.
 * -
 * Формат вывода
 * В единственной строке выведите Petya, если в игре побеждает Петя, Vasya, если в игре побеждает Вася,
 * или Draw, если победителя выявить не удалось.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class Yandex01n03 {
    private static final int THREE = 3; // Петя получает очко
    private static final int FIVE = 5; // Вася получает очко
    private static final String PETYA = "Petya";
    private static final String VASYA = "Vasya";
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            // Количество очков для победы.
            final int points_count = Integer.parseInt(param[0]);
            // Количество карточек у Пети.
            int cards_count = Integer.parseInt(param[1]);
            int points_petya = 0;
            int points_vasya = 0;

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            while (tokenizer.hasMoreTokens() && cards_count-- > 0) {
                int next = Integer.parseInt(tokenizer.nextToken());
                boolean flag3 = (next % THREE) == 0d;
                boolean flag5 = (next % FIVE) == 0d;
                //System.out.println(next + " " + flag3 + " " + flag5);

                if (flag3 && !flag5) {
                    points_petya++;
                } else if (flag5 && !flag3) {
                    points_vasya++;
                }
                //System.out.println(next+" " + points_petya + " " + points_vasya);
                if (points_petya == points_count || points_vasya == points_count) break;
            }
            if (points_petya == points_count)
                result = PETYA;
            else if (points_vasya == points_count)
                result = VASYA;
            else if (points_petya == points_vasya)
                result = "Draw";
            else if (points_petya > points_vasya)
                result = PETYA;
            else
                result = VASYA;
            System.out.println(result);// + " " + points_petya + " " + points_vasya);
        } catch (Exception e) {

        }
    }
}
