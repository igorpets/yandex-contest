package tests;

import java.io.*;
import java.util.*;

/*
Прайсы
*/

public class Test1827 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        if (args.length > 0)
        {       if (args[0].equals("-c")){

            String id = Integer.toString(idCreator(filename));
            FileWriter fw = new FileWriter(filename, true);

            String productName = args[1];
            Double price = Double.parseDouble(args[2]);
            String quantity = args[3];
            id = String.format("%-8s", id);
            productName = String.format("%-30s", productName);
            String strPrice =  String.format("%.2f", price); // String.format("%-8s", price);
            quantity = String.format("%-4s", quantity);

            fw.write('\n' +  id+productName + String.format("%-8s", strPrice) + quantity);
            fw.close();
        }}
        if (args.length == 0){
            System.out.println("Program arguments not found");
        }

    }

    public static int idCreator(String file) throws IOException {
        List<Integer> ids = new ArrayList<>();
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            ids.add(Integer.parseInt(String.format("%."+ 8 +"s", line).replaceAll("\\s","")));
        }
        fr.close();
        return Collections.max(ids)+1;
    }

}