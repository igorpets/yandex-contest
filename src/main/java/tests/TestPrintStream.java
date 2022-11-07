package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestPrintStream {

    public static void main(String arr[]) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("C:\\test.txt"));

        filePrintStream.println(222);
        filePrintStream.println("Hello world");
        filePrintStream.println(false);
    }
}
