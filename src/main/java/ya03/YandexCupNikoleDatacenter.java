package ya03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class YandexCupNikoleDatacenter {
    public static String result = "no_data";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
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
                String line = reader.readLine();
                if (line.length() == 6) {
                    int center_index = -1;
                    if (line.charAt(5) == 'X') {
                        // GETMAX
                        int center_count = -1;
                        for (int i = 0; i < datacenter_count; i++) {
                            int temp_live;
                            if (center_live[i] == -1) {
                                temp_live = center_wserv_count[i] * center_reset[i];
                                center_live[i] = temp_live;
                            } else
                                temp_live = center_live[i];
                            if (center_count < temp_live) {
                                center_index = i;
                                center_count = temp_live;
                            }
                        }
                    } else {
                        // GETMIN
                        int center_count = Integer.MAX_VALUE;
                        for (int i = 0; i < datacenter_count; i++) {
                            int temp_live;
                            if (center_live[i] == -1) {
                                temp_live = center_wserv_count[i] * center_reset[i];
                                center_live[i] = temp_live;
                            } else
                                temp_live = center_live[i];
                            if (center_count > temp_live) {
                                center_index = i;
                                center_count = temp_live;
                            }
                        }
                    }
                    result = result + (center_index + 1) + "\n";
                } else {
                    if (line.charAt(0) == 'D') {
                        String[] comand_line = line.substring(8).split(" ");
                        // DISABLE
                        int dis_center_num = Integer.parseInt(comand_line[0]) - 1;
                        int dis_server_num = Integer.parseInt(comand_line[1]) - 1;
                        if (servers[dis_center_num][dis_server_num] == 0) {
                            // Отключаем рабочий сервер.
                            servers[dis_center_num][dis_server_num] = 1;
                            center_wserv_count[dis_center_num]--;
                            center_live[dis_center_num] = -1;
                        }
                    } else {
                        // RESET
                        int center_reset_num = Integer.parseInt(line.substring(6)) - 1;
                        center_reset[center_reset_num]++;
                        Arrays.fill(servers[center_reset_num], (byte) 0);
                        center_wserv_count[center_reset_num] = servers_count;
                        center_live[center_reset_num] = -1;
                        //for (int i = 0; i < servers_count; i++)
                        //    servers[center_reset_num][i] = 0;
                    }
                }
            }
            System.out.println(result);
            //reader.close();
       //} catch (Exception e) {
       //     System.out.println(e.getMessage());
       // }
    }
}