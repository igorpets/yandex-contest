package ya03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class YandexCupNikoleDatacenter {
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            // Число связей между серверами.
            String[] params = reader.readLine().split(" ");
            int datacenter_count = Integer.parseInt(params[0]);
            int servers_count = Integer.parseInt(params[1]);
            int events_count = Integer.parseInt(params[2]);
            byte[][] servers = new byte[datacenter_count][servers_count];
            int[] center_reset = new int[datacenter_count];
            int[] center_wserv_count = new int[datacenter_count];
            int[] center_live = new int[datacenter_count];
            for (int i = 0; i < datacenter_count; i++) {
                center_wserv_count[i] = servers_count;
                //center_live[i] = -1;
                /*for (int s = 0; s < servers_count; s++) {
                    servers[i][s] = 1;
                }*/
            }
            //System.out.println("datacenter_count=" + datacenter_count + " servers_count" + servers_count);
            result = "";
            // Считываем все события.
            while (events_count-- > 0) {
                String[] comand_line = reader.readLine().split(" ");
                String comand = comand_line[0];
                switch (comand) {
                    case "DISABLE":
                        int dis_center_num = Integer.parseInt(comand_line[1]) - 1;
                        int dis_server_num = Integer.parseInt(comand_line[2]) - 1;
                        if (servers[dis_center_num][dis_server_num] == 0) {
                            // Отключаем рабочий сервер.
                            servers[dis_center_num][dis_server_num] = 1;
                            center_wserv_count[dis_center_num]--;
                            center_live[dis_center_num] = -1;
                        }
                        break;
                    case "GETMAX":
                        int center_index_max = -1;
                        int center_count_max = -1;
                        for (int i = 0; i < datacenter_count; i++) {
                            int temp_live;
                            if (center_live[i] == -1) {
                                temp_live = center_wserv_count[i] * center_reset[i];
                                center_live[i] = temp_live;
                            } else
                                temp_live = center_live[i];
                            if (center_count_max < temp_live) {
                                center_index_max = i;
                                center_count_max = temp_live;
                            }
                        }
                        result = result + (center_index_max + 1) + "\n";
                        break;
                    case "RESET":
                        int center_reset_num = Integer.parseInt(comand_line[1]) - 1;
                        center_reset[center_reset_num]++;
                        Arrays.fill(servers[center_reset_num], (byte)0);
                        center_wserv_count[center_reset_num] = servers_count;
                        center_live[center_reset_num] = -1;
                        //for (int i = 0; i < servers_count; i++)
                        //    servers[center_reset_num][i] = 0;
                        break;
                    case "GETMIN":
                        int center_index_min = -1;
                        int center_count_min = Integer.MAX_VALUE;
                        for (int i = 0; i < datacenter_count; i++) {
                            int temp_live;
                            if (center_live[i] == -1) {
                                temp_live = center_wserv_count[i] * center_reset[i];
                                center_live[i] = temp_live;
                            } else
                                temp_live = center_live[i];
                            if (center_count_min > temp_live) {
                                center_index_min = i;
                                center_count_min = temp_live;
                            }
                        }
                        result = result + (center_index_min + 1) + "\n";
                        break;
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}