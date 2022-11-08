package ya03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class YandexCupNikoleDatacenter {
    public static String result = "no_data";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] params = reader.readLine().split(" ");
            int datacenter_count = Integer.parseInt(params[0]);
            int servers_count = Integer.parseInt(params[1]);
            //int events_count = Integer.parseInt(params[2]);
            byte[][] servers = new byte[datacenter_count][servers_count];
            int[] center_reset = new int[datacenter_count];
            int[] center_wserv_count = new int[datacenter_count];
            int[] center_live = new int[datacenter_count];
            //byte[] zero = new byte[servers_count];
            for (int i = 0; i < datacenter_count; i++) {
                center_wserv_count[i] = servers_count;
            }
            int last_max = 0;
            int last_min = 0;
            result = "";
            // Считываем все события.
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 6) {
                    int center_index = -1;
                    if (line.charAt(5) == 'X') {
                        // GETMAX
                        if (last_max>=0) center_index = last_max;
                        else {
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
                            last_max = center_index;
                        }
                    } else {
                        // GETMIN
                        if (last_min >= 0 ) center_index = last_min;
                        else {
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
                            last_min = center_index;
                        }
                    }
                    result = result + (center_index + 1) + "\n";
                } else {
                    if (line.charAt(0) == 'D') {
                        // DISABLE
                        int space2 = line.indexOf(' ', 8);
                        int dis_center_num = Integer.parseInt(line.substring(8, space2)) - 1;
                        int dis_server_num = Integer.parseInt(line.substring(space2 + 1)) - 1;
                        if (servers[dis_center_num][dis_server_num] == 0) {
                            // Отключаем рабочий сервер.
                            servers[dis_center_num][dis_server_num] = 1;
                            center_wserv_count[dis_center_num]--;
                            center_live[dis_center_num] = -1;
                        }
                        last_max = -1;
                        last_min = -1;
                    } else {
                        // RESET
                        int center_reset_num = Integer.parseInt(line.substring(6)) - 1;
                        center_reset[center_reset_num]++;
                        //servers[center_reset_num] = new byte[servers_count];
                        Arrays.fill(servers[center_reset_num], (byte) 0);
                        //servers[center_reset_num] = Arrays.copyOf(zero, servers_count);
                        center_wserv_count[center_reset_num] = servers_count;
                        center_live[center_reset_num] = -1;
                        //for (int i = 0; i < servers_count; i++)
                        //    servers[center_reset_num][i] = 0;
                        last_max = -1;
                        last_min = -1;
                    }
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}