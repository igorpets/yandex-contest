package ya01;

/**
 * E. Скачивание ресурсов в дата-центре
 * -
 * Сеть компании состоит из серверов, каждый из которых имеет уникальный целочисленный идентификатор. N пар серверов
 * соединены друг с другом. Соединённые серверы образуют кластеры: два сервера относятся к одному и тому же кластеру,
 * если от одного из них можно добраться до другого, перемещаясь по связям.
 * -
 * Периодически возникает необходимость скачать определённый файл на некоторый сервер. В сети работает сервис,
 * аналогичный торрент-трекеру, который может сообщить, на каких серверах уже имеется необходимый файл.
 * -
 * Проблема, однако, заключается в том, что любой сервер может скачивать файлы только с серверов в его кластере.
 * -
 * Составьте программу, которая будет анализировать конфигурацию сети и сообщать, из каких источников определённый
 * сервер может скачать необходимый файл.
 * -
 * Формат ввода
 * Первая строка содержит целое число N (0≤N≤10^6) — количество связей между серверами.
 * Следующие N строк описывают связи между серверами. Каждая из них содержит целые числа Ai и Bi (1≤Ai,Bi≤10^9) —
 * идентификаторы соединённых серверов.
 * Следующая строка содержит целое число Q (1≤Q≤10^3) — количество запросов на скачивание файлов.
 * <p>
 * Следующие (2⋅Q) строк описывают запросы на скачивание файлов.
 * Первая строка каждой пары содержит целые числа
 * Xi и Ki (1≤Xi≤10^9, 1≤Ki≤100) — соответственно идентификатор сервера, на который нужно скачать файл, и количество
 * серверов, содержащих файл.
 * Вторая строка каждой пары содержит Ki целых чисел Yij (1≤Yij≤10^9) —
 * идентификаторы серверов, содержащих файл.
 * -
 * Формат вывода
 * Для каждого запроса в отдельной строке выведите сначала целое число Rj — количество серверов, с которых можно
 * скачать файл. Затем выведите Rj целых чисел — идентификаторы серверов, с которых можно скачать файл. Серверы
 * следует выводить в том порядке, в котором они перечислены в описании соответствующего запроса во входных данных.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class YandexContestDownloadingResourcesInTheDataCenter {
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            HashMap<Integer, ArrayList<Integer>> links = new HashMap<>();
            // Число связей между серверами.
            String str = reader.readLine();
            int links_count = Integer.parseInt(str);
            //System.out.println("links_count=" + links_count);
            int curr_link = 0;
            // Считываем все связи серверов (кластера).
            while (curr_link++ < links_count) {
                String[] link = reader.readLine().split(" ");
                int link1 = Integer.parseInt(link[0]);
                int link2 = Integer.parseInt(link[1]);
                //System.out.println("L " + link1 + " " + link2);
                // Добавляем в общий список подключений прямую связь.
                ArrayList<Integer> servers = links.get(link1);
                if (servers == null) {
                    servers = new ArrayList<>();
                    servers.add(link2);
                    links.put(link1, servers);
                } else {
                    if (!servers.contains(link2))
                        servers.add(link2);
                }
                // Добавляем в общий список подключений обратную связь.
                servers = links.get(link2);
                if (servers == null) {
                    servers = new ArrayList<>();
                    servers.add(link1);
                    links.put(link2, servers);
                } else {
                    if (!servers.contains(link1))
                        servers.add(link1);
                }
            }
            // Дополняем связи через другие сервера кластера.
            for (HashMap.Entry<Integer, ArrayList<Integer>> entry : links.entrySet()) {
                int key = entry.getKey();
                ArrayList<Integer> arr = entry.getValue();
                // Тестовая печать.
                System.out.println(key + " " + arr);
                for (Integer link_key:entry.getValue()) {
                    for (HashMap.Entry<Integer, ArrayList<Integer>> entry2 : links.entrySet()) {
                        int key2 = entry2.getKey();
                        if (key2 != key && key == link_key) {
                            //for (true) ;
                        }
                    }
                }
            }
            // Число файлов.
            int files_count = Integer.parseInt(reader.readLine());
            System.out.println();
            int curr_file_index = 0;
            result = "";
            while (curr_file_index++ < files_count) {
                String[] file_data = reader.readLine().split(" ");
                int target_server = Integer.parseInt(file_data[0]);
                System.out.println("target_server=" + target_server);
                //int source_count = Integer.parseInt(file_data[1]);
                ArrayList<Integer> target_links = links.get(target_server);
                String source_connected = "";
                int source_connected_count = 0;

                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                while (tokenizer.hasMoreTokens()) {
                    int next_source = Integer.parseInt(tokenizer.nextToken());
                    if (target_links.contains(next_source)) {
                        source_connected_count++;
                        source_connected = source_connected + next_source;
                    }
                }
                System.out.println("source_connected=" + source_connected);
                if (source_connected_count > 0) {
                    result = result + source_connected_count + " " + source_connected + "\n";
                } else
                    result = result +"0 \n";
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
