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
 * Пример 1
 * Ввод
 * 6 5 10
 * 1 2 3 4 5 6
 * Вывод
 * 10
 * <p>
 * Пример 2
 * Ввод
 * 5 7 12
 * 5 22 17 13 8
 * <p>
 * Вывод
 * 27
 *
 * TL
 * 2.064s
 * 36.67Mb
 * test	13
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Yandex01n13 {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            ArrayList<Long> timers = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                long value = Long.parseLong(tokenizer.nextToken());
                if (!timers.contains(value))
                    timers.add(value);
            }
            Collections.sort(timers, Collections.reverseOrder());

            // Время срабатывания будильников.
            final int timerDuration = Integer.parseInt(param[1]);
            // Количество звонков до пробуждения
            int awake_count = Integer.parseInt(param[2]);

            // Обрабатываем звонки будильников.
            while (awake_count-- > 1) {
                long value = timers.remove(timers.size() - 1) + timerDuration;
                if (!timers.contains(value))
                    timers.add(value);
                Collections.sort(timers, Collections.reverseOrder());
            }
            System.out.println(timers.remove(timers.size() - 1));
        } catch (Exception e) {

        }
    }
}

// = Arrays.stream(reader.readLine().split(" ")).mapToLong(a->Long.parseLong(a)).collect(()->new TreeSet<Long>(), TreeSet::add, TreeSet::addAll);
//for(Long tm:timers) System.out.println(tm);
//System.out.println();
//Long value = Long.parseLong(tokenizer.nextToken());
//if (!timers.contains(value))
// Количество будильников.
//int timer_count = Integer.parseInt(param[0]);
//                for (Long tm : timers) System.out.println(tm);
//                        System.out.println();
