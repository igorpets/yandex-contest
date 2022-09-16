package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Yandex06 {

    public static void main(String[] args) {
        Yandex06 test = new Yandex06();
        test.test();
    }

    public void test(){
        class TypeOne {
            String name;
            int count;

            public TypeOne(String name, int count) {
                this.name = name;
                this.count = count;
            }

            public void print() {
                System.out.println("Type: " + name + " " + count);
            }
        }
        class Line {
            String name;
            String type;
            int trick;
            int penalty;

            public Line(String name, String type, int trick, int penalty) {
                this.name = name;
                this.type = type;
                this.trick = trick;
                this.penalty = penalty;
            }

            public void print() {
                System.out.println("Line: " + name + " " + type + " " + trick + " " + penalty);
            }
        }

        String line;
        int i;
        ArrayList<TypeOne> types = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        try (BufferedReader r = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter w = new BufferedWriter(new FileWriter("output.txt"))) {
            int type_count = Integer.parseInt(r.readLine());
            for (i = 0; i < type_count; i++) {
                line = r.readLine();
                String[] one_rec = line.split(",");
                TypeOne obj1 = new TypeOne(one_rec[0], Integer.parseInt(one_rec[1]));
                types.add(obj1);
            }
            int line_count = Integer.parseInt(r.readLine());
            for (i = 0; i < line_count; i++) {
                line = r.readLine();
                String[] one_rec = line.split(",");
                Line obj2 = new Line(one_rec[0], one_rec[1], Integer.parseInt(one_rec[2]), Integer.parseInt(one_rec[3]));
                lines.add(obj2);
            }
            lines.sort(new Comparator<Line>() {
                @Override
                public int compare(Line o1, Line o2) {
                    if (o1.trick != o2.trick) return o2.trick - o1.trick;
                    else return o1.penalty - o2.penalty;
                }
            });
            ArrayList<String> res = new ArrayList<>();
            for (TypeOne t : types) {
                int used = 0;
                if (t.count <= 0) continue;
                for (Line l : lines) {
                    if (l.type.equals(t.name)) {
                        used++;
                        res.add(l.name);
                        if (used >= t.count) {
                            break;
                        }
                    }
                }
            }
            res.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (String s : res)
                System.out.println(s);
        } catch (Exception e) {
        }
    }

}