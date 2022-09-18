package testdriver;

import java.io.BufferedWriter;
import java.io.FileWriter;

public abstract class TestDriver {
    public String className = "Unknown";

    protected abstract String work();
    public void runtest(String[] test_data, String[] result_data, int logLevel) {
        int errors_count = 0;
        for (int i = 0; i < test_data.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
                writer.flush();
                writer.write(test_data[i] + "\n");
                writer.close();
                String result = work();
                if (!result.equals(result_data[i])) {
                    errors_count++;
                    if (logLevel == 0)
                        System.out.println("TEST " + i + " FAILED!");
                    else
                        System.out.println("TEST " + i + " " + className + " FAILED! <" + result + "> <" + result_data[i]+">");
                }
            } catch (Exception e) {
            }
        }
        if (errors_count == 0) System.out.println(className+" без ошибок");
        else System.out.println(className+" найдено "+errors_count+" ошибок!");
    }
}
