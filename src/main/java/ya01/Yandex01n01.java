package ya01;
/**
 * A. Камни и украшения
 * Даны две строки строчных латинских символов: строка J и строка S. Символы, входящие в строку
 * J, — «драгоценности», входящие в строку S — «камни». Нужно определить, какое количество символов
 * из S одновременно являются «драгоценностями». Проще говоря, нужно проверить, какое количество
 * символов из S входит в J.
 *
 * Это разминочная задача, к которой мы размещаем готовые решения. Она очень простая и нужна для того,
 * чтобы вы могли познакомиться с нашей автоматической системой проверки решений. Ввод и вывод осуществляется
 * через файлы, либо через стандартные потоки ввода-вывода, как вам удобнее.
 *
 * Формат ввода
 * На двух первых строках входного файла содержатся две строки строчных латинских символов:
 * строка J и строка S. Длина каждой не превосходит 100 символов.
 *
 * Формат вывода
 * Выходной файл должен содержать единственное число — количество камней, являющихся драгоценностями.
 *
 * Пример
 *
 * Ввод
 * ab
 * aabbccd
 *
 * Вывод
 * 4
 **/

import java.io.*;
import java.util.HashSet;

public class Yandex01n01 {
    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String J = reader.readLine();
            String S = reader.readLine();
            HashSet<Character> drag = new HashSet<>();
            if (J!=null && S!=null) {
                for (char ch: J.toCharArray()) {
                    drag.add(ch);
                }
                long res = 0;
                for (char ch: S.toCharArray()) {
                    if (drag.contains(ch)) res++;
                }
                System.out.println(res);
                writer.write(String.valueOf(res));
            }
        } catch (Exception e) {
        }
    }
}