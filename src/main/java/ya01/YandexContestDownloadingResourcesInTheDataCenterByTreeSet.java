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
import java.util.*;


public class YandexContestDownloadingResourcesInTheDataCenterByTreeSet {
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            ArrayList<TreeSet<Integer>> clusters = new ArrayList<>();
            TreeSet<Integer> servers;
            // Число связей между серверами.
            String str = reader.readLine();
            int links_count = Integer.parseInt(str);
            //System.out.println("links_count=" + links_count);
            int curr_link = 0;
            // Считываем все связи серверов (кластера).
            while (curr_link++ < links_count) {
                String[] link = reader.readLine().split(" ");
                Integer link1 = Integer.parseInt(link[0]);
                Integer link2 = Integer.parseInt(link[1]);
                int index1 = -1;
                int index2 = -1;
                //System.out.println("L " + link1 + " " + link2);
                // Проверяем все записи.
                for (int i = 0; i < clusters.size(); i++) {
                    servers = clusters.get(i);
                    if (servers.contains(link1)) index1 = i;
                    if (servers.contains(link2)) index2 = i;
                    if (index1 >= 0 && index2 >= 0) break;
                }
                if (index1 < 0 && index2 < 0) {
                    // Добавляем новый кластер
                    servers = new TreeSet<>();
                    servers.add(link1);
                    servers.add(link2);
                    clusters.add(servers);
                } else if (index1 >= 0 && index2 < 0) {
                    // Добавляем новый сервер link2 в существующий кластер
                    clusters.get(index1).add(link2);
                } else if (index2 >= 0 && index1 < 0) {
                    // Добавляем новый сервер link1 в существующий кластер
                    clusters.get(index2).add(link1);
                } else if (index2 >= 0 && index1 >= 0 && index1 != index2) {
                    // сервера в разных кластерах, объединяем кластера.
                    TreeSet<Integer> cluster1 = clusters.get(index1);
                    TreeSet<Integer> cluster2 = clusters.get(index2);
                    if (cluster1.size() > cluster2.size()) {
                        cluster1.addAll(cluster2);
                        clusters.remove(index2);
                    } else {
                        cluster2.addAll(cluster1);
                        clusters.remove(index1);
                    }
                }
                // Иначе, указанные сервера уже находятся в одном кластере.
            }
            // Число файлов.
            int files_count = Integer.parseInt(reader.readLine());
            System.out.println();
            int curr_file_index = 0;
            result = "";
            while (curr_file_index++ < files_count) {
                String[] file_data = reader.readLine().split(" ");
                Integer target_server = Integer.parseInt(file_data[0]);
                //System.out.println("target_server=" + target_server);
                //int source_count = Integer.parseInt(file_data[1]);
                TreeSet<Integer> target_cluster = null;
                for (TreeSet<Integer> cluster : clusters) {
                    if (cluster.contains(target_server)) {
                        // Нашли целевой кластер.
                        target_cluster = cluster;
                        break;
                    }
                }
                String source_connected = "";
                int source_connected_count = 0;
                if (target_cluster != null) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                    while (tokenizer.hasMoreTokens()) {
                        int next_source = Integer.parseInt(tokenizer.nextToken());
                        if (target_cluster.contains(next_source)) {
                            source_connected_count++;
                            if (source_connected_count == 1)
                                source_connected = "" + next_source;
                            else
                                source_connected = source_connected + " " + next_source;
                        }
                    }
                }
                //System.out.println("source_connected=" + source_connected);
                if (!result.equals("")) result = result + "\n";
                if (source_connected_count > 0) {
                    result = result + source_connected_count + " " + source_connected;
                } else
                    result = result + "0";
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
