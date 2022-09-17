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
 * 6 5 10
 * 1 2 3 4 5 6
 * 10
 * <p>
 * Пример 2
 * 5 7 12
 * 5 22 17 13 8
 * 27
 * <p>
 * Пример 3
 * 100 12312313 12323
 * 100092 125 322 317 143 348 542 2422 417 2413 4248 2444 2 42 421 56 5678 836 2345 2309 1010092 1225 3222 3147 1543 3148 4542 21422 4417 24113 42848 24444 6 412 42 561 56178 846 26451 21309 1013092 1235 3322 3347 1643 3648 4642 26422 4617 24613 42648 24644 9 442 41 531 53178 836 23431 23339 1017092 1735 3722 3747 1743 3748 4742 27422 7617 27673 42748 24744 7 472 71 571 53778 736 27471 27379 1017992 9735 9722 3797 1793 3948 4992 29922 7917 29673 49748 24749 7 479 79 591 53979 796 29491 97979
 * 1563663760
 * <p>
 * TL 2.025s 29Mb test 16
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Yandex01n05_arraylist01_try {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            // Количество будильников.
            int timer_count = Integer.parseInt(param[0]);
            // Время срабатывания будильников.
            final int timerDuration = Integer.parseInt(param[1]);
            // Количество звонков до пробуждения
            int awake_count = Integer.parseInt(param[2]);
            long min = Long.MAX_VALUE;
            int index = -1;
            int curr = timer_count;

            ArrayList<Long> timers = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            long next;
            while (curr-- > 0) {
                timers.add(next = Long.parseLong(tokenizer.nextToken()));
                if (min > next) {
                    min = next;
                    index = timer_count - curr - 1;
                }
            }

            // Первый будильник <min> сразу сработал.
            timers.set(index, min + timerDuration);
            awake_count--;

            // Обрабатываем звонки будильников.
            while (awake_count-- > 0) {
                long value = Long.MAX_VALUE;
                for (int i = 0; i < timers.size(); i++) {
                    long new_value = timers.get(i);
                    if (new_value < value && new_value > min) {
                        value = new_value;
                        index = i;
                        if (new_value - 1 == min) break;
                    }
                }
                min = value;
                timers.set(index, value + timerDuration);
            }
            System.out.println(min);
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
