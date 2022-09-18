package ya01;

/**
 * B. Будильники
 * -
 * Работа в большинстве IT-компаний имеет много преимуществ: нет дресс-кода, можно иногда поработать удалённо,
 * классные и умные коллеги и, конечно же, свободный график! Однако свободный график и возможность работать
 * удалённо требуют большой силы воли.
 * -
 * Программист Алексей любит работать по ночам и не любит приходить на работу поздно. Чтобы точно проснуться с утра,
 * Алексей каждый вечер заводит N будильников на своём телефоне. Каждый будильник устроен таким образом, что он
 * звонит каждые X минут с того момента времени, на который его завели. Например, если будильник был заведён
 * на момент времени ti, то он будет звонить в моменты времени ti, ti+X, ti+2X и так далее. При этом если какие-то
 * два будильника начинают звонить в один момент времени, то отображается только один из них.
 * -
 * Известно, что прежде чем проснуться, Алексей каждое утро слушает ровно K будильников, после чего просыпается.
 * Определите момент времени, когда Алексей проснётся.
 * -
 * Формат ввода
 * Первая строка содержит три целых числа N, X и K (1≤N≤10^5, 1≤X,K≤10^9) — количество будильников, периодичность
 * звонков и количество будильников, которое нужно отключить, чтобы Алексей проснулся.
 * Вторая строка содержит N целых чисел t1, t2, …, tN (1≤ti≤10^9) — моменты времени на которые были заведены будильники.
 * -
 * Формат вывода
 * Выведите одно число — момент времени, когда Алексей проснётся.
 * <p>
 * ML 1.753s 259.84Mb test 16
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class YandexContestAlarmClocksByTreeSet {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            TreeSet<Long> timers = new TreeSet<>();
            // = Arrays.stream(reader.readLine().split(" ")).mapToLong(a->Long.parseLong(a)).collect(()->new TreeSet<Long>(), TreeSet::add, TreeSet::addAll);
            HashMap<Integer, Long> groups = new HashMap<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            // Количество будильников.
            // int timer_count = Integer.parseInt(param[0]);
            // Время срабатывания будильников.
            final int timerDuration = Integer.parseInt(param[1]);
            // Количество звонков до пробуждения
            int awake_count = Integer.parseInt(param[2]);

            while (tokenizer.hasMoreTokens()) {
                long new_value = Long.parseLong(tokenizer.nextToken());
                int new_group = (int) new_value % timerDuration;
                if (!groups.containsKey(new_group)) {
                    timers.add(new_value);
                    groups.put(new_group, new_value);
                } else {
                    long old_value = groups.get(new_group);
                    if (old_value > new_value) {
                        groups.replace(new_group, new_value);
                        timers.remove(old_value);
                        timers.add(new_value);
                    }
                }
            }
            // Обрабатываем звонки будильников.
            while (awake_count-- > 1) {
                timers.add(timers.pollFirst() + timerDuration);
            }
            long res = timers.first();
            System.out.println(res);
        } catch (Exception e) {
        }
    }
}

/* Альтернативное чтение из файла.
            long curr = 0;
            char ch = ' ';
            while (timer_count > 0) {
                ch = (char) reader.read();

                if (Character.isDigit(ch)) {
                    // Формируем время следующего будильника по цифрам.
                    if (curr == 0) curr = Character.digit(ch, 10);
                    else curr = curr * 10 + Character.digit(ch, 10);
                } else {
                    // Сохраняем только уникальные таймеры.
                    timers.add(curr);
                    curr = 0;
                    timer_count--;
                }
            }
            if (curr > 0) timers.add(curr);
 */