package ya01;

/**
 * B. Будильники
 * <p>
 * Работа в большинстве IT-компаний имеет много преимуществ: нет дресс-кода, можно иногда поработать удалённо,
 * классные и умные коллеги и, конечно же, свободный график! Однако свободный график и возможность работать
 * удалённо требуют большой силы воли.
 * <p>
 * Программист Алексей любит работать по ночам и не любит приходить на работу поздно. Чтобы точно проснуться с утра,
 * Алексей каждый вечер заводит N будильников на своём телефоне. Каждый будильник устроен таким образом, что он
 * звонит каждые X минут с того момента времени, на который его завели. Например, если будильник был заведён
 * на момент времени ti, то он будет звонить в моменты времени ti, ti+X, ti+2X и так далее. При этом если какие-то
 * два будильника начинают звонить в один момент времени, то отображается только один из них.
 * <p>
 * Известно, что прежде чем проснуться, Алексей каждое утро слушает ровно K будильников, после чего просыпается.
 * Определите момент времени, когда Алексей проснётся.
 * <p>
 * Формат ввода
 * Первая строка содержит три целых числа N, X и K (1≤N≤10^5, 1≤X,K≤10^9) — количество будильников, периодичность
 * звонков и количество будильников, которое нужно отключить, чтобы Алексей проснулся.
 * Вторая строка содержит N целых чисел t1, t2, …, tN (1≤ti≤10^9) — моменты времени на которые были заведены будильники.
 * <p>
 * Формат вывода
 * Выведите одно число — момент времени, когда Алексей проснётся.
 * <p>
 * 6 5 10
 * 1 2 3 4 5 6
 * 10
 * <p>
 * 5 7 12
 * 5 22 17 13 8
 * 27
 * <p>
 * 100 12312313 12323
 * 100092 125 322 317 143 348 542 2422 417 2413 4248 2444 2 42 421 56 5678 836 2345 2309 1010092 1225 3222 3147 1543 3148 4542 21422 4417 24113 42848 24444 6 412 42 561 56178 846 26451 21309 1013092 1235 3322 3347 1643 3648 4642 26422 4617 24613 42648 24644 9 442 41 531 53178 836 23431 23339 1017092 1735 3722 3747 1743 3748 4742 27422 7617 27673 42748 24744 7 472 71 571 53778 736 27471 27379 1017992 9735 9722 3797 1793 3948 4992 29922 7917 29673 49748 24749 7 479 79 591 53979 796 29491 97979
 * 1563663760
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Yandex01n05_arraylist01_nosorted03 {
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
            System.out.println(curr_timer);
        } catch (Exception e) {

        }
    }
}

//System.out.println("NEW: " + new_value + " OLD: " + old_value + " group:" + new_group + " group_val: " + groups.get(new_group));
//System.out.println("count:" + curr_count + " time:" + curr_timer + " min:" + timer_min + " max:" + timer_max +"\n");
//System.out.println("TM:" + tm + " " + Math.max((curr_timer - tm) / timerDuration, 0));
//System.out.println("min:" + timer_min + " max:" + timer_max);
// = Arrays.stream(reader.readLine().split(" ")).mapToLong(a->Long.parseLong(a)).collect(()->new TreeSet<Long>(), TreeSet::add, TreeSet::addAll);
//System.out.println("TIMERS:");
//for(Long tm:timers) System.out.println(tm);
//System.out.println();
