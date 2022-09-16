package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Yandex08 {
    private static char[][] area;
    private static int width;
    private static int height;

    public static void main(String[] args) {
        String line;
        try (FileReader reader = new FileReader("input.txt");
             BufferedReader r = new BufferedReader(reader);
             FileWriter writer = new FileWriter("output.txt");
             BufferedWriter w = new BufferedWriter(writer)) {

            line = r.readLine();
            String[] first_line = line.split(" ");
            height = Integer.parseInt(first_line[0]);
            width = Integer.parseInt(first_line[1]);
            area = new char[width][height];

            int start_x = -1;
            int start_y = -1;
            for (int y = 0; y < height; y++) {
                line = r.readLine();
                for (int x = 0; x < width; x++) {
                    char symb = line.charAt(x);
                    area[x][y] = symb;
                    if (symb == 'S') {
                        start_x = x;
                        start_y = y;
                    }
                }
            }
            if (start_x >= 0 && start_y >= 0 && width > 0 && height > 0)
                path_finder(start_x, start_y);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    System.out.print(area[x][y]);
                }
                System.out.println();
            }
            System.out.flush();
        } catch (Exception e) {
        }
    }

    public static void path_finder(int start_x, int start_y) {
        boolean flag_D=false;
        boolean flag_U=false;
        boolean flag_R=false;
        boolean flag_L=false;
        if (start_y > 1 && area[start_x][start_y - 1] == '.') {
            area[start_x][start_y - 1] = 'D';
            flag_D = true;
        }
        if (start_y < height - 2 && area[start_x][start_y + 1] == '.') {
            area[start_x][start_y + 1] = 'U';
            flag_U = true;
        }
        if (start_x > 1 && area[start_x - 1][start_y] == '.') {
            area[start_x - 1][start_y] = 'R';
            flag_R = true;
        }
        if (start_y < width - 2 && area[start_x + 1][start_y] == '.') {
            area[start_x + 1][start_y] = 'L';
            flag_L = true;
        }
        if (flag_D)
            path_finder(start_x, start_y - 1);
        if (flag_U)
            path_finder(start_x, start_y + 1);
        if (flag_R)
            path_finder(start_x - 1, start_y);
        if (flag_L)
            path_finder(start_x + 1, start_y);
    }
}