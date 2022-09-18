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
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class YandexContestAlarmClocksByLinkeLlist {
    public static void main(String[] args) {
        class Timer {
            int number; // Порядковый номер будильника при первом запуске.
            long startTime; // Время старта будильника.
            long nextTime; // Точное время следующего звонка.

            public Timer(int number, long startTime) {
                this.number = number;
                this.startTime = startTime;
                this.nextTime = startTime;
            }
        }
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            LinkedList<Timer> timers = new LinkedList<>();
            String[] param = reader.readLine().split(" ");
            String[] times = reader.readLine().split(" ");

            if (param.length == 3) {
                // Количество будильников.
                int timer_count = Integer.parseInt(param[0]);
                // Время срабатывания будильников.
                int timerDuration = Integer.parseInt(param[1]);
                // Количество звонков до пробуждения
                int awake_count = Integer.parseInt(param[2]);

                if (times.length == timer_count) {
                    TreeSet<Long> set_of_times = new TreeSet<>();
                    int num = 1;
                    // Определим только уникальные таймеры.
                    for (String time : times) {
                        set_of_times.add(Long.parseLong(time));
                    }
                    // Создадим объекты-будильники.
                    for(Long time: set_of_times) {
                        timers.add(new Timer(num++, time));
                    }
                    timers.sort(new Comparator<Timer>() {
                        @Override
                        public int compare(Timer o1, Timer o2) {
                            long res = o1.nextTime - o2.nextTime;
                            if (res>0) return 1;
                            else if (res<0) return -1;
                            return 0;
                        }
                    });

                    // Обрабатываем звонки будильников.
                    Timer current;
                    while (awake_count-- > 1) {
                        current = timers.removeFirst();
                        current.nextTime += timerDuration;
                        int new_index = 0;
                        for (Timer timer : timers) {
                            if (timer.nextTime == current.nextTime) {
                                // Время совпало с существующим будильником, удаляем его навсегда.
                                current = null;
                                break;
                            } else if (current.nextTime < timer.nextTime) {
                                // Нашли место для вставки.
                                break;
                            }
                            new_index++;
                        }
                        if (current != null)
                            timers.add(new_index, current);
                    }
                    long res = timers.getFirst().nextTime;
                    System.out.println(res);
                }
            }
        } catch (Exception e) {
        }
    }
}
