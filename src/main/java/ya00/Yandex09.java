package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Yandex09 {
    public static int PRICE_LESS_THAN;
    public static String DATE_AFTER;
    public static String NAME_CONTAINS;
    public static int PRICE_GREATER_THAN;
    public static String DATE_BEFORE;

    public static void main(String[] args) {
        String line;

        try (FileReader reader = new FileReader("input.txt");
             BufferedReader r = new BufferedReader(reader);
             FileWriter writer = new FileWriter("output.txt");
             BufferedWriter w = new BufferedWriter(writer)) {

            line = r.readLine();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(line);
            ArrayList<Object> objs = new ArrayList<>();
            if (obj instanceof JSONArray) {
                JSONArray obj2 = (JSONArray) obj;
                for (int i = 0; i < obj2.size(); i++) {
                    objs.add(obj2.get(0));
                }
            }
            PRICE_LESS_THAN = Integer.parseInt(r.readLine());
            DATE_AFTER = r.readLine();
            NAME_CONTAINS = r.readLine();
            PRICE_GREATER_THAN = Integer.parseInt(r.readLine());
            DATE_BEFORE = r.readLine();

            /* for (Object rec : objs) {
                System.out.println(rec);
            }*/
            Object test2 = parser.parse("[{\"name\": \"EaRPoDs\", \"id\": 2, \"date\": \"01.01.2022\", \"price\": 2200}, {\"date\": \"23.09.2021\", \"name\": \"Airpods\", \"id\": 5, \"price\": 2300}]\n");
            System.out.println(test2);
        } catch (Exception e) {
        }
    }
}