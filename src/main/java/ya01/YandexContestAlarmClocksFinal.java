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
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class YandexContestAlarmClocksFinal {
    public static String result = "";
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            // Считываем основные параметры задачи.
            String[] param = reader.readLine().split(" ");
            // Количество будильников.
            int timer_count = Integer.parseInt(param[0]);
            // Время срабатывания будильников.
            final int timerDuration = Integer.parseInt(param[1]);
            // Количество звонков до пробуждения
            long awake_count = Integer.parseInt(param[2]);

            // Формируем первичный набор данных по будильникам.
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            ArrayList<Long> timers = new ArrayList<>(); // Будильники.
            HashMap<Integer, Integer> groups = new HashMap<>(); //Группы однотипных будильников.
            int index = 0;

            while (timer_count-- > 0) {
                long new_value = Long.parseLong(tokenizer.nextToken());
                int new_group = (int) new_value % timerDuration;
                if (!groups.containsKey(new_group)) {
                    timers.add(new_value);
                    groups.put(new_group, index++);
                } else {
                    int temp_index = groups.get(new_group);
                    long old_value = timers.get(temp_index);
                    if (old_value > new_value) {
                        timers.set(temp_index, new_value);
                    }
                }
            }
            long timer_min = Long.MAX_VALUE;
            long timer_max = Long.MIN_VALUE;
            for(long tm: timers) {
                if (timer_min > tm) timer_min = tm;
                if (timer_max < tm) timer_max = tm;
            }
            // Вычисляем примерные границы времени будильника № awake_count.
            timer_max = timer_max * 2 + timerDuration * awake_count;
            if (groups.size() >= awake_count)
                timer_min = timer_min + awake_count - 2;
            else
                timer_min = timer_min + timerDuration * (awake_count/groups.size()-1) - 3;

            // Освобождаем память.
            groups = null;

            // Поиск заданного числа звонков будильника.
            long curr_timer = (timer_max + timer_min) / 2;
            long curr_count = 0;
            long old_timer = 0;
            while (old_timer != curr_timer && (curr_count != awake_count || timer_min < timer_max)) {
                old_timer = curr_timer;
                curr_count = 0;
                for (long tm : timers) {
                    curr_count += Math.max((curr_timer - tm + timerDuration) / timerDuration, 0);
                }
                if (curr_count >= awake_count) {
                    if (curr_count == awake_count)
                        timer_max = curr_timer;
                    else
                        timer_max = curr_timer - 1;
                    if (curr_timer - timer_min == 1) curr_timer = timer_min;
                    else curr_timer = (curr_timer + timer_min) / 2;
                } else {
                    timer_min = curr_timer + 1;
                    if (timer_max - curr_timer == 1) curr_timer = timer_max;
                    else curr_timer = (curr_timer + timer_max) / 2;
                }
            }
            result = String.valueOf(curr_timer);
            System.out.println(result);
        } catch (Exception e) {

        }
    }
}
