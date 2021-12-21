package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class pedir {
    public static String leeRespuesta(String frase) {
        boolean valid = false;
        String n = "";
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.next();
                valid = true;
            } catch (InputMismatchException ex) {
                t.next();
                System.out.println("Error");
                valid = false;
            } catch (Exception e) {
                System.out.println("No vale");
            }
        } while (!valid);

        return n;
    }

    public static int leeEntero(String frase) {
        int n = 0;
        boolean valid = false;
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                valid = false;
                t.next();
            }
        } while (!valid || n < 0);

        return n;
    }

    public static double leeDouble(String frase) {
        double n = 0;
        boolean valid = false;
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.nextDouble();
                valid = true;
            } catch (InputMismatchException ex) {
                valid = false;
                t.next();
            }
        } while (!valid || n < 0);

        return n;
    }
}
