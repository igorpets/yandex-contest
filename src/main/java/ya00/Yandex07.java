package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Yandex07 {

    public static void main(String[] args) {
        String line;
        int i;
        int res = -20;

        try (FileReader reader = new FileReader("input.txt");
             BufferedReader r = new BufferedReader(reader);
             FileWriter writer = new FileWriter("output.txt");
             BufferedWriter w = new BufferedWriter(writer)) {
            line = r.readLine();
            int count_left = 0;
            int count_right = 0;
            int del_index = -10;
            int good_index = 0;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for (i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '{') {
                    count_left++;
                    left.add(i);
                } else if (line.charAt(i) == '}') {
                    count_right++;
                    right.add(i);
                }
                if (count_left + 1 < count_right) {
                    System.out.println("-1");
                    return;
                }
                if (del_index < 0 && count_right > count_left)
                    del_index = i;
                if (count_left == count_right) good_index = i;
            }
            int test = Math.abs(count_left - count_right);
            if (test > 1 || test == 0) {
                System.out.println("-1");
                return;
            } else {
                if (del_index < 0) {
                    if (count_left > count_right) {
                        del_index = line.indexOf('{',good_index+1);
                    } else {
                        del_index = line.indexOf('}',good_index+1);
                    }
                }

                System.out.println(del_index + 1);
            }
        } catch (Exception e) {
        }
    }
}