package testdriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public abstract class TestDriver {
    public String className = "Unknown";
    private long limit_time_ms = 1000; // Лимит времени работы приложения в миллисекундах.

    protected abstract String work();

    public void runtest(String[] test_data, String[] result_data, int logLevel) {
        int errors_count = 0;
        long period_max = 0;
        for (int i = 0; i < test_data.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
                // Удаляем старое содержимое файла.
                writer.flush();
                // Записываем новые тестовые данные.
                writer.write(test_data[i] + "\n");
                // Обязательно закрываем, иначе проверяемое приложение не сможет открыть файл.
                writer.close();
                // Фиксируем время начала теста.
                Date start = new Date();
                // Запускаем проверяемое приложение.
                String result = work();
                // Фиксируем время завершения работы приложения
                Date finish = new Date();
                // Вычисляем время работы приложения.
                long period = finish.getTime() - start.getTime();
                // Определяем максимальное время работы приложения.
                if (period > period_max) period_max = period;

                String print_text;
                // Добавляем информацию о времени выполнения, если превысили 1000 мс.
                if (period > limit_time_ms) print_text = "TIME=" + period + "ms ";
                else print_text = "";
                // Добавляем текст об ошибке, если есть.
                if (!result.equals(result_data[i])) {
                    errors_count++;
                    print_text = print_text + "FAILED!";
                    if (logLevel > 0)
                        print_text = " <" + result + "> <" + result_data[i] + ">";
                }
                // Печатаем, если строка вывода теста не пустая.
                if (!print_text.equals("")) {
                    if (logLevel <= 0)
                        System.out.println("TEST: " + (i+1) + " " + print_text);
                    else
                        System.out.println("TEST: " + (i+1) + " " + className + " " + print_text);
                }
            } catch (Exception e) {
            }
        }
        // Финальный блок вывода общих результатов теста.
        String print_text;
        if (errors_count == 0) print_text = "без ошибок";
        else print_text =  "найдено " + errors_count + " ошибок!";
        if (period_max > limit_time_ms) print_text = print_text + " Время=" + period_max + "мс";
        System.out.println(className + " " +print_text);
    }
}
