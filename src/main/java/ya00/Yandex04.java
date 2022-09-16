// CLOUD
// CUPID
// PSIIP

// ALICE
// ELIBO

// ABCBACKYAK
// ZBBAACKAAK
package tests;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * ASQWRETYUIOPKMGDHSNCVXNMLLLLLDJDKSLSLSLSJDHSHGAHDHSABXHDUUUUUUSDSDSOPQAWASAUYERDSBDMKNGGGDFSSSTRETVSVXFSHS
 * ZTQYRYTYUUOPUMIDHSOOOONURLLUIYBGKSIUTYBHJJUHGJAHIMHAMNBJHJUUZZSZSZSOPQAZAZAUYZRDZBZMZNZGGPOSSSREEMNSVNMSHZ
 * ISPIPIPPPSPPSPSPPPIIIIPSSPPSIISSPPIISIISPSISSIPPISSPISIISIPPIIPIPIPPPPPIPIPPPIPPIPIPIPIPPIIPPPISPIIPPIIPPI *
 */

public class Yandex04 {
    private static char NOTE = '*';

    public static void main(String[] args) {
        try (BufferedReader r = new BufferedReader(new FileReader("input.txt"))) {

            StringBuilder J = new StringBuilder(r.readLine());
            String S = r.readLine();
            int i;
            int count = S.length();
            if (count == 0) System.out.println("");
            else {

                char[] R = new char[count];
                for (i = 0; i < R.length; i++)
                    R[i] = NOTE;

                for (i = 0; i < count; ++i) {
                    int index = J.indexOf(String.valueOf(S.charAt(i)));
                    if (index == i) {
                        R[i] = 'P';
                        J.setCharAt(index, NOTE);
                    } else if (index < 0) {
                        R[i] = 'I';
                    }
                }
                for (i = 0; i < count; i++) {
                    if (R[i] == NOTE) {
                        int index = J.indexOf(String.valueOf(S.charAt(i)));
                        if (index >= 0) {
                            R[i] = 'S';
                            J.setCharAt(index, NOTE);
                        } else {
                            R[i] = 'I';
                        }
                    }
                }
                System.out.println(new String(R));
                String orig_result = r.readLine();
                if (orig_result != null) {
                    int num = 0;
                    for (char ch : orig_result.toCharArray()) {
                        if (ch == R[num++]) System.out.print(".");
                        else System.out.print("I");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {

        }
    }
}
